package com.example.thiago.gitsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<CardItem> cardItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecyclerAdapter(cardItems, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.github.com/search/repositories?q=stars:%3E1&order=desc";

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");

                            List<JSONObject> list = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++)
                                list.add(jsonArray.getJSONObject(i));

                            for (int i = 0; i < list.size(); i++) {

                               /* mTextView.append("Name: " + list.get(i).getString("name") + "\n"+
                                        "url: " + list.get(i).getJSONObject("owner").getString("html_url") + "\n" +
                                        "stars: " + list.get(i).getString("stargazers_count")+ "\n\n");*/

                                cardItems.add(new CardItem(list.get(i).getJSONObject("owner").getString("avatar_url"), list.get(i).getString("name"),
                                        list.get(i).getJSONObject("owner").getString("html_url"),
                                        "stars: " + list.get(i).getString("stargazers_count")));
                            }

                            mAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        });

        queue.add(stringRequest);

    }
}
