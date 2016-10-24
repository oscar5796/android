package com.example.oscarsantisteban.exercises;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityProcesarNumeros extends AppCompatActivity {

    Bundle data;
    TextView stringResult;
    Button btnHome;
    int result;
    int numberOne;
    int numberTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesar_numeros);

        data = getIntent().getExtras();
        stringResult = (TextView) findViewById(R.id.lbl_result);
        btnHome = (Button) findViewById(R.id.btn_go_home);

        numberOne = Integer.parseInt(data.get("numberOne").toString());
        numberTwo = Integer.parseInt(data.get("numberTwo").toString());

        result = numberOne*numberTwo;

        stringResult.setText("El resultado es: "+result);

        btnHome.setOnClickListener(onBtnHomeClick());

    }

    View.OnClickListener onBtnHomeClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HOME.class);
                startActivity(intent);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",result);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        };
    }


}
