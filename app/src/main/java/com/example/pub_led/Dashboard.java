package com.example.pub_led;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent i = getIntent();
        final String sap = i.getStringExtra("sap");
        Button view = (Button)findViewById(R.id.view);
        Button edit = (Button)findViewById(R.id.edit);
        Button report = (Button)findViewById(R.id.report);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),view.class);
                i.putExtra("sap",sap);
                startActivity(i);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(getApplicationContext(),edit.class);
                j.putExtra("sap",sap);
                startActivity(j);
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(getApplicationContext(),report.class);
                k.putExtra("sap",sap);
                startActivity(k);
            }
        });



    }


}
