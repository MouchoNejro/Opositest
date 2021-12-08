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
import com.example.Testeando.javaclass.Oposicion;

import java.util.ArrayList;

public class AdapterAuto extends RecyclerView.Adapter<AdapterAuto.MyViewHolder>
        implements View.OnClickListener{

    ArrayList<Oposicion> data2;
    Context context;

    private View.OnClickListener listener;

    public AdapterAuto (Context ct, ArrayList<Oposicion> s2){
        context = ct;
        data2 = s2;
    }

    @NonNull
    @Override
    public AdapterAuto.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_auto, parent, false);
        view.setOnClickListener(this);
        return new AdapterAuto.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAuto.MyViewHolder holder, int position) {
        holder.myText2.setText(data2.get(position).getTitulo());
        holder.myImage2.setImageResource(data2.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return data2.size();
    }

    @Override
    public void onClick(View view){
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText2;
        ImageView myImage2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText2 = itemView.findViewById(R.id.tvAuto);
            myImage2 = itemView.findViewById(R.id.imageViewAuto);
        }
    }
}