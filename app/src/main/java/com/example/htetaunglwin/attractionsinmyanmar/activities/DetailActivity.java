package com.example.htetaunglwin.attractionsinmyanmar.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.htetaunglwin.attractionsinmyanmar.AttractionsinMyanmar;
import com.example.htetaunglwin.attractionsinmyanmar.R;
import com.example.htetaunglwin.attractionsinmyanmar.data.models.AttractionModel;
import com.example.htetaunglwin.attractionsinmyanmar.data.vos.AttractionVO;

public class DetailActivity extends AppCompatActivity {
    ImageView ivPlacePhoto;
    TextView tvPlaceDec;
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    private static final String PLACE_TITLE = "title";

    public static Intent intentToDetailActivity(String title){
        Intent intent = new Intent(AttractionsinMyanmar.getContext(), DetailActivity.class);
        intent.putExtra(PLACE_TITLE, title);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ivPlacePhoto = (ImageView) findViewById(R.id.iv_place_photo);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            String transtionName = AttractionsinMyanmar.getContext().getResources().getString(R.string.place_photo_share_transition);
            ivPlacePhoto.setTransitionName(transtionName);
        }

        tvPlaceDec = (TextView) findViewById(R.id.tv_detail_desc);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);


        String placeTitle = getIntent().getStringExtra(PLACE_TITLE);

        AttractionVO place = AttractionModel.getObjInstance().getPlaceByTitle(placeTitle);
        if(place == null) {
            throw new RuntimeException("Can't find Event obj with the title : "+ placeTitle);
        } else {
            mCollapsingToolbarLayout.setTitle(place.getTitle());
            tvPlaceDec.setText(place.getDesc()+"\n"+place.getDesc());
        }
    }

}
