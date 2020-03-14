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
    TextView backFromServer;
    TextView berechnen_output;
    Button btn_abschicken;
    Button berechnen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        input_numbers = (EditText) findViewById(R.id.input_numbers);
        backFromServer = (TextView) findViewById(R.id.backFromServer);
        berechnen_output = (TextView) findViewById(R.id.berechnen_output);




        btn_abschicken = (Button) findViewById(R.id.btn_abschicken);
        btn_abschicken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                matrn = input_numbers.getText().toString();
                startTransmission();
                System.out.println(ausgabe);
                backFromServer.setText(ausgabe);

            }
        });

        berechnen = (Button) findViewById(R.id.berechnen);
        berechnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Jede zweite ziffer durch ASCII ersetzen
                matrn = input_numbers.getText().toString();
                String berechne = calculate(matrn);
                berechnen_output.setText(berechne);
            }
        });


    }
    public void startTransmission(){
        Client_TCP p = new Client_TCP();
        Thread t = new Thread(p);
        p.setTextToServer(matrn);
        t.start();
        //Bessere Lösung mit callback.
        try{
            t.join(200);
        }catch (Exception e){
            e.printStackTrace();
        }

        ausgabe = p.getAntwortVonServer();
    }

    public String calculate(String matrikelnummer){
        StringBuffer stringBuffer = new StringBuffer(matrikelnummer);
        //1 = a;  0 = j;  4 = d;
        for (int i = 1; i<matrn.length();i=i+2){
            if(stringBuffer.charAt(i)=='1'){
                stringBuffer.setCharAt(i,'a');
            }else if(stringBuffer.charAt(i)=='0'){
                stringBuffer.setCharAt(i,'j');
            }else if(stringBuffer.charAt(i)=='4'){
                stringBuffer.setCharAt(i,'d');
            }
        }
        String neu = stringBuffer.toString();

        return neu;
    }
    public String getMatrn(){
        return matrn;
    }
    public void setAusgabe(String ausgabe){
        this.ausgabe = ausgabe;
    }


}
