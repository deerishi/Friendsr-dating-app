package com.example.drishi.friendstrdatingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import stanford.androidlib.SimpleActivity;

public class DetailActivity extends SimpleActivity {
    Map<String,String> map1= new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTraceLifecycle(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initializeMap();
        SharedPreferences sp=getSharedPreferences("FriendsRating",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        Intent intent=getIntent();
        RatingBar rb=find(R.id.rating);
        ImageView img=find(R.id.friend_detail);
        TextView tv=find(R.id.friend_info);
        final String name=intent.getStringExtra("friendName");
        float rating=sp.getFloat(String.valueOf(name), (float) 0.0);
        rb.setRating(rating);
        if(name.compareTo("Chandler")==0){
            tv.setText(map1.get(name));
            img.setImageResource(R.drawable.chandler);
        }else if(name.compareTo("Joey")==0){
            tv.setText(map1.get(name));
            img.setImageResource(R.drawable.joey);
        }else if(name.compareTo("Ross")==0){
            tv.setText(map1.get(name));
            img.setImageResource(R.drawable.ross);
        }else if(name.compareTo("Monica")==0){
            tv.setText(map1.get(name));
            img.setImageResource(R.drawable.monica);
        }else if(name.compareTo("Rachel")==0){
            tv.setText(map1.get(name));
            img.setImageResource(R.drawable.rachel);
        }else{
            tv.setText(map1.get(name));
            img.setImageResource(R.drawable.phoebe);
        }
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                editor.putFloat(name,rating);
                editor.commit();
                Log.d("ratingChange",name+"Rating is "+rating);
            }
        });

    }
    private void initializeMap(){
        map1.put("Chandler","Chandler is a funny, charming and elegant guy!");
        map1.put("Pheobe","Pheobe is a funny, carefree and funky girl!");
        map1.put("Joey","Joey is a handsome, funny and sexy guy!");
        map1.put("Monica","Monica is a sexy, funny and high maintenence (lol) girl!");
        map1.put("Ross","Ross is a smart, charming and elegant guy!");
        map1.put("Rachael","Rachael is a hot, sexy and funny girl!");
    }
}
