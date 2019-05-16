package com.example.lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.example.lab2.R.id.output_fragment;


public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(String link) {
        OutputFragment fragment = (OutputFragment) getFragmentManager().findFragmentById(output_fragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(link);
        }
    }
}
