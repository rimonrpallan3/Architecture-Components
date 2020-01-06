package com.voyager.architecturecomponents.activity.Bloger;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;

import com.voyager.architecturecomponents.R;
import com.voyager.architecturecomponents.activity.Bloger.adapter.bloger.BlogAdapter;
import com.voyager.architecturecomponents.activity.Bloger.model.Blog;
import com.voyager.architecturecomponents.activity.Bloger.view.MainViewModel;

import java.util.List;

public class BlogerActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    private MainViewModel mainViewModel;

    BlogAdapter mBlogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloger);
        initializationViews();
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        getPopularBlog();
        // lambda expression
        swipeRefresh.setOnRefreshListener(() -> {
            getPopularBlog();
        });
    }


    private void initializationViews() {
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.blogRecyclerView);
    }

    public void getPopularBlog() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getAllBlog().observe(this, new Observer<List<Blog>>() {
            @Override
            public void onChanged(@Nullable List<Blog> blogList) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(blogList);
            }
        });
    }

    private void prepareRecyclerView(List<Blog> blogList) {

        mBlogAdapter = new BlogAdapter(blogList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mBlogAdapter);
        mBlogAdapter.notifyDataSetChanged();

    }
}
