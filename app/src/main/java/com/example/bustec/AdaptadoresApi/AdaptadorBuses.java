package com.example.bustec.AdaptadoresApi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bustec.Clases.Buses;

import com.example.bustec.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorBuses extends RecyclerView.Adapter<AdaptadorBuses.ViewHolder>{

private List<Buses> buses;

public AdaptadorBuses(){
        this.buses=new ArrayList<>();
        }

public void setBuses(List<Buses> buses){
        this.buses=buses;
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView placaText;
    public ViewHolder(View itemView) {
        super(itemView);
        placaText = itemView.findViewById(R.id.numero_placa);

    }

}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_buses, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Buses buses = this.buses.get(position);
        viewHolder.placaText.setText(buses.getPlaca());
    }

    @Override
    public int getItemCount() {

         return this.buses.size();
    }
}
