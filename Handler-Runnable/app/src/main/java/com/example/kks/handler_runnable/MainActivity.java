package com.example.kks.handler_runnable;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview1);
        Thread1 thread1 = new Thread1();
        thread1.start();

    }

    class Thread1 extends Thread {
        @Override
        public void run() {
            for(int i=0; i<=100; i++){
                try{
                    Thread1.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                final String data = String.valueOf(i);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(String.valueOf(data));
                    }
                });
            }
        }
    }


}
