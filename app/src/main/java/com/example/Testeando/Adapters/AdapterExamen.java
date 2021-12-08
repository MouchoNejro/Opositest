package com.example.Testeando.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Testeando.R;
import com.example.Testeando.javaclass.PreguntaExamen;

import java.util.ArrayList;

public class AdapterExamen extends RecyclerView.Adapter<AdapterExamen.MyViewHolder> {

    Context context;
    ArrayList<PreguntaExamen>list;

    public AdapterExamen(Context context, ArrayList<PreguntaExamen> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterExamen.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_examen, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        PreguntaExamen preguntaExamen = list.get(position);

        holder.pregunta.setText(preguntaExamen.getPregunta());
        holder.resp1.setText(preguntaExamen.getResp1());
        holder.resp2.setText(preguntaExamen.getResp2());
        holder.resp3.setText(preguntaExamen.getResp3());
        holder.resp4.setText(preguntaExamen.getResp4());
        holder.correcta.setText(preguntaExamen.getCorrecta());

        }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView pregunta, correcta;
        RadioButton resp1, resp2, resp3,resp4;
        RadioGroup rgrex;

        public MyViewHolder(@NonNull View View) {
            super(View);

            rgrex=View.findViewById(R.id.rgrex);
            pregunta = View.findViewById(R.id.tvpreguntaex2);
            resp1 = View.findViewById(R.id.tvresp1);
            resp2 = View.findViewById(R.id.tvresp2);
            resp3 = View.findViewById(R.id.tvresp3);
            resp4 = View.findViewById(R.id.tvresp4);
            correcta = View.findViewById(R.id.tvcorrecta);

        }
    }



}




