package com.example.e_workmanager_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import static com.example.e_workmanager_2.ConnectionServer.connetionServer2;
import static com.example.e_workmanager_2.MainActivity.connetionServer;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public void ConectarServer(View view) {
        //new Hilo1().start();
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                connetionServer2();
            }
        });
    }

    class Hilo1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(50);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Pasamos por el hilo*********************************************");
                        connetionServer();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}