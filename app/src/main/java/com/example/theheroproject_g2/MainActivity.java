package com.example.theheroproject_g2;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHeroName;
    private Button buttonSearch;

    private RequestQueue requestQueue;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
    }

    public void irMenuPrincipal(View v){
        final EditText nameHeroe = (EditText) findViewById(R.id.editTextHeroName);
        String str_heroe = nameHeroe.getText().toString();

        searchHeroes(str_heroe);
    }

    private void searchHeroes(String query) {
        String url = "https://superheroapi.com/api/6323031714411611/search/" + query;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Procesa la respuesta JSON
                        processResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Maneja el error de la solicitud
                        Toast.makeText(MainActivity.this, "Error en la solicitud", Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(request);
    }

    private void processResponse(JSONObject response) {
        try {
            String resultFor = response.getString("results-for");
            JSONArray resultsArray = response.getJSONArray("results");

            List<Hero> heroList = new ArrayList<>();
            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject heroObject = resultsArray.getJSONObject(i);
                String name = heroObject.getString("name");

                Hero hero = new Hero();
                hero.setName(name);
                heroList.add(hero);
            }

            // Mostrar los resultados en una nueva actividad
            showResults(heroList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void showResults(List<Hero> heroList) {
        Intent intent = new Intent(MainActivity.this, resultado.class);
        intent.putExtra("heroList", (Serializable) heroList);
        startActivity(intent);
    }

}
