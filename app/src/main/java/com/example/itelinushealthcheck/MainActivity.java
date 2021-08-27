package com.example.itelinushealthcheck;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.itelinushealthcheck.databinding.ActivityMainBinding;

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

        // utilizzare Adroid id al posto
        WifiManager manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();

        String address = "Id ospite \n" + info.getMacAddress();
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