package com.example.se2_11805004_krainer_einzelbeispiel;

import java.io.*;
import java.net.*;
import com.example.se2_11805004_krainer_einzelbeispiel.MainActivity.*;

public class Client_TCP {
    public static void main(String[] args) throws Exception {
        MainActivity activity = new MainActivity();
        String antwortVonServer;
        String textToServer;

        Socket clientSocket = new Socket("se2-isys.aau.at",53212);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        textToServer = activity.getMatrn();

        outToServer.writeBytes(textToServer+'\n');

        antwortVonServer = inFromServer.readLine();
        activity.setAusgabe(antwortVonServer);

        clientSocket.close();
    }


}
