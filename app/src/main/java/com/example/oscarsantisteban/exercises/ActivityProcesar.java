package com.example.oscarsantisteban.exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityProcesar extends AppCompatActivity {

    TextView text1;
    TextView text2;
    TextView text3;
    TextView checked;
    Bundle data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesar);

        text1 = (TextView) findViewById(R.id.text_1);
        text2 = (TextView) findViewById(R.id.text_2);
        text3 = (TextView) findViewById(R.id.text_3);
        checked = (TextView) findViewById(R.id.checked);

        data = getIntent().getExtras();


        String dataText1=data.getString("text1");
        String dataText2=data.getString("text2");
        String dataText3=data.getString("text3");
        boolean dataCheck= data.getBoolean("checked");


        text1.setText(dataText1);
        text2.setText(dataText2);
        text3.setText(dataText3);
        checked.setText(String.valueOf(dataCheck));


    }

    @Override
    public void onBackPressed() {
            this.finish();
            Intent goBack = new Intent(getApplicationContext(), HOME.class);
            startActivity(goBack);
    }
}
