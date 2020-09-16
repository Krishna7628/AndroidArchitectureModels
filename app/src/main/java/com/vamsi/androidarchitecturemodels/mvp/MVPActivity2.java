package com.vamsi.androidarchitecturemodels.mvp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vamsi.androidarchitecturemodels.R;

public class MVPActivity2 extends AppCompatActivity implements MVP2Contract.View {

    EditText etUserName, etPassword;
    MVP2Presenter mvp2Presenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_v_p2);

        mvp2Presenter = new MVP2Presenter(this);
        progressDialog = new ProgressDialog(this);

        etUserName = findViewById(R.id.et_user_name);
        etPassword = findViewById(R.id.et_user_password);


        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mvp2Presenter.start(etUserName.getText().toString().trim(), etPassword.getText().toString().trim());
            }
        });
    }

    public static Intent getIntent(MVPActivity mvpActivity) {
        return new Intent(mvpActivity, MVPActivity2.class);
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Successful Login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressDialog.show();
    }

    @Override
    public void dismissProgressBar() {
        progressDialog.dismiss();
    }
}