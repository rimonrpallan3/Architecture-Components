package com.voyager.architecturecomponents.activity.TestMovieList.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.voyager.architecturecomponents.activity.Bloger.model.Blog;
import com.voyager.architecturecomponents.activity.Bloger.model.BlogWrapper;
import com.voyager.architecturecomponents.activity.TestMovieList.model.MovieListsWrapper;
import com.voyager.architecturecomponents.activity.TestMovieList.model.Results;
import com.voyager.architecturecomponents.apiService.RestApiService;
import com.voyager.architecturecomponents.apiService.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListsRepository {
    private ArrayList<Results> movies = new ArrayList<>();
    private MutableLiveData<ArrayList<Results>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieListsRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<ArrayList<Results>> getMutableLiveData() {

        RestApiService apiService = RetrofitInstance.getApiService();

        Call<MovieListsWrapper> call = apiService.getMovieList();

        call.enqueue(new Callback<MovieListsWrapper>() {
            @Override
            public void onResponse(Call<MovieListsWrapper> call, Response<MovieListsWrapper> response) {
                MovieListsWrapper mMovieListsWrapper = response.body();
                if (mMovieListsWrapper != null || mMovieListsWrapper.getResults() != null) {
                    movies = (ArrayList<Results>) mMovieListsWrapper.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<MovieListsWrapper> call, Throwable t) {

            }
        });


        return mutableLiveData;
    }
}
