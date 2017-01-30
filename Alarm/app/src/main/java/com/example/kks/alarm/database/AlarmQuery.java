package com.example.kks.alarm.database;

import android.content.Context;

import com.example.kks.alarm.recycler.AlarmAdapter;
import com.example.kks.alarm.recycler.AlarmItem;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by KKS on 2017-01-27.
 */

public class AlarmQuery {

    private AlarmDatabase alarmDatabase;
    private Realm realm;
    private RealmQuery<AlarmDatabase> query;
    private RealmResults<AlarmDatabase> results;
    private AlarmAdapter adapter;

    Context mcontext;

    public AlarmQuery(Context context) {
        mcontext = context;
    }

    public ArrayList<AlarmItem> query_Recycler(ArrayList<AlarmItem> items) {


        Realm.init(mcontext);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
        query = realm.where(AlarmDatabase.class);
        results = query.findAll();
        for(int i=0; i<results.size(); i++){
            alarmDatabase = results.get(i);
            items.add(new AlarmItem(
                    alarmDatabase.getDetail(),
                    alarmDatabase.getYear(),
                    alarmDatabase.getMonth(),
                    alarmDatabase.getDay(),
                    alarmDatabase.getHour(),
                    alarmDatabase.getMinute()));
        }
        return items;
    }
}
