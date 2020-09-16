package com.vamsi.androidarchitecturemodels.mvp;

public interface MVP3Contract {

    interface View {
        void onSuccess();

        void onError(String msg);

        void displayProgress();

        void dismissProgress();
    }

    interface loginListener{
        void loginListener(String userName, String password);
    }

}
