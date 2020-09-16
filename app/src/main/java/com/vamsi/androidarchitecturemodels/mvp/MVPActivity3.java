package com.vamsi.androidarchitecturemodels.mvp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vamsi.androidarchitecturemodels.R;

public class MVPActivity3 extends AppCompatActivity implements MVP3Contract.View {


    EditText etUserName, etPassword;
    ProgressDialog progressDialog;
    MVP3Presenter mvp3Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_v_p3);

        mvp3Presenter = new MVP3Presenter(this);
        progressDialog = new ProgressDialog(this);
        etPassword = findViewById(R.id.et_user_password);
        etUserName = findViewById(R.id.et_user_name);


        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mvp3Presenter.loginListener(etUserName.getText().toString().trim(), etPassword.getText().toString().trim());
            }
        });


    }


    public static Intent getIntent(MVPActivity mvpActivity) {
        return new Intent(mvpActivity, MVPActivity3.class);
    }

    @Override
    public void onSuccess() {
        progressDialog.dismiss();
    }

    @Override
    public void onError(String msg) {
        progressDialog.dismiss();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayProgress() {
        progressDialog.show();
    }

    @Override
    public void dismissProgress() {
        progressDialog.dismiss();
    }
}