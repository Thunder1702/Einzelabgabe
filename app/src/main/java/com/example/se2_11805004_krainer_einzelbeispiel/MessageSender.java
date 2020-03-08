package com.example.se2_11805004_krainer_einzelbeispiel;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask <Void,Void,Void> {

    Socket s;
    DataOutputStream dos;
    PrintWriter pw;


    @Override
    protected Void doInBackground(Void... voids) {

        try{
            s = new Socket("192.168.0.227",7800);
            pw = new PrintWriter(s.getOutputStream());

        }catch (IOException e){
            e.printStackTrace();
        }


        return null;
    }
}
