package com.example.theheroproject_g2;


import static com.example.theheroproject_g2.R.id.listViewHeroes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class resultado extends AppCompatActivity {

    //private TextView textViewTotalHeroes;
    //private ListView listViewHeroes;
    private List<String> heroListString ;
    private List<Hero> heroList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        final TextView countTextView = findViewById(R.id.textViewTotalHeroes);
        final ListView  heroListView = findViewById(R.id.listViewHeroes);


        Intent intent = getIntent();
        heroList = (List<Hero>) intent.getSerializableExtra("heroList");

        countTextView.setText("Total de héroes encontrados: " + heroList.size());

        ArrayAdapter<Hero> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, heroList);
        heroListView.setAdapter(adapter);
    }



}
