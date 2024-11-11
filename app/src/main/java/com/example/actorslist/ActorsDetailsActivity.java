package com.example.actorslist;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActorsDetailsActivity extends AppCompatActivity{
    TextView aName, shortDescription, moreDetails;

    ImageView aImage;

    Button clickHereButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_details);

        Toolbar t = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(t);

        aName = (TextView) findViewById(R.id.aName);
        shortDescription = (TextView) findViewById(R.id.shortDescription);
        moreDetails = (TextView) findViewById(R.id.moreDetails);
        aImage = (ImageView) findViewById(R.id.aImage);
        clickHereButton = (Button) findViewById(R.id.clickHereButton);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ActorsModel am = (ActorsModel) bundle.getSerializable("actorDetail");




            aName.setText(am.getActorName());
            shortDescription.setText(am.getShortDescription());
            moreDetails.setText(am.getDetails());
            String imageName = am.getActorImage();
            imageName = "@drawable/" + imageName.substring(0,imageName.indexOf("."));
            int imageResource = getResources().getIdentifier(imageName, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            aImage.setImageDrawable(res);


        clickHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = am.getWebLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
