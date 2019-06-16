package com.example.bustec.AdaptadoresApi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.bustec.Clases.Rutas;
import com.example.bustec.Interfaces.ApiServiceRutas;
import com.example.bustec.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class AdaptadorBuses extends RecyclerView.Adapter<AdaptadorBuses.ViewHolder>{

private List<Rutas> viajes;

public AdaptadorBuses(){
        this.viajes=new ArrayList<>();
        }

public void setBuses(List<Rutas> viajes){
        this.viajes=viajes;
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView placaText;
    public TextView nombreconductorText;
    public TextView correoconductorText;
    public ImageView imagenconductorImg;

    public ViewHolder(View itemView) {
        super(itemView);
        placaText = itemView.findViewById(R.id.numero_placa);
        nombreconductorText = itemView.findViewById(R.id.nombre_condutor);
        correoconductorText=itemView.findViewById(R.id.numero_bus);
        imagenconductorImg=itemView.findViewById(R.id.imagen_carro);
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

        Rutas rutas= this.viajes.get(position);
        viewHolder.placaText.setText(rutas.getBus().getPlaca());
        viewHolder.nombreconductorText.setText(rutas.getConductor().getNombre());
        viewHolder.correoconductorText.setText(rutas.getConductor().getCorreo());
//        String url = ApiServiceRutas.API_BASE_URL + "/viajes/buses/" + viajes();
//        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.imagenconductorImg);
    }

    @Override
    public int getItemCount() {

         return this.viajes.size();
    }
}
