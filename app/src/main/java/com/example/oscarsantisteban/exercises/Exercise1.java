package com.example.oscarsantisteban.exercises;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise1 extends AppCompatActivity {

    Button procesarButton;
    TextView text1;
    TextView text2;
    TextView text3;

    CheckBox check1;

    Activity self = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        procesarButton = (Button) findViewById(R.id.btn_procesar);
        text1 = (TextView) findViewById(R.id.editText1);
        text2 = (TextView) findViewById(R.id.editText2);
        text3 = (TextView) findViewById(R.id.editText3);
        check1 = (CheckBox) findViewById(R.id.checkBox);
        procesarButton.setOnClickListener(btnProcessOnClick());
    }

  //  @Override
    //protected void onDestroy() {
    //  super.onDestroy();
      //  this.finish();
    //}
    View.OnClickListener btnProcessOnClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text1.getText().length()<1||text2.getText().length()<1||text3.getText().length()<1){
                    Toast.makeText(self, "It seems you have an empty text field",Toast.LENGTH_LONG).show();
                }
                else{

                    Intent process = new Intent(self,ActivityProcesar.class);

                //    Toast.makeText(self,text1.getText().toString(),Toast.LENGTH_LONG).show();

                    process.putExtra("text1", text1.getText().toString());
                    process.putExtra("text2", text2.getText().toString());
                    process.putExtra("text3", text3.getText().toString());
                    process.putExtra("checked", check1.isChecked());


                    startActivity(process);
                    Exercise1.this.finish();
                }
            }
        };
    }


}
