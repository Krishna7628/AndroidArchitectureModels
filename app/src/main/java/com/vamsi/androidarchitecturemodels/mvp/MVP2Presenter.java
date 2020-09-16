package com.vamsi.androidarchitecturemodels.mvp;

import android.app.ProgressDialog;

public class MVP2Presenter implements MVP2Contract.LoginListenser {


    MVP2Contract.View view;
    MVP2Interactor mvp2Interactor;

    public MVP2Presenter(MVP2Contract.View view) {
        this.view = view;
        mvp2Interactor = new MVP2Interactor(this);
    }

    public void start(String userName, String password){
        view.showProgressBar();
        mvp2Interactor.login(userName, password);
    }

    @Override
    public void onSuccess() {
        view.dismissProgressBar();
        view.onSuccess();
    }

    @Override
    public void onError(String msg) {
        view.dismissProgressBar();
        view.onError(msg);
    }
}
