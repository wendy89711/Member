package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class GenderActivity extends AppCompatActivity {

    private EditText edGnder;
    private SharedPreferences setting;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_main();
            }
        });
    }

    public void next_main() {
        edGnder = findViewById(R.id.gender);
        gender = edGnder.getText().toString();
        if (!TextUtils.isEmpty(edGnder.getText().toString())) {
            setting = getSharedPreferences("test",MODE_PRIVATE);
            setting.edit()
                    .putString("gender",edGnder.getText().toString())
                    .commit();
            Log.d("RESULT_GENDER", gender);
            setResult(RESULT_OK);
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("ERROR")
                    .setMessage("Can't not empty !")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}
