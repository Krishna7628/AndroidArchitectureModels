package com.vamsi.androidarchitecturemodels.mvp;

public class MVP3Presenter implements MVP3Contract.loginListener {


    MVP3Contract.View view;

    MVP3Presenter(MVP3Contract.View view){
        this.view = view;
    }

    @Override
    public void loginListener(String userName, String password) {

        //call or validation




    }
}
