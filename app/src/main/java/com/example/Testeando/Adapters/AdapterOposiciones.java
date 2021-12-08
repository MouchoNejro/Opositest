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

public class AdapterOposiciones extends RecyclerView.Adapter<AdapterOposiciones.MyViewHolder>
implements View.OnClickListener{

    ArrayList <Oposicion> data1;
    Context context;

    private View.OnClickListener listener;

    public AdapterOposiciones (Context ct, ArrayList<Oposicion> s1){
        context = ct;
        data1 = s1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_oposiciones, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText.setText(data1.get(position).getTitulo());
        holder.myImage.setImageResource(data1.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return data1.size();
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

        TextView myText;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText = itemView.findViewById(R.id.tvOpos);
            myImage = itemView.findViewById(R.id.imageViewOpos);
        }
    }
}
