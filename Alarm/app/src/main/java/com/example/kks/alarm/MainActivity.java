package com.example.kks.alarm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.kks.alarm.database.AlarmQuery;
import com.example.kks.alarm.dialog.AlarmUpdateDialog;
import com.example.kks.alarm.recycler.AlarmAdapter;
import com.example.kks.alarm.recycler.AlarmItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AlarmItem> items;
    RecyclerView recyclerView;
    FloatingActionButton fab;
    AlarmUpdateDialog alarmUpdateDialog;
    AlarmAdapter alarmAdapter;
    AlarmQuery alarmQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_recycler();
        fabClicked();






    }

    public void init_recycler() {

        items = new ArrayList<>();
        alarmQuery = new AlarmQuery(this);
        items = alarmQuery.query_Recycler(items);
        alarmAdapter = new AlarmAdapter(this, items);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(alarmAdapter);

    }

    public void refreshList() {
        items = alarmQuery.query_Recycler(items);
        alarmAdapter.setItem(items);
    }


    private void fabClicked() {

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        alarmUpdateDialog = new AlarmUpdateDialog(this, alarmAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmUpdateDialog.show();
            }
        });

    }
}
