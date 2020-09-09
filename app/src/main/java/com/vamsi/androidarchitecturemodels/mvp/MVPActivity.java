package com.vamsi.androidarchitecturemodels.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.vamsi.androidarchitecturemodels.MainActivity;
import com.vamsi.androidarchitecturemodels.R;
import com.vamsi.androidarchitecturemodels.mvc.MVCActivity;
import com.vamsi.androidarchitecturemodels.mvc.MVCActivityController;

import java.util.ArrayList;
import java.util.List;

public class MVPActivity extends AppCompatActivity implements MVPActivityPresenter.View{

    private ListView listView;
    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    MVPActivityPresenter mvpActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_v_p);

        mvpActivityPresenter = new MVPActivityPresenter(this);

        listView = findViewById(R.id.id_list_view);

        arrayAdapter = new ArrayAdapter<>(this, R.layout.row_item, R.id.tv_text, listValues);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MVPActivity.this, "you clicked : " + listValues.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public static Intent getIntent(MainActivity mainActivity) {
        return new Intent(mainActivity, MVPActivity.class);
    }

    @Override
    public void setValues(List<String> countries) {
        listValues.clear();
        listValues.addAll(countries);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void setError() {
        Toast.makeText(MVPActivity.this, "Something when wrong", Toast.LENGTH_SHORT).show();
    }
}