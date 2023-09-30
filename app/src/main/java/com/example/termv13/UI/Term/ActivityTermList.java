package com.example.termv13.UI.Term;

import static com.example.termv13.entities.CourseStatus.IN_PROGRESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.termv13.R;
import com.example.termv13.database.Repository;
import com.example.termv13.entities.CourseEntity;
import com.example.termv13.entities.TermEntity;

import java.util.List;

public class ActivityTermList extends AppCompatActivity {

    private Repository repository;


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

        RecyclerView recyclerView = findViewById(R.id.term_recyclerview);

        repository= new Repository(getApplication()); // makes new repository

        List<TermEntity> allTerms = repository.getAllTerms(); // gets all terms from repository



        final ActivityTermAdapter termAdapter = new ActivityTermAdapter(this); // call recycling adapter we just made

        recyclerView.setAdapter(termAdapter); // associating the recycler and adapter views

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //linear layout - required for recycler view


        termAdapter.setTerms(allTerms); // list of terms . Method used from ActivityTermAdapter.java
//        termAdapter.setCourses(Repository.getAllCourses());

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
            repository=new Repository(getApplication());

//            Toast.makeText(ActivityTermList.this, "sample data added to database", Toast.LENGTH_LONG).show();

            // term data for repository
            TermEntity term = new TermEntity(1,"Term 1", "10/1/2023", "4/1/2024");
            repository.insert(term);

            term = new TermEntity(2,"Term 2", "10/1/2023", "4/1/2024");
            repository.insert(term);

            // course data for repository
            CourseEntity course = new CourseEntity(1, "History", "10/1/2023", "4/1/2024", IN_PROGRESS, "US History", "Mr. History", "1234567890", "history@email.com", 1);
            repository.insert(course);

            course = new CourseEntity(2, "Economics", "10/1/2023", "4/1/2024", IN_PROGRESS, "US Economics", "Mr. Econ", "01234567890", "econ@email.com", 1);
            repository.insert(course);

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










