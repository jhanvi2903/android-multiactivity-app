package com.example.actorslist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TotalActorsActivity extends AppCompatActivity implements RecyclerViewInterface{

    String [] actorName = null;
    int [] actorImage = null;
    String[] age = null;
    String[] birthplace = null;
    String[] shortDescription = null;
    String category = null;
    RecyclerView list = null;
    TotalActorsActivityRecycleAdapter adapter = null;
    ReadXML data = null;
    TextView actorsTextView = null;

    int sectionPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_actors);

        Toolbar t = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(t);

        actorsTextView = findViewById(R.id.actors);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        CategoryModel cm = (CategoryModel) bundle.getSerializable("section");
        actorName= bundle.getStringArray("actorName");
        actorImage = bundle.getIntArray("actorImage");
        age = bundle.getStringArray("age");
        birthplace = bundle.getStringArray("birthplace");
        shortDescription = bundle.getStringArray("shortDescription");
        sectionPosition = bundle.getInt("sectionPosition");
        category = bundle.getString("category");

        actorsTextView.setText(category);


        data = new ReadXML(this);

        list = findViewById(R.id.listOfActors);
        list.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TotalActorsActivityRecycleAdapter(getApplicationContext(), R.layout.actors_list, actorName, actorImage, age, birthplace,this);
        list.setAdapter(adapter);
    }

    public void onItemClick(int position) {
        Toast.makeText(this, "selected "+actorName[position], Toast.LENGTH_SHORT).show();
        ActorsModel cmp = data.getActorsData(sectionPosition, position);
        Intent intent = new Intent(TotalActorsActivity.this, ActorsDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("actorDetail", cmp);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

