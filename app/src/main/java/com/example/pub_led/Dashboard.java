package com.example.pub_led;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void fragment_view(View view) {
        Fragment fragment;
        if (view == findViewById(R.id.view)) {
            fragment = new Fragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.f1, fragment);
            ft.commit();
        }
    }
    public void fragment_edit(View view) {
        Fragment fragment;
        if (view == findViewById(R.id.edit)) {
            fragment = new Fragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.f1, fragment);
            ft.commit();
        }
    }
    public void fragment_report(View view) {
        Fragment fragment;
        if (view == findViewById(R.id.report)) {
            fragment = new Fragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.f1, fragment);
            ft.commit();
        }
    }
}
