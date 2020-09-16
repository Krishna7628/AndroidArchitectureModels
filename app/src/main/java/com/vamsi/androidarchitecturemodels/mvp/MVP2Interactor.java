package com.vamsi.androidarchitecturemodels.mvp;

import android.text.TextUtils;
import android.util.Patterns;

public class MVP2Interactor {

    private MVP2Contract.LoginListenser view;

    MVP2Interactor(MVP2Contract.LoginListenser view) {
        this.view = view;
    }

    public void login(String userName, String password) {
        if(hasError(userName, password)){
            return;
        }
        view.onSuccess();
    }

    private boolean hasError(String userName, String password) {
        if (TextUtils.isEmpty(userName)) {
           view.onError("Enter UserName");
            return true;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(userName).matches()) {
            view.onError("the Email is invalid");
            return true;
        }
        if (TextUtils.isEmpty(password)) {
            view.onError("Enter Password");
            return true;
        }

        if (password.length() < 5) {
            view.onError("Password is too weak");
            return true;
        }
        return false;
    }

}
