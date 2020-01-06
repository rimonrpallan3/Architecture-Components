package com.voyager.architecturecomponents.apiService;

import com.voyager.architecturecomponents.activity.ApiTestBarsti.model.TestList;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.model.TestWrapper;
import com.voyager.architecturecomponents.activity.Bloger.model.BlogWrapper;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface  RestApiService {

    @GET("feed.json")
    Call<BlogWrapper> getPopularBlog();
    @GET("locations/10/0")
    Call<ArrayList<TestList>> getTestList();
    @GET("locations/10/0")
    Observable<ArrayList<TestList>> getTestList2();
}
