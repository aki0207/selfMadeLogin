package com.example.selfmadelogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //入力フォームの値を取得する
        Intent intent = this.getIntent();
        String eMail = intent.getStringExtra("eMail");
        String password = intent.getStringExtra("password");


        DbOpenHelper helper = new DbOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("members", new String[]{"mail_address", "password"},
                null, null, null, null, null);

        //いらんらしいけど
        boolean isEof = c.moveToFirst();
        String db_exist_mail_address = "";
        String db_exist_password = "";
        //dbに登録されているかの判断用
        boolean existEntry = false;

        try {


            while (isEof) {

                db_exist_mail_address = c.getString(0);
                db_exist_password = c.getString(1);

                if (db_exist_mail_address.equals(eMail)) {

                    if (db_exist_password.equals(password)) {

                        existEntry = true;
                        break;

                    }
                }

                isEof = c.moveToNext();


            }

            TextView textView = (TextView) findViewById(R.id.textView);

            if (existEntry == true) {

                textView.setText("登録されています");

            } else {

                textView.setText("登録されていません");
            }


        } catch (SQLiteException e) {

            e.printStackTrace();

        } finally {

            try {

                if (c != null) {

                    c.close();

                }

                if (db != null) {

                    db.close();
                }

            } catch (SQLiteException e) {

                e.printStackTrace();

            }
        }


    }

}
