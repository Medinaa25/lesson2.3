package com.example.lesson23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lesson23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (savedInstanceState == null) {
           getSupportFragmentManager().beginTransaction().add(R.id.container,new BlankFragment()).commit();
        }
    }
}