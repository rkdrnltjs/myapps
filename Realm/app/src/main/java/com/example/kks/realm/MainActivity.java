package com.example.kks.realm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity  {

    TextView textView;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        //렘 초기화 및 Boostcamp테이블의 정보를 가져옴
        realm = Realm.getInstance(this);
        RealmResults<Boostcamp> boostcamps = realm.where(Boostcamp.class).findAll();

        //DB 데이터 저장
        insertDatabase();

        //DB 데이터 삭제
        deleteDatabase();


    }

    private void insertDatabase() {

        realm.beginTransaction();

        Boostcamp boostcamp = realm.createObject(Boostcamp.class);
        boostcamp.setName("강귀선");
        boostcamp.setCity("Seoul");
        boostcamp.setContact(1);

        realm.commitTransaction();
    }

    private void deleteDatabase() {

        realm.beginTransaction();

        RealmResults<Boostcamp> boostcamps = realm.where(Boostcamp.class).findAll();
        boostcamps.remove(0);
        realm.commitTransaction();

    }


}
