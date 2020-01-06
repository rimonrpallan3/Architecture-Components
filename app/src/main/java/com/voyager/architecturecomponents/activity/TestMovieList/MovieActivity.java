package com.voyager.architecturecomponents.activity.TestMovieList;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.voyager.architecturecomponents.R;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.adapter.TestListAdapter;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.model.TestList;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.view.TestViewModel;
import com.voyager.architecturecomponents.activity.TestMovieList.adapter.MovieListAdapter;
import com.voyager.architecturecomponents.activity.TestMovieList.model.Results;
import com.voyager.architecturecomponents.activity.TestMovieList.view.MovieListViewModel;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    private MovieListViewModel movieListViewModel;

    MovieListAdapter mMovieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        initializationViews();
        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        getTestList();
        // lambda expression
        swipeRefresh.setOnRefreshListener(() -> {
            getTestList();
        });
    }

    public void getTestList() {
        swipeRefresh.setRefreshing(true);
        movieListViewModel.getAllMovieList().observe(this, new Observer<ArrayList<Results>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Results> results) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(results);
            }
        });
    }

    private void initializationViews() {
        swipeRefresh = findViewById(R.id.swipeRefresh);
        mRecyclerView = findViewById(R.id.rvMovieList);
    }


    private void prepareRecyclerView(ArrayList<Results> results) {

        mMovieListAdapter = new MovieListAdapter(results);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        //mListAdapter.setTestList(testLists);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mMovieListAdapter);
        mMovieListAdapter.notifyDataSetChanged();

    }

}
