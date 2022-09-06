package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.FilmViewHolder>{

    private ArrayList<Film> filmList;

    public static class FilmViewHolder extends RecyclerView.ViewHolder {

        TextView itemFilmTitle;
        TextView itemFilmDescription;
        TextView itemFilmDirector;
        TextView itemFilmRelease;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            itemFilmTitle = itemView.findViewById(R.id.itemFilmTitle);
            itemFilmDescription = itemView.findViewById(R.id.itemFilmDescription);
            itemFilmDirector = itemView.findViewById(R.id.itemFilmDirector);
            itemFilmRelease = itemView.findViewById(R.id.itemFilmRelease);
        }
    }

    public FilmListAdapter(ArrayList<Film> filmList) {
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_film,parent,false);

        FilmViewHolder viewHolder = new FilmViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.itemFilmTitle.setText(filmList.get(position).getTitle());
        holder.itemFilmDescription.setText(filmList.get(position).getDescription());
        holder.itemFilmDirector.setText(filmList.get(position).getDirector());
        holder.itemFilmRelease.setText(filmList.get(position).getRelease());
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }
}
