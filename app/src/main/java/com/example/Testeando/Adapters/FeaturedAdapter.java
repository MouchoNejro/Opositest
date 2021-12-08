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
import com.example.Testeando.javaclass.FeaturedHelperClass;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder>{

            ArrayList<FeaturedHelperClass> featuredTest;

            private RecyclerViewClickListener listener;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredTest,RecyclerViewClickListener listener) {
        this.featuredTest = featuredTest;
        this.listener=listener;

    }



    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_desing,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);


        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelperClass featuredHelperClass = featuredTest.get(position);
        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());


    }

    @Override
    public int getItemCount() {
        return featuredTest.size();
    }

    public interface RecyclerViewClickListener{

        void onClick(View v,int position);

    }




    public  class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final Context context;
        ImageView image;

        TextView title,desc;

        public FeaturedViewHolder(@NonNull View view) {
            super(view);
            context = view.getContext();
            view.setOnClickListener(this);
            //Ganchos

            image = view.findViewById(R.id.featured_image);
            title = view.findViewById(R.id.featured_title);
            desc = view.findViewById(R.id.featured_desc);

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
