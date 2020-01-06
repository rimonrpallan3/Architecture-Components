package com.voyager.architecturecomponents.activity.TestMovieList.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.voyager.architecturecomponents.R;
import com.voyager.architecturecomponents.activity.TestMovieList.MProfileActivity;
import com.voyager.architecturecomponents.activity.TestMovieList.adapter.helper.BaseViewHolder;
import com.voyager.architecturecomponents.activity.TestMovieList.model.Results;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "BlogAdapter";

    private ArrayList<Results> mResults;

    public MovieListAdapter(ArrayList<Results> mResults) {
        this.mResults = mResults;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieListAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false));


    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mResults != null || mResults.size() > 0) {
            return mResults.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends BaseViewHolder {


        ConstraintLayout clMovieItem;
        ImageView ivMovie;
        TextView tvMovieTitle;
        TextView tvDirector;
        TextView tvProducer;
        TextView tvReleaseDate;

        public ViewHolder(View itemView) {
            super(itemView);
            clMovieItem = itemView.findViewById(R.id.clMovieItem);
            ivMovie = itemView.findViewById(R.id.ivMovie);
            tvMovieTitle = itemView.findViewById(R.id.tvMovieTitle);
            tvDirector = itemView.findViewById(R.id.tvDirector);
            tvProducer = itemView.findViewById(R.id.tvProducer);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);

        }

        protected void clear() {
            ivMovie.setImageDrawable(null);
            tvMovieTitle.setText("");
            tvDirector.setText("");
            tvProducer.setText("");
            tvReleaseDate.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Results mResult = mResults.get(position);

            if (mResult.getImgUrl() != null) {
                Glide.with(itemView.getContext())
                        .load(mResult.getImgUrl())
                        .into(ivMovie);
            }else {
                Glide.with(itemView.getContext())
                        .load(R.drawable.ic_local_movies)
                        .into(ivMovie);
            }

            if (mResult.getTitle() != null) {
                tvMovieTitle.setText(mResult.getTitle());
            }

            if (mResult.getDirector() != null) {
                tvDirector.setText("Director : "+mResult.getDirector());
            }

            if (mResult.getProducer() != null) {
                tvProducer.setText("Producer : "+mResult.getProducer());
            }

            if (mResult.getRelease_date() != null) {
                tvReleaseDate.setText("ReleaseDate : "+mResult.getRelease_date());
            }

            clMovieItem.setOnClickListener(v -> {
                if (mResult!= null) {
                    try {
                        Intent myIntent = new Intent(itemView.getContext(), MProfileActivity.class);
                        myIntent.putExtra("Results", mResult); //Optional parameters
                        itemView.getContext().startActivity(myIntent);
                    } catch (Exception e) {
                        Log.e(TAG, "onClick: Position is null");
                    }
                }
            });
        }
    }

}