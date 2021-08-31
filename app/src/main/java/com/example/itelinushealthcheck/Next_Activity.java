package com.example.itelinushealthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Next_Activity extends AppCompatActivity implements SensorEventListener {

    // TO DO :
    //      - disabilitare scroll a destra per tornare alla schermata precedente
    //      - cancellare barra superiore con nome app
    //      - testare funzione contapassi
    //      - funzionamento in background

    private TextView textCounter;
    private SensorManager sensorManager;
    private Sensor mStepCounter;
    private boolean isCounterPresent;
    int stepcount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        textCounter = findViewById(R.id.textCounter);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!= null ){
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterPresent = true;
        } else {
            textCounter.setText("Sensore dei passi assente");
            isCounterPresent = false;
        }

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == mStepCounter){
            stepcount = (int) sensorEvent.values[0];

            
            textCounter.setText(String.valueOf(stepcount));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume(){
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
            sensorManager.unregisterListener(this, mStepCounter);

    }


}

