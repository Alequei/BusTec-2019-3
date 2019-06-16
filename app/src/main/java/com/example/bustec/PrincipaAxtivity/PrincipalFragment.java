package com.example.bustec.PrincipaAxtivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bustec.AdaptadoresApi.AdaptadorBuses;
import com.example.bustec.Clases.Buses;
import com.example.bustec.Interfaces.ApiServiceBus;
import com.example.bustec.R;
import com.example.bustec.Servidores.ApiServicioBusGenerador;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalFragment extends Fragment {

    private static final String TAG = PrincipalFragment.class.getSimpleName();
    private RecyclerView busesList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_principal, container, false);
        busesList = view.findViewById(R.id.list_bus);
        busesList.setLayoutManager(new LinearLayoutManager(getContext()));
        busesList.setAdapter(new AdaptadorBuses());
        initialize();
        return view;
    }


    private void initialize() {
        ApiServiceBus service = ApiServicioBusGenerador.createService(ApiServiceBus.class);

        Call<List<Buses>> call = service.getbuses();

        call.enqueue(new Callback<List<Buses>>() {
            @Override
            public void onResponse(Call<List<Buses>> call1 , Response<List<Buses>> response) {
                try {

                    int code = response.code();
                    Log.d(TAG, "HTTP status code: " + code);

                    if (response.isSuccessful()) {

                        List<Buses> buses= response.body();
                        Log.d(TAG, "buses: " + buses);

                        AdaptadorBuses adapter = (AdaptadorBuses) busesList.getAdapter();
                        adapter.setBuses(buses);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Buses>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }


}
