package com.vamsi.androidarchitecturemodels.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountriesApi {
    @GET("all")
    Call<List<Country>> getCountries();
}
