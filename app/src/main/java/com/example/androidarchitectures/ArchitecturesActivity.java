package com.example.androidarchitectures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidarchitectures.mvc.MvcActivity;
import com.example.androidarchitectures.mvp.MvpActivity;
import com.example.androidarchitectures.mvvm.MvvmActivity;

public class ArchitecturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architectures);
    }

    public void onMvc(View view) {
        startActivity(MvcActivity.getIntent(this));
    }

    public void onMvp(View view) {
        startActivity(MvpActivity.getIntent(this));
    }

    public void onMvvm(View view) {
        startActivity(MvvmActivity.getIntent(this));
    }
}
