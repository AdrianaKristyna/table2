package com.example.table2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.table2.fragments.MainFragment;
import com.example.table2.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        startMainFragment();
    }

    private void startMainFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_container, new MainFragment(), MainFragment.TAG)
                .addToBackStack(null)
                .commit();
    }
}