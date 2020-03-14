package com.example.se2_11805004_krainer_einzelbeispiel;
import java.io.*;
import java.net.*;


public class Client_TCP  implements Runnable{
    String antwortVonServer;
    String textToServer;

    @Override
    public void run() {

        Socket clientSocket = null;
        DataOutputStream outToServer = null;
        BufferedReader inFromServer = null;
        try {
            clientSocket = new Socket("se2-isys.aau.at",53212);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(textToServer +"\n");
            antwortVonServer = inFromServer.readLine();
            System.out.println(antwortVonServer);
            setAntwortVonServer(antwortVonServer);
            outToServer.flush();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setTextToServer(String text){
        this.textToServer = text;
    }
    public String getAntwortVonServer(){
        return antwortVonServer;
    }
    public void setAntwortVonServer(String ausgabe){
        this.antwortVonServer = ausgabe;
    }


}
