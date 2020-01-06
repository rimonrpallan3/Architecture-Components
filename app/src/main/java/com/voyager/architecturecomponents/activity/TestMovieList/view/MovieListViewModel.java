package com.voyager.architecturecomponents.activity.TestMovieList.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.voyager.architecturecomponents.activity.ApiTestBarsti.model.TestList;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.repository.TestListRepository;
import com.voyager.architecturecomponents.activity.TestMovieList.model.MovieListsWrapper;
import com.voyager.architecturecomponents.activity.TestMovieList.model.Results;
import com.voyager.architecturecomponents.activity.TestMovieList.repository.MovieListsRepository;

import java.util.ArrayList;

public class MovieListViewModel extends AndroidViewModel {

    private MovieListsRepository movieListsRepository;

    public MovieListViewModel(@NonNull Application application) {
        super(application);
        movieListsRepository = new MovieListsRepository(application);
    }

    public LiveData<ArrayList<Results>> getAllMovieList() {
        return movieListsRepository.getMutableLiveData();
    }
}
