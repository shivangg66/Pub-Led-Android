package com.example.pub_led;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import java.io.IOException;

public class report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Intent report = getIntent();
        String sap = report.getStringExtra("sap");
        DataBaseHelper myDbHelper = new DataBaseHelper(report.this);
        try {
            myDbHelper.createDataBase();

        } catch (IOException ioe) {
            throw new Error("Unable to Create Database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        Cursor data = db.rawQuery("Select * from data where sap_id = ?", new String[]{sap});
        int count = 0;
        TableLayout tablelayout = (TableLayout)findViewById(R.id.tableLayout);

        data.moveToFirst();
        {
            do {
                count++;
                View tablerow = LayoutInflater.from(this).inflate(R.layout.table_item, null, false);
                TextView no = (TextView) findViewById(R.id.no);
                TextView title = (TextView) findViewById(R.id.title);
                TextView author = (TextView) findViewById(R.id.author);
                TextView department = (TextView) findViewById(R.id.department);
                TextView affiliation = (TextView) findViewById(R.id.affiliation);
                TextView category = (TextView) findViewById(R.id.category);
                TextView publisher = (TextView) findViewById(R.id.publisher);
                TextView month = (TextView) findViewById(R.id.month);
                TextView year = (TextView) findViewById(R.id.year);
                TextView identifier = (TextView) findViewById(R.id.identifier);
                TextView number = (TextView) findViewById(R.id.number);
                TextView doi = (TextView) findViewById(R.id.doi);
                TextView indexed = (TextView) findViewById(R.id.indexed);
                TextView volume = (TextView) findViewById(R.id.volume);
                TextView issue = (TextView) findViewById(R.id.issue);
                TextView page = (TextView) findViewById(R.id.page);
                TextView url = (TextView) findViewById(R.id.url);
                TextView verification = (TextView) findViewById(R.id.verification);
                TextView status = (TextView) findViewById(R.id.status);
                TextView remark = (TextView) findViewById(R.id.remark);

                no.setText(count);
                title.setText(data.getString(1));
                author.setText(data.getString(2));
                department.setText(data.getString(3));
                affiliation.setText(data.getString(4));
                category.setText(data.getString(5));
                publisher.setText(data.getString(6));
                month.setText(data.getString(7));
                year.setText(data.getString(8));
                identifier.setText(data.getString(9));
                number.setText(data.getString(10));
                doi.setText(data.getString(11));
                indexed.setText(data.getString(12));
                volume.setText(data.getString(13));
                issue.setText(data.getString(14));
                page.setText(data.getString(15));
                url.setText(data.getString(16));
                verification.setText(data.getString(17));
                status.setText(data.getString(18));
                remark.setText(data.getString(19));
                tablelayout.addView(tablerow);
            }while(data.moveToNext());
            data.close();





        }



    }
}
