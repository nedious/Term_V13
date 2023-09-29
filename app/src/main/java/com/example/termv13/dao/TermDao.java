package com.example.termv13.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.termv13.entities.TermEntity;

import java.util.List;

@Dao
public interface TermDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TermEntity term);

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertAll(List<TermEntity> term);

    @Update
    void update (TermEntity term);

    @Delete
    void delete (TermEntity term);

    @Query("SELECT * FROM term_table ORDER BY termID ASC")
    List<TermEntity> getAllTerms();
}

















