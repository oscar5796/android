package com.example.oscarsantisteban.exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exercise3 extends AppCompatActivity {

    TextView numberOne;
    TextView numberTwo;
    Button process;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);





        numberOne = (TextView) findViewById(R.id.numberOne);
        numberTwo = (TextView) findViewById(R.id.numberTwo);



        process = (Button) findViewById(R.id.btn_process_ex3);

        process.setOnClickListener(onProcessNumbers());

    }
    View.OnClickListener onProcessNumbers(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent processNumbers = new Intent(getApplicationContext(), ActivityProcesarNumeros.class);
                processNumbers.putExtra("numberOne", numberOne.getText());
                processNumbers.putExtra("numberTwo", numberTwo.getText());
                startActivityForResult(processNumbers, 1);
            }
        };
    }
}
