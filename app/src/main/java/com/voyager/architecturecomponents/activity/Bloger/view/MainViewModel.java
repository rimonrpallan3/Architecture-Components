package com.voyager.architecturecomponents.activity.Bloger.view;

import android.app.Application;

import com.voyager.architecturecomponents.activity.Bloger.model.Blog;
import com.voyager.architecturecomponents.activity.Bloger.repository.BlogRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {

    private BlogRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new BlogRepository(application);
    }

    public LiveData<List<Blog>> getAllBlog() {
        return movieRepository.getMutableLiveData();
    }

}
