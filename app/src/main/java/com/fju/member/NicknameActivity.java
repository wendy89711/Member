package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class NicknameActivity extends AppCompatActivity {

    private EditText edNickname;
    private SharedPreferences setting;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_age();
            }
        });

    }
    public void age() {
        Intent intent = new Intent(this,AgeActivity.class);
        setting.edit()
                .putString("name",name)
                .commit();
        startActivityForResult(intent,10);
    }
    public void next_age() {
        edNickname = findViewById(R.id.nickname);
        name = edNickname.getText().toString();
        if (!TextUtils.isEmpty(edNickname.getText().toString())) {
            setting = getSharedPreferences("test",MODE_PRIVATE);
            Log.d("RESULT_NICkNAME", name);
            setResult(RESULT_OK);
            finish();
            age();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("ERROR")
                    .setMessage("Can't not empty !")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }


}
