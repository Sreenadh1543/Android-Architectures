package com.example.androidarchitectures.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryService {
    private static final String BASE_URL="https://restcountries.eu/rest/v2/";
    private CountriesApi api;
    public CountryService(){
        Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        Retrofit retrofit=builder.build();
        api=retrofit.create(CountriesApi.class);
    }

    public Single<List<Country>> getCountries(){
        return api.getCountries();
    }
}
