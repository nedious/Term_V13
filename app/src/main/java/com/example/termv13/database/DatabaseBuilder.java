package com.example.termv13.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.termv13.dao.CourseDao;
import com.example.termv13.dao.TermDao;
import com.example.termv13.entities.CourseEntity;
import com.example.termv13.entities.TermEntity;


@Database(entities = {TermEntity.class, CourseEntity.class}, version= 1,exportSchema = false)
// if you want to empty the database, you can increment to version = 2, etc

public abstract class DatabaseBuilder extends RoomDatabase {

    public abstract CourseDao courseDao();
    public abstract TermDao termDao();


    private static volatile DatabaseBuilder INSTANCE;
    static DatabaseBuilder getDatabase(final Context context){ // this builds an asynchronous database
        if (INSTANCE==null){ // if null, we don't have a database, therefore build a new one
            synchronized (DatabaseBuilder.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),DatabaseBuilder.class, "Database1.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
