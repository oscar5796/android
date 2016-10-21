package com.example.oscarsantisteban.exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exercise2Result extends AppCompatActivity {

    TextView month;
    TextView position;
    Button goHome;
    Bundle data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2_result);

        data = getIntent().getExtras();
        String selectedMonth = data.getString("month");
        int selectedPosition = data.getInt("position");

        month = (TextView) findViewById(R.id.month_label);
        position = (TextView) findViewById(R.id.position_label);
        goHome = (Button) findViewById(R.id.home_button);

        month.setText("El detalle del mes: "+selectedMonth);
        position.setText(String.valueOf(selectedPosition));

        goHome.setOnClickListener(goHomeClick());
    }
    View.OnClickListener goHomeClick(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Exercise2Result.this.finish();
                Intent goHome = new Intent(getApplicationContext(),HOME.class);
                startActivity(goHome);
                Exercise2Result.this.finish();
            }
        };
    }

    @Override
    public void onBackPressed() {
        Intent goHome = new Intent(getApplicationContext(), HOME.class);
        startActivity(goHome);
        Exercise2Result.this.finish();
    }
}
