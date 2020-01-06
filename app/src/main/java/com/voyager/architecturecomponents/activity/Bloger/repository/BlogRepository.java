package com.voyager.architecturecomponents.activity.Bloger.repository;

import android.app.Application;

import com.voyager.architecturecomponents.activity.Bloger.model.Blog;
import com.voyager.architecturecomponents.activity.Bloger.model.BlogWrapper;
import com.voyager.architecturecomponents.apiService.RestApiService;
import com.voyager.architecturecomponents.apiService.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogRepository {
    private ArrayList<Blog> movies = new ArrayList<>();
    private MutableLiveData<List<Blog>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public BlogRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Blog>> getMutableLiveData() {

        RestApiService apiService = RetrofitInstance.getApiService();

        Call<BlogWrapper> call = apiService.getPopularBlog();

        call.enqueue(new Callback<BlogWrapper>() {
            @Override
            public void onResponse(Call<BlogWrapper> call, Response<BlogWrapper> response) {
                BlogWrapper mBlogWrapper = response.body();
                if (mBlogWrapper != null || mBlogWrapper.getBlog() != null) {
                    movies = (ArrayList<Blog>) mBlogWrapper.getBlog();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<BlogWrapper> call, Throwable t) {

            }
        });


        return mutableLiveData;
    }
}
