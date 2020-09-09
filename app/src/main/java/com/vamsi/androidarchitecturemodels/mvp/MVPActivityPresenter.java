package com.vamsi.androidarchitecturemodels.mvp;

import android.view.View;
import android.widget.Toast;

import com.vamsi.androidarchitecturemodels.model.CountriesApi;
import com.vamsi.androidarchitecturemodels.model.CountriesService;
import com.vamsi.androidarchitecturemodels.model.Country;
import com.vamsi.androidarchitecturemodels.mvc.MVCActivity;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MVPActivityPresenter {

    private View view;
    public MVPActivityPresenter(View view) {
       this.view = view;
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
                    view.setValues(countries);

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                if (t instanceof SocketTimeoutException) {
                    view.setError();
                }
            }
        });
    }


    public interface View{
        void setValues(List<String> countries);
        void setError();
    }


}
