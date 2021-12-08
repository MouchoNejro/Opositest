package com.example.Testeando.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Testeando.R;
import com.example.Testeando.javaclass.OposPorCaHelperClass;

import java.util.ArrayList;

public class OposPorCaAdapter extends RecyclerView.Adapter<OposPorCaAdapter.OposPorCaViewHolder> {


    ArrayList<OposPorCaHelperClass> featuredOpos;

    private RecyclerViewClickListener listener;

    public OposPorCaAdapter(ArrayList<OposPorCaHelperClass> featuredOpos,OposPorCaAdapter.RecyclerViewClickListener listener) {
        this.featuredOpos = featuredOpos;
        this.listener=listener;
    }


    @NonNull
    @Override
    public OposPorCaAdapter.OposPorCaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.opos_por_ca, parent, false);
        OposPorCaViewHolder oposPorCaViewHolder = new OposPorCaViewHolder(view);
        return oposPorCaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OposPorCaViewHolder holder, int position) {

        OposPorCaHelperClass ayudita = featuredOpos.get(position);

        holder.image.setImageResource(ayudita.getImage());
        holder.title.setText(ayudita.getTitle());
        holder.desc.setText(ayudita.getDescription());

    }

    @Override
    public int getItemCount() {
        return featuredOpos.size();
    }


    public interface RecyclerViewClickListener{

        void onClick(View v,int position);

    }

    public class OposPorCaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout relativeLayout;

        ImageView image;

        TextView title, desc;

        public OposPorCaViewHolder(@NonNull View view) {
            super(view);


            //Ganchos

            image = view.findViewById(R.id.galiza);
            title = view.findViewById(R.id.titulo);
            desc = view.findViewById(R.id.desc);

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


