package com.voyager.architecturecomponents.apiService;

import com.voyager.architecturecomponents.appConfig.AppConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    public static RestApiService getApiService() {
        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(AppConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(RestApiService.class);

    }
}
