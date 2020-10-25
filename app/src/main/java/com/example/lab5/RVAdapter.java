package com.example.lab5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonaViewHolder>{

    List<Perros> perros;
    Context context;

    public RVAdapter(List<Perros> personas, Context context) {
        this.perros = personas;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.perro,parent,false);
        PersonaViewHolder personaViewHolder = new PersonaViewHolder(view);
        return personaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.nombrePerro.setText(perros.get(position).raza);
        holder.edadPerro.setText(perros.get(position).edad);
        holder.descripcionPerro.setText(perros.get(position).descripcion);

        Drawable original = context.getResources().getDrawable(perros.get(position).foto,null);
        Bitmap originalBitmap = ((BitmapDrawable)original).getBitmap();
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(),originalBitmap);
        roundedBitmapDrawable.setCornerRadius(originalBitmap.getHeight());

        holder.fotoPerro.setImageDrawable(roundedBitmapDrawable);
    }

    @Override
    public int getItemCount() {
        return perros.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView nombrePerro;
        TextView edadPerro;
        TextView descripcionPerro;
        ImageView fotoPerro;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cv);
            nombrePerro = (TextView) itemView.findViewById(R.id.nombrePerro);
            edadPerro = (TextView) itemView.findViewById(R.id.edadPerro);
            descripcionPerro = (TextView) itemView.findViewById(R.id.descripcionPerro);
            fotoPerro = (ImageView) itemView.findViewById(R.id.fotoPerro);
        }
    }

}
