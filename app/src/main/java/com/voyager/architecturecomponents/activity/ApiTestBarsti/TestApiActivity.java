package com.voyager.architecturecomponents.activity.ApiTestBarsti;

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
import com.voyager.architecturecomponents.activity.ApiTestBarsti.adapter.TestListAdapter;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.model.TestList;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.view.TestViewModel;
import com.voyager.architecturecomponents.activity.Bloger.adapter.bloger.BlogAdapter;
import com.voyager.architecturecomponents.activity.Bloger.model.Blog;
import com.voyager.architecturecomponents.activity.Bloger.view.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class TestApiActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    private TestViewModel testViewModel;

    TestListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_api);

        initializationViews();
        testViewModel = new ViewModelProvider(this).get(TestViewModel.class);
        getTestList();
        // lambda expression
        swipeRefresh.setOnRefreshListener(() -> {
            getTestList();
        });
    }

    public void getTestList() {
        swipeRefresh.setRefreshing(true);
        testViewModel.getAllList().observe(this, new Observer<ArrayList<TestList>>() {
            @Override
            public void onChanged(@Nullable ArrayList<TestList> testLists) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(testLists);
            }
        });
    }

    private void initializationViews() {
        swipeRefresh = findViewById(R.id.swipeRefresh);
        mRecyclerView = findViewById(R.id.testListRecyclerView);
    }


    private void prepareRecyclerView(ArrayList<TestList> testLists) {

        mListAdapter = new TestListAdapter(this,testLists);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        }
        //mListAdapter.setTestList(testLists);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.notifyDataSetChanged();

    }

}
