package com.example.Testeando.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Testeando.R;
import com.example.Testeando.javaclass.EspecialidadesHelperClass;

import java.util.ArrayList;

public class EspecialidadesAdapter extends RecyclerView.Adapter<EspecialidadesAdapter.EspecialidadesViewHolder>{

    ArrayList<EspecialidadesHelperClass> especialidades;

    private RecyclerViewClickListener listener;

    public EspecialidadesAdapter(ArrayList<EspecialidadesHelperClass> especialidades, EspecialidadesAdapter.RecyclerViewClickListener listener) {
        this.especialidades = especialidades;
        this.listener=listener;
    }

    @NonNull
    @Override
    public EspecialidadesAdapter.EspecialidadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.especialidades_card,parent,false);
        EspecialidadesAdapter.EspecialidadesViewHolder especialidadesViewHolder = new EspecialidadesAdapter.EspecialidadesViewHolder(view);
        return especialidadesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EspecialidadesAdapter.EspecialidadesViewHolder holder, int position) {

        EspecialidadesHelperClass ayuditaespecial = especialidades.get(position);
        holder.image.setImageResource(ayuditaespecial.getImage());
        holder.title.setText(ayuditaespecial.getTitle());
        holder.desc.setText(ayuditaespecial.getDescription());
    }

    @Override
    public int getItemCount() {


        return especialidades.size();
    }


    public interface RecyclerViewClickListener{

        void onClick(View v,int position);

    }


    public class EspecialidadesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final Context context;

        ImageView image;

        TextView title,desc;

        public EspecialidadesViewHolder(@NonNull View view) {
            super(view);
            context = view.getContext();
            view.setOnClickListener(this);
            //Ganchos

            image = view.findViewById(R.id.deporte);
            title = view.findViewById(R.id.tituloespecial);
            desc = view.findViewById(R.id.descespecial);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }


public interface ItemClickListener {
    void onItemClick(View view, int position);
}
}

