package com.vamsi.androidarchitecturemodels.mvc;

import android.widget.Toast;

import com.vamsi.androidarchitecturemodels.model.CountriesApi;
import com.vamsi.androidarchitecturemodels.model.CountriesService;
import com.vamsi.androidarchitecturemodels.model.Country;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MVCActivityController {

    private MVCActivity mvcActivity;

    public MVCActivityController(MVCActivity mvcActivity) {
        this.mvcActivity = mvcActivity;
        fetchData();
    }

    private void fetchData() {
        CountriesService.getCustomerDataFromServer().create(CountriesApi.class).getCountries().enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (response.isSuccessful()) {
                    List<String> countries = new ArrayList<>();
                    for (Country s : response.body()) {
                        countries.add(s.countryName);
                    }
                    mvcActivity.setValues(countries);

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                if (t instanceof SocketTimeoutException) {
                    Toast.makeText(mvcActivity, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


//    public void refresh() {
//    fetchData();
//    }
}
