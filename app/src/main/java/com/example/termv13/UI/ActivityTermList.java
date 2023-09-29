package com.example.termv13.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.termv13.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityTermList extends AppCompatActivity {

    /*
     * Method onCreate, initializes activity UI
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityTermList.this, ActivityTermDetail.class);
                // the intent moves the user from the ActivityTermList.this activity to the ActivityTermDetail.class activity
                startActivity(intent); // start activity intent so it goes to the next class
                //go to manifest and give it a label
            }
        });

        System.out.println(getIntent().getStringExtra("test"));
    }

/*
* Method onCreateOptionsMenu, generates drop down menu from snowman in top right corner
* */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_term_list, menu);
        return true;
    }


}