package com.example.androidarchitectures.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.androidarchitectures.R;
import com.example.androidarchitectures.model.CountryService;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MvcActivity extends AppCompatActivity {

    private List<String> countryNames=new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private CountriesController controller;
    private Button retryButton;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("Mvc Activity");
        controller=new CountriesController(this);

        list=findViewById(R.id.list);
        retryButton=findViewById(R.id.retry_button);
        progressBar=findViewById(R.id.progress);
        adapter=new ArrayAdapter(this,R.layout.row_layout,R.id.listText,countryNames);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MvcActivity.this,"View Clicked "+countryNames.get(position),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void setValues(List<String> values){
        countryNames.clear();
        countryNames.addAll(values);
        retryButton.setVisibility(GONE);
        progressBar.setVisibility(GONE);
        list.setVisibility(VISIBLE);
        adapter.notifyDataSetChanged();
    }

    public static Intent getIntent(Context context){
        return new Intent(context,MvcActivity.class);
    }

    public void onRetry(View view){
        retryButton.setVisibility(GONE);
        progressBar.setVisibility(VISIBLE);
        list.setVisibility(GONE);
        controller.onRefresh();
    }

    public void onError(){
        Toast.makeText(this,"Unable To Get Country Names, Please Retry",Toast.LENGTH_LONG).show();
        progressBar.setVisibility(GONE);
        retryButton.setVisibility(VISIBLE);

    }
}
