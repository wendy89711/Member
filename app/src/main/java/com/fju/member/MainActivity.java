package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN = 1;
    boolean logon = false;
    private TextView nickname;
    private TextView age;
    private TextView gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nickname = findViewById(R.id.na);
        age = findViewById(R.id.ag);
        gender = findViewById(R.id.ge);
        if (!logon) {
            Intent login = new Intent(this,NicknameActivity.class);
            startActivityForResult(login,REQUEST_CODE_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if ((resultCode == 1)) {
                finish();
            } else {
                nickname.setText(getSharedPreferences("test",MODE_PRIVATE).getString("name",""));
                age.setText(getSharedPreferences("test",MODE_PRIVATE).getString("age",""));
                gender.setText(getSharedPreferences("test",MODE_PRIVATE).getString("gender",""));
            }
        }
    }
}
