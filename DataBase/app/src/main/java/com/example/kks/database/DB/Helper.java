package com.example.kks.database.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KKS on 2017-01-14.
 */


public class Helper extends SQLiteOpenHelper {


    public Helper(Context context, String db) {
        super(context, db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE member (_id INTEGER PRIMARY KEY AUTOINCREMENT, uname TEXT, uid TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXITS member";
        db.execSQL(query);
        onCreate(db);

    }

}
