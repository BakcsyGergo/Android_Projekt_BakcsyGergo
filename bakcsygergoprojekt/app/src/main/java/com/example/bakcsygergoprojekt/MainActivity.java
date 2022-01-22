package com.example.bakcsygergoprojekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static String MOVIES_URL ="https://www.omdbapi.com/?apikey=1f1a803f&s=Spider";
    private RecyclerView recyclerView;
    private List<Movie> movieList = new ArrayList<>();
    private String movieData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initId();
        getData();
    }

    private void initId() {
        recyclerView = findViewById(R.id.rvMovies);
    }

    private void getData() {
        //ToDo
        OkHttpClient client= new OkHttpClient();
        Request request = new Request.Builder().url(MOVIES_URL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                movieData = response.body().string();

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(movieData);
                    JSONArray jsonArray = jsonObject.getJSONArray("Search");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Movie newMovie = new Movie(
                                obj.getString("Title"),
                                obj.getString("Year"),
                                obj.getString("Type"),
                                obj.getString("Poster")



                    );
                        movieList.add(newMovie);
                    }
                } catch(JSONException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MovieAdapter adapter= new MovieAdapter(MainActivity.this,movieList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}