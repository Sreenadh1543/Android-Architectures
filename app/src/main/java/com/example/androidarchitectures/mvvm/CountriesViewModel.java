package com.example.androidarchitectures.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidarchitectures.model.Country;
import com.example.androidarchitectures.model.CountryService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesViewModel extends ViewModel {

    private CountryService service;

    private final MutableLiveData<List<String>> countries = new MutableLiveData<>();
    private final MutableLiveData<Boolean> countryError = new MutableLiveData<>();


    public MutableLiveData<List<String>> getCountries() {
        return countries;
    }

    public MutableLiveData<Boolean> getCountryError() {
        return countryError;
    }

    public CountriesViewModel(){
        service = new CountryService();
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
                        countries.setValue(countryNames);
                        countryError.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {

                        countryError.setValue(true);
                    }
                });
    }


    public void onRefresh() {
        fetchCountries();
    }

}
