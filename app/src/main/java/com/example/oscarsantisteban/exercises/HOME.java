package com.example.oscarsantisteban.exercises;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HOME extends AppCompatActivity {

    Button btnEx1;
    Button btnEx2;
    Button btnEx3;
    Button btnEx4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnEx1 = (Button) findViewById(R.id.ex_1_btn);
        btnEx2 = (Button) findViewById(R.id.ex_2_btn);
        btnEx3 = (Button) findViewById(R.id.ex_3_btn);
        btnEx4 = (Button) findViewById(R.id.ex_4_btn);

        btnEx1.setOnClickListener(btnExClickListener(1));
        btnEx2.setOnClickListener(btnExClickListener(2));
        btnEx3.setOnClickListener(btnExClickListener(3));
        btnEx4.setOnClickListener(btnExClickListener(4));

    }

    View.OnClickListener btnExClickListener(final int exercise){

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (exercise){
                    case 1: launchEx1();
                        break;
                    case 2: launchEx2();
                        break;
                    case 3: launchEx3();
                        break;
                    case 4: launchEx4();
                        break;
                }
            }
        };
    }
    public void launchEx1(){
        Intent exercise1 = new Intent(this, Exercise1.class);
        startActivity(exercise1);
    }
    public void launchEx2(){
        Intent exercise2 = new Intent(this, Exercise2.class);
        startActivity(exercise2);
    }
    public void launchEx3(){
        Intent exercise3 = new Intent(this, Exercise3.class);
        startActivityForResult(exercise3, 1);
    }
    public void launchEx4(){
        Intent exercise4 = new Intent(this, Exercise4.class);
        startActivity(exercise4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "There's nothing to show", Toast.LENGTH_LONG).show();
            }
        }
    }
}
