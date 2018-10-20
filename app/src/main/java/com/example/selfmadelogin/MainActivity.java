package com.example.selfmadelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //インテントの作成
                Intent intent = new Intent(MainActivity.this, com.example.selfmadelogin.SubActivity.class);

                //データをセット
                EditText editText = (EditText) findViewById(R.id.eMailForm);
                intent.putExtra("eMail", editText.getText().toString());
                editText = (EditText) findViewById(R.id.passwordForm);
                intent.putExtra("password", editText.getText().toString());


                //遷移先の画面を起動
                startActivity(intent);

            }


        });
    }
}
