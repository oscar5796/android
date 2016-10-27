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
    public static final int BACK_BUTTON_RESPONSE = 2;

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

     //   Toast.makeText(this, String.valueOf(Activity.RESULT_OK), Toast.LENGTH_LONG).show();

        btnHome.setOnClickListener(onBtnHomeClick());

    }

    View.OnClickListener onBtnHomeClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",result);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

  //              ActivityProcesarNumeros.this.finish();
            }
        };
    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",result);
        setResult(BACK_BUTTON_RESPONSE,returnIntent);
        finish();
//        this.finish();
    }
}
