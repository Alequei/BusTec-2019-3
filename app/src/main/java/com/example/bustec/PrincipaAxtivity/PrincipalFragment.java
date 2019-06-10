package com.example.bustec.PrincipaAxtivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bustec.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

//    private static final String TAG = MainActivity.class.getSimpleName();
//    private RecyclerView busesList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_principal, container, false);
//
//        busesList.setLayoutManager(new LinearLayoutManager(getContext()));
//        initialize();
        return view;
    }
/*

    private void initialize() {
        ApiServiceBus service = ApiServicioBusGenerador.createService(ApiServiceBus.class);

        Call<List<Buses>> call = service.getbuses();

        call.enqueue(new Callback<List<Buses>>() {
            @Override
            public void onResponse(Call<List<Buses>> call, Response<List<Buses>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

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
*/

}
