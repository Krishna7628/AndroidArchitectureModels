package com.vamsi.androidarchitecturemodels.mvp;

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

public class MVPActivity extends AppCompatActivity implements MVPActivityPresenter.View {

    /*MVP
     *   Model - this is where we fetch data or interact to the server
     *   View  - this where Ui code Located
     *   Presenter - bridge . It helps the view to communicate to model
     *   */


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


        findViewById(R.id.btn_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MVPActivity2.getIntent(MVPActivity.this));
            }
        });

        findViewById(R.id.btn_button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MVPActivity3.getIntent(MVPActivity.this));
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