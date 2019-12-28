package com.example.androidarchitectures.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidarchitectures.R;
import com.example.androidarchitectures.model.CountryService;

import java.util.ArrayList;
import java.util.List;

public class MvcActivity extends AppCompatActivity {

    private List<String> countryNames=new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private CountriesController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("Mvc Activity");
        controller=new CountriesController(this);

        list=findViewById(R.id.list);
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
        adapter.notifyDataSetChanged();
    }

    public static Intent getIntent(Context context){
        return new Intent(context,MvcActivity.class);
    }
}
