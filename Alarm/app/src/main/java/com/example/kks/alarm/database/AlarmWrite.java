package com.example.kks.alarm.database;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by KKS on 2017-01-27.
 */

public class AlarmWrite {


    public void write(Context context, AlarmDatabase data){


        Realm.init(context);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        AlarmDatabase database = realm.createObject(AlarmDatabase.class);
        database.setYear(data.getYear());
        database.setMonth(data.getMonth());
        database.setDay(data.getDay());
        database.setHour(data.getHour());
        database.setMinute(data.getMinute());
        database.setDetail(data.getDetail());


        realm.commitTransaction();



    }

}
