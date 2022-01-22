package com.example.bakcsygergoprojekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    private Context context ;
    private List<Movie> movieList ;


    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView year;
        TextView type;
        ImageView poster;


        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titlev) ;
            year = itemView.findViewById(R.id.year);
            type = itemView.findViewById(R.id.type);
            poster = itemView.findViewById(R.id.poster);
        }
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        Picasso.get().load(movie.getPoster()).into(holder.poster);
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        holder.type.setText(movie.getType());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
