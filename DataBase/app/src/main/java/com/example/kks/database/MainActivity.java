package com.example.kks.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kks.database.DB.Helper;

public class MainActivity extends AppCompatActivity {
    Button insert;
    TextView status;
    SQLiteDatabase db;
    Helper helper;
    ContentValues values;
    Button delete;
    Button update;
    Button read;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = helper.getReadableDatabase();
        helper = new Helper(this, "Infomember");
        helper.onUpgrade(db,1,2);
         insert = (Button) findViewById(R.id.insert);
          delete = (Button) findViewById(R.id.delete);
          update = (Button) findViewById(R.id.update);
          read = (Button) findViewById(R.id.read);
        status = (TextView) findViewById(R.id.textView);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    db = helper.getWritableDatabase();
                    values = new ContentValues();
                    values.put("uname", "gwisun");
                    values.put("uid", "vmfhrmfoaj12");
                    db.insert("member", null, values);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = helper.getWritableDatabase();
                db.delete("member",null,null);

            }
        });


        update .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    db = helper.getReadableDatabase();
                    String[] columns = {"uname", "uid"};
                    Log.d("로그", "ㄹㄹㄹ");
                    Cursor cursor = db.query("member", columns, null, null, null, null, null);

                    StringBuffer stringBuffer = new StringBuffer();
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(0);
                        String id = cursor.getString(1);

                        stringBuffer.append(name+", "+id);
                        status.setText(stringBuffer.toString());
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
