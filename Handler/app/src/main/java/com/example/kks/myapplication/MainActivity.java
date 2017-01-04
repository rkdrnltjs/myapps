package com.example.kks.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Thread1 thread1;
    Handler1 handler1 = new Handler1();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview1);
        thread1 = new Thread1();
        thread1.start();

    }

    class Thread1 extends Thread {
        public void run(){
            for(int i=0; i<100; i++){

                try{
                    Thread.sleep(500);
                } catch(Exception e){
                    e.printStackTrace();
                }
                print("순서" + i);
            }
        }
    }

    public void print(String data){

       // textView.setText(String.valueOf(data));
        Message message = handler1.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putString("key",data);
        message.setData(bundle);

        handler1.sendMessage(message);
    }
    class Handler1 extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String data = bundle.getString("key");
            textView.setText(data);
        }
    }

}
