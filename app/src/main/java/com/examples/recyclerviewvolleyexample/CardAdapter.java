package com.examples.recyclerviewvolleyexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jani on 01-04-2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

//    private ImageLoader imageLoader;
    private Context context;

    //List of superHeroes
    List<SuperHeroes> superHeroes;

    public CardAdapter(List<SuperHeroes> superHeroes, Context context){
        super();
        //Getting all the superheroes
        this.superHeroes = superHeroes;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.superheroes_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SuperHeroes superHero =  superHeroes.get(position);

        //imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        //imageLoader.get(superHero.getImageUrl(), ImageLoader.getImageListener(holder.imageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));


        Picasso.with(context).load(superHero.getImageUrl()).resize(400,400).into(holder.imageView);
       // holder.imageView.setImageUrl(superHero.getImageUrl(), imageLoader);
        holder.textViewName.setText(superHero.getName());
        holder.textViewRank.setText(String.valueOf(superHero.getRank()));
        holder.textViewRealName.setText(superHero.getRealName());
        holder.textViewCreatedBy.setText(superHero.getCreatedBy());
        holder.textViewFirstAppearance.setText(superHero.getFirstAppearance());

        String powers = "";

        for(int i = 0; i<superHero.getPowers().size(); i++){
            powers+= superHero.getPowers().get(i);
        }

        holder.textViewPowers.setText(powers);
    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textViewName;
        public TextView textViewRank;
        public TextView textViewRealName;
        public TextView textViewCreatedBy;
        public TextView textViewFirstAppearance;
        public TextView  textViewPowers;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewHero);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewRank= (TextView) itemView.findViewById(R.id.textViewRank);
            textViewRealName= (TextView) itemView.findViewById(R.id.textViewRealName);
            textViewCreatedBy= (TextView) itemView.findViewById(R.id.textViewCreatedBy);
            textViewFirstAppearance= (TextView) itemView.findViewById(R.id.textViewFirstAppearance);
            textViewPowers= (TextView) itemView.findViewById(R.id.textViewPowers);
        }
    }
}
