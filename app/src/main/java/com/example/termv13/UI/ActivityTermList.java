package com.example.termv13.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        Button button = findViewById(R.id.addTerm);

        button.setOnClickListener(new View.OnClickListener() {
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

    /*
     * Method onCreateOptionsMenu, in order to do things in the menu, you
     *
     * */


    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mysample) {
            Toast.makeText(ActivityTermList.this, "put in sample data", Toast.LENGTH_LONG).show();

            return true;
        }

        // back arrow on navigation bar
        if (item.getItemId() == android.R.id.home) {
            this.finish();

                //if you want the back arrow to go somewhere else, you can override it with the following:
//            Intent intent=new Intent(ActivityTermList.this,ActivityTermDetail.class);
//            startActivity(intent);

            return true;
        }
        return true;
    }
}










