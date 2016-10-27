package com.example.oscarsantisteban.exercises;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise3 extends AppCompatActivity {

    TextView numberOne;
    TextView numberTwo;
    TextView resultProcess;
    Button process;
    int result;
    public final int REQUEST_CODE_ONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);





        numberOne = (TextView) findViewById(R.id.numberOne);
        numberTwo = (TextView) findViewById(R.id.numberTwo);
        resultProcess = (TextView) findViewById(R.id.process_result);


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



                startActivityForResult(processNumbers, REQUEST_CODE_ONE);
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ONE) {
            if(resultCode == Activity.RESULT_OK){

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",result);
                setResult(Activity.RESULT_OK,returnIntent);
                this.finish();

            }

            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
            }
        }
    }
}
