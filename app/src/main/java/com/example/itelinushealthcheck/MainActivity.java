package com.example.itelinushealthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mTextView = (TextView) findViewById(R.id.testo1);

        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        String address = "Id ospite \n" + androidId;
        mTextView.setText(address);

        Button button =  findViewById(R.id.button);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, Next_Activity.class);
            startActivity(intent);

        });

    }
}