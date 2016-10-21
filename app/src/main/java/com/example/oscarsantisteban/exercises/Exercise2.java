package com.example.oscarsantisteban.exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Exercise2 extends AppCompatActivity {

    ListView months;
    StableArrayAdapter ex2ArrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        months = (ListView) findViewById(R.id.month_view);
        String[] month = new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < month.length; ++i) {
            list.add(month[i]);
        }
        ex2ArrAdapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1,list);

        months.setAdapter(ex2ArrAdapter);

        months.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         //       Toast.makeText(getApplicationContext(),list.get(position), Toast.LENGTH_LONG).show();
           //     Toast.makeText(getApplicationContext(),String.valueOf(id), Toast.LENGTH_LONG).show();

                Intent ex2Res = new Intent(getApplicationContext(),Exercise2Result.class);
                ex2Res.putExtra("month", list.get(position));
                ex2Res.putExtra("position", position);

                startActivity(ex2Res);
                Exercise2.this.finish();
            }
        });

    }
}
