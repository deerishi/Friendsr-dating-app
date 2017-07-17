package com.example.drishi.friendstrdatingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTraceLifecycle(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout gl=find(R.id.container);
        SharedPreferences sp=getSharedPreferences("FriendsRating",MODE_PRIVATE);

        addFriend(R.drawable.chandlerpreview,"Chandler",sp.getFloat("Chandler",5),gl);addFriend(R.drawable.monicapreview,"Monica",sp.getFloat("Monica",5),gl);
        addFriend(R.drawable.joeypreview,"Joey",sp.getFloat("Joey",5),gl);addFriend(R.drawable.rachelpreview,"Rachel",sp.getFloat("Rachel",5),gl);
        addFriend(R.drawable.rosspreview,"Ross",sp.getFloat("Ross",5),gl);addFriend(R.drawable.phoebepreview,"Phoebe",sp.getFloat("Pheobe",5),gl);

    }

    public void friendClick(String name) {
        Intent intent=new Intent(this,DetailActivity.class);
        Log.d("name","name is "+name);
        intent.putExtra("friendName",name);
        startActivity(intent);


    }

    private void addFriend(int imgId, String name, float rating, GridLayout parent){
        Log.d("layoutInflate","Adding Layout for "+name+" with rating "+rating);
        View view=getLayoutInflater().inflate(R.layout.preview,null);
        ImageButton ib=(ImageButton)view.findViewById(R.id.dp);
        ib.setTag(name);
        TextView tv=(TextView) view.findViewById(R.id.name);
        RatingBar rb=(RatingBar) view.findViewById(R.id.rating);
        ib.setImageResource(imgId);tv.setText(name);rb.setRating(rating);
        parent.addView(view);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=(String) v.getTag();
                friendClick(name);
            }
        });

    }
}
