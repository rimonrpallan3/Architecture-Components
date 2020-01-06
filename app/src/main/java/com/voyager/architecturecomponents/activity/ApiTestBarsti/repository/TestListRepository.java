package com.voyager.architecturecomponents.activity.ApiTestBarsti.repository;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.model.TestList;
import com.voyager.architecturecomponents.activity.ApiTestBarsti.model.TestWrapper;
import com.voyager.architecturecomponents.activity.Bloger.model.BlogWrapper;
import com.voyager.architecturecomponents.apiService.RestApiService;
import com.voyager.architecturecomponents.apiService.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TestListRepository {

    private ArrayList<TestList> testLists = new ArrayList<>();
    private MutableLiveData<ArrayList<TestList>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public TestListRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<ArrayList<TestList>> getMutableLiveData() {

        RestApiService apiService = RetrofitInstance.getApiService();
        /*Observable<TestWrapper> getLoginObservable;

        getLoginObservable = apiService.getTestList2();

        getLoginObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getTestList());*/


        Call<ArrayList<TestList>> call = apiService.getTestList();

        call.enqueue(new Callback<ArrayList<TestList>>() {
            @Override
            public void onResponse(Call<ArrayList<TestList>> call, Response<ArrayList<TestList>> response) {
                List<TestList> mTestLists = response.body();
                if (mTestLists != null ) {
                    testLists = (ArrayList<TestList>) mTestLists;
                    mutableLiveData.setValue(testLists);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TestList>> call, Throwable t) {

            }
        });


        return mutableLiveData;
    }



   /* private Observer<TestWrapper> getTestList() {
        return new Observer<TestWrapper>() {

            @Override
            public void onSubscribe(Disposable d) {

                Log.d("LoginPresenter", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(TestWrapper value) {
                TestWrapper mTestWrapper = value;
                if (mTestWrapper != null || mTestWrapper.getTesstTestLists() != null) {
                    testLists = (ArrayList<TestList>) mTestWrapper.getTesstTestLists();
                    mutableLiveData.setValue(testLists);
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(TAG+" --------- onError : "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("LoginPresenter", " onComplete");
            }
        };
    }*/
}
