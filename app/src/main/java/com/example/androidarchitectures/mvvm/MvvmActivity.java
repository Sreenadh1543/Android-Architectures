package com.example.androidarchitectures.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

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

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MvvmActivity extends AppCompatActivity {


    private List<String> listValues =new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private CountriesViewModel viewModel;
    private Button retryButton;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        setTitle("Mvvm Activity");

        viewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);

        list=findViewById(R.id.list);
        retryButton=findViewById(R.id.retry_button);
        progressBar=findViewById(R.id.progress);
        adapter=new ArrayAdapter(this,R.layout.row_layout,R.id.listText, listValues);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MvvmActivity.this,"View Clicked "+ listValues.get(position),Toast.LENGTH_LONG).show();
            }
        });

        observerViewModel();
    }

    private void observerViewModel(){
        viewModel.getCountries().observe(this,countries->{

            if(countries!=null){
                listValues.clear();
                listValues.addAll(countries);
                list.setVisibility(VISIBLE);
                adapter.notifyDataSetChanged();
            }
        });

        viewModel.getCountryError().observe(this,error->{
            progressBar.setVisibility(GONE);
            if(error){
                Toast.makeText(this,"Unable To Get Country Names, Please Retry",Toast.LENGTH_LONG).show();
                retryButton.setVisibility(VISIBLE);
            }else {
                retryButton.setVisibility(GONE);
            }
        });
    }
    public void onRetry(View view){
        viewModel.onRefresh();
        retryButton.setVisibility(GONE);
        progressBar.setVisibility(VISIBLE);
        list.setVisibility(GONE);
    }

    public static Intent getIntent(Context context){
        return new Intent(context,MvvmActivity.class);
    }
}
