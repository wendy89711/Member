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

public class AgeActivity extends AppCompatActivity {

    private EditText edAge;
    private SharedPreferences setting;
    private String age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_gender();
            }
        });
    }
    public void gender() {
        Intent intent = new Intent(this,GenderActivity.class);
        setting.edit()
                .putString("age",edAge.getText().toString())
                .commit();
        startActivityForResult(intent,10);
    }
    public void next_gender() {
        edAge = findViewById(R.id.age);
        age = edAge.getText().toString();
        if (!TextUtils.isEmpty(edAge.getText().toString())) {
            setting = getSharedPreferences("test",MODE_PRIVATE);
            Log.d("RESULT_NICkNAME", age);
            setResult(RESULT_OK);
            finish();
            gender();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("ERROR")
                    .setMessage("Can't not empty !")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }

}
