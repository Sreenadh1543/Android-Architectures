package com.example.androidarchitectures.mvp;

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

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MvpActivity extends AppCompatActivity implements com.example.androidarchitectures.mvp.View {

    private List<String> countryNames=new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private CountriesPresenter presenter;
    private Button retryButton;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        setTitle("Mvp Activity");
        presenter =new CountriesPresenter(this);

        list=findViewById(R.id.list);
        retryButton=findViewById(R.id.retry_button);
        progressBar=findViewById(R.id.progress);
        adapter=new ArrayAdapter(this,R.layout.row_layout,R.id.listText,countryNames);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MvpActivity.this,"View Clicked "+countryNames.get(position),Toast.LENGTH_LONG).show();
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
        return new Intent(context,MvpActivity.class);
    }

    public void onRetry(View view){
        retryButton.setVisibility(GONE);
        progressBar.setVisibility(VISIBLE);
        list.setVisibility(GONE);
        presenter.onRefresh();
    }

    public void onError(){
        Toast.makeText(this,"Unable To Get Country Names, Please Retry",Toast.LENGTH_LONG).show();
        progressBar.setVisibility(GONE);
        retryButton.setVisibility(VISIBLE);

    }
}
