package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Film> filmsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                "https://swapi.dev/api/films/",
                response -> {

                    filmsList = new ArrayList<>();

                    try {
                        JSONArray jsonFilmList = response.getJSONArray("results");

                        for(int i = 0; i < jsonFilmList.length(); i++ ) {
                            try {
                                JSONObject json = jsonFilmList.getJSONObject(i);
                                Film film = new Film(json);
                                filmsList.add(film);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        RecyclerView rvFilmsList = findViewById(R.id.rvFilmList);
                        rvFilmsList.setLayoutManager(new LinearLayoutManager(this));
                        rvFilmsList.setAdapter(new FilmListAdapter(filmsList));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                },
                error -> Log.d("volley",error.toString())
        );

        RequestManager.getInstance(this).addToRequestQueue(jsonArrayRequest);
    }
}