package com.example.itelinushealthcheck;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;
import android.provider.Settings;
import android.telephony.AccessNetworkConstants;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.itelinushealthcheck.databinding.ActivityMainBinding;
import android.telephony.TelephonyManager;
import android.content.Context;
public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;
    private Button pulsante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pulsante = (Button) findViewById(R.id.entra);
        mTextView = (TextView) findViewById(R.id.idospite);

        String androidId = Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);

        String address = "Id ospite \n" + androidId;
        mTextView.setText(address);



        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al click chiamare la seconda Activity
                // la seconda Activity: avrà l'immagine di e-linus
                // in background invia i dati sonno e contapassi
            }
        });



    }
}