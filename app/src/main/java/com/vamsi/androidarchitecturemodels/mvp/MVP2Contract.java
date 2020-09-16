package com.vamsi.androidarchitecturemodels.mvp;

public interface MVP2Contract {

    interface View{
        void onSuccess();
        void onError(String msg);
        void showProgressBar();
        void dismissProgressBar();
    }


    interface LoginListenser{
        void onSuccess();
        void onError(String msg);
    }

}
