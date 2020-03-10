package com.example.se2_11805004_krainer_einzelbeispiel;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.*;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    String matrn;
    String ausgabe;

    EditText input_numbers;
    TextView ausgabe_view;
    Button btn_abschicken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        input_numbers = (EditText) findViewById(R.id.input_numbers);
        ausgabe_view = (TextView) findViewById(R.id.textFromServer);
        ausgabe_view.setText(ausgabe);

        btn_abschicken = (Button) findViewById(R.id.btn_abschicken);
        btn_abschicken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                matrn = input_numbers.getText().toString();

            }
        });


    }
    public String getMatrn(){
        return matrn;
    }
    public void setAusgabe(String ausgabe){
        this.ausgabe = ausgabe;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
