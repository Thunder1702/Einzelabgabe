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



public class MainActivity extends AppCompatActivity {

    String matrn;
    String ausgabe = "Hallo";

    EditText input_numbers;
    TextView ausgabe_view;
    Button btn_abschicken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        input_numbers = (EditText) findViewById(R.id.input_numbers);





        btn_abschicken = (Button) findViewById(R.id.btn_abschicken);
        btn_abschicken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                matrn = input_numbers.getText().toString();
                startTransmission();
                ausgabe_view = (TextView) findViewById(R.id.textFromServer);
                ausgabe_view.setText(ausgabe);

            }
        });


    }
    public void startTransmission(){
        Client_TCP p = new Client_TCP();
        Thread t = new Thread(p);
        p.setTextToServer(matrn);
        t.start();
        ausgabe = p.getAntwortVonServer();


    }
    public String getMatrn(){
        return matrn;
    }
    public void setAusgabe(String ausgabe){
        this.ausgabe = ausgabe;
    }


}
