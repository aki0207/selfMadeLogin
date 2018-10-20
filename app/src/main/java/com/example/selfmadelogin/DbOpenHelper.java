package com.example.selfmadelogin;


import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;


public class DbOpenHelper extends SQLiteOpenHelper {

    final static private int DB_VERSION = 1;


    public DbOpenHelper(Context context) {

        super(context, null, null, DB_VERSION);

    }


    @Override

    public void onCreate(SQLiteDatabase db) {

        // table create

        db.execSQL(

                "create table members(" +

                        "   mail_address text," +

                        "   password text" +

                        ");"

        );


        // table row insert

        db.execSQL("insert into members(mail_address,password) values ('donpappa@docomo.ne.jp', '0207');");


    }


    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // データベースの変更が生じた場合は、ここに処理を記述する。

    }

}
