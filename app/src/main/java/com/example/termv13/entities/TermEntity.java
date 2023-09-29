package com.example.termv13.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "term_table")

public class TermEntity {
    @PrimaryKey(autoGenerate = true)

    private int termID;

    private String termTitle;
    private String startDate;
    private String endDate;

    public TermEntity(int termID, String termTitle, String startDate, String endDate) {
        this.termID = termID;
        this.termTitle = termTitle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }

    public String getTermTitle() {
        return termTitle;
    }

    public void setTermTitle(String termTitle) {
        this.termTitle = termTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
