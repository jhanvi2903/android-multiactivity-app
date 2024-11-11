package com.example.actorslist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    String [] sections = null;
    int[] imageIds  = null;
    String[] totalActors = null;
    RecyclerView list = null;
    MainActivityRecycleAdapter adapter = null;
    ReadXML data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar t = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(t);

        list = findViewById(R.id.sectionView);
        list.setLayoutManager(new LinearLayoutManager(this));
        data = new ReadXML(this);

        sections = data.getCategoryNames();
        imageIds = data.getImageIds();
        totalActors = data.getTotalActorsCount();

        adapter = new MainActivityRecycleAdapter(getApplicationContext(), R.layout.new_row_layout, sections, imageIds, totalActors, this);
        list.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "selected "+sections[position], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,TotalActorsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("sectionPosition", position);
        CategoryModel categoryModel = data.getCategoryModel(position);
        bundle.putSerializable("section", categoryModel);
        bundle.putStringArray("actorName", data.getActorsNames(position));
        bundle.putIntArray("actorImage", data.getactorsLogo(position));
        bundle.putStringArray("age", data.getActorAge(position));
        bundle.putStringArray("birthplace", data.getActorBirthplace(position));
        bundle.putStringArray("shortDescription", data.getShortDescription(position));
        bundle.putStringArray("moreDetails", data.getMoreDetails(position));
        bundle.putString("category", categoryModel.getSectionName());
        bundle.putStringArray("actors", data.getCategoryNames());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}