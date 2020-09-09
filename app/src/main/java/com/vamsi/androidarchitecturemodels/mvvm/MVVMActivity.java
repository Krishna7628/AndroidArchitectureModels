package com.vamsi.androidarchitecturemodels.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.vamsi.androidarchitecturemodels.MainActivity;
import com.vamsi.androidarchitecturemodels.R;
import com.vamsi.androidarchitecturemodels.mvp.MVPActivity;

public class MVVMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_v_v_m);
    }

    public static Intent getIntent(MainActivity mainActivity) {
        return new Intent(mainActivity, MVVMActivity.class);
    }
}