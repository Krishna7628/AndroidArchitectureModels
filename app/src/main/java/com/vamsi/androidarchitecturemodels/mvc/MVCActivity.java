package com.vamsi.androidarchitecturemodels.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vamsi.androidarchitecturemodels.MainActivity;
import com.vamsi.androidarchitecturemodels.R;

import java.util.ArrayList;
import java.util.List;

public class MVCActivity extends AppCompatActivity {


    private ListView listView;
    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    MVCActivityController mvcActivityController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_v_c);
        setTitle("MVC Activity");

        mvcActivityController = new MVCActivityController(this);

        listView = findViewById(R.id.id_list_view);

        arrayAdapter = new ArrayAdapter<>(this, R.layout.row_item, R.id.tv_text, listValues);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MVCActivity.this, "you clicked : " + listValues.get(i), Toast.LENGTH_SHORT).show();
            }
        });


//        mvcActivityController.refresh();
    }

    public void setValues(List<String> values) {
        listValues.clear();
        listValues.addAll(values);
        arrayAdapter.notifyDataSetChanged();
    }

    public static Intent getIntent(MainActivity mainActivity) {
        return new Intent(mainActivity, MVCActivity.class);
    }
}