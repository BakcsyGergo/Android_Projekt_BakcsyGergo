package com.example.projekt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.VH>{
    private Activity mContext;
    private List<Movie> mMovies;

    public MoviesAdapter(Activity mContext, List<Movie> mMovies) {
        this.mContext = mContext;
        this.mMovies = mMovies;
    }


    @NonNull
    @Override
    public MoviesAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new VH(itemView, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.VH holder, int position) {
        Movie movie = mMovies.get(position);
        holder.rootView.setTag(movie);
        holder.moName.setText(movie.getName());
        holder.moGenre.setText(movie.getGenre());
        holder.moLength.setText(movie.getLength());
        Glide.with(mContext).load(movie.getDrawable()).centerCrop().into(holder.imPoster);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        final View rootView;
        final ImageView imPoster;
        final TextView moName;
        final TextView moGenre;
        final TextView moLength;

        public VH(View itemView, final Context context) {
            super(itemView);
            rootView = itemView;
            imPoster = (ImageView)itemView.findViewById(R.id.image);
            moName = (TextView)itemView.findViewById(R.id.name);
            moGenre = (TextView)itemView.findViewById(R.id.genre);
            moLength = (TextView)itemView.findViewById(R.id.length);



        }
        
    }
}
