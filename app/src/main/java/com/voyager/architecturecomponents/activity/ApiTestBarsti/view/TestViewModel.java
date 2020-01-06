package com.voyager.architecturecomponents.activity.ApiTestBarsti.view;

import android.app.Application;

import com.voyager.architecturecomponents.activity.ApiTestBarsti.model.TestList;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.repository.TestListRepository;
import com.voyager.architecturecomponents.activity.Bloger.model.Blog;
import com.voyager.architecturecomponents.activity.Bloger.repository.BlogRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TestViewModel extends AndroidViewModel {

    private TestListRepository testListRepository;

    public TestViewModel(@NonNull Application application) {
        super(application);
        testListRepository = new TestListRepository(application);
    }

    public LiveData<ArrayList<TestList>> getAllList() {
        return testListRepository.getMutableLiveData();
    }
}
