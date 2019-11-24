package com.example.pub_led;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.*;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DataBaseHelper myDbHelper = new DataBaseHelper(this);
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

        Button b1 = (Button)findViewById(R.id.b1);
        TextView t1 = (TextView)findViewById(R.id.t4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = (EditText)findViewById(R.id.et1);
                EditText et2 = (EditText)findViewById(R.id.et2);
                String s1 = et1.getText().toString();
                String s2 = et2.getText().toString();
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                Cursor cur = db.rawQuery("SELECT * FROM login WHERE ID=?", new String[] {s1} );
                if(cur.moveToFirst())
                        {
                            String pass=cur.getString(1);

                            if(s2==pass) {
                                Intent i = new Intent(getApplicationContext(),Dashboard.class);
                                startActivity(i);
                            }


                }

                }




        });


    }
}
