package com.example.androidarchitectures.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.androidarchitectures.R;
import com.example.androidarchitectures.mvc.MvcActivity;

public class MvpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        setTitle("Mvp Activity");
    }

    public static Intent getIntent(Context context){
        return new Intent(context, MvpActivity.class);
    }
}
