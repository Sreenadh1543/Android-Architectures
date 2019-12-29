package com.example.androidarchitectures.mvp;

import com.example.androidarchitectures.model.Country;
import com.example.androidarchitectures.model.CountryService;
import com.example.androidarchitectures.mvc.MvcActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesPresenter {

    private View view;
    private CountryService service;

    public CountriesPresenter(View view){
        this.view=view;
        this.service=new CountryService();
        fetchCountries();
    }

    private void fetchCountries() {
        service.getCountries().
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeWith(new DisposableSingleObserver<List<Country>>() {
                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<>();
                        for(Country country:value){
                            countryNames.add(country.getCountryName());
                        }
                        view.setValues(countryNames);
                    }

                    @Override
                    public void onError(Throwable e) {

                        view.onError();
                    }
                });
    }


    public void onRefresh() {
        fetchCountries();
    }
}
