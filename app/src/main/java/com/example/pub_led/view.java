package com.example.pub_led;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TableLayout tl1 = (TableLayout)findViewById(R.id.view_tl1);
        TextView t1 = (TextView)findViewById(R.id.view_t1);
        TableLayout tl2 = (TableLayout)findViewById(R.id.view_tl2);
        TextView t2 = (TextView)findViewById(R.id.view_t2);
        DataBaseHelper myDbHelper = new DataBaseHelper(view.this);
        try{
            myDbHelper.createDataBase();

        }
        catch (IOException ioe)
        {
            throw new Error("Unable to Create Database");
        }
        try{
            myDbHelper.openDataBase();
        }
        catch (SQLException sqle)
        {
            throw sqle;
        }
        Toast.makeText(this, "Successfully Imported", Toast.LENGTH_SHORT).show();



    }
}