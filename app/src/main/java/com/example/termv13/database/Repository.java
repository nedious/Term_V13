package com.example.termv13.database;

import android.app.Application;


import com.example.termv13.dao.CourseDao;
import com.example.termv13.dao.TermDao;
import com.example.termv13.entities.CourseEntity;
import com.example.termv13.entities.TermEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private TermDao mTermDao;
    private CourseDao mCourseDao;

//    private AssessmentDao assessmentDao;
//    private MentorDao mentorDao;

    private List<TermEntity> mAllTerms;
    private List<CourseEntity> mAllCourses;

//    private List<List<Mentor>> allMentors;
//    private List<List<Term>> termById;
//    private List<List<Assessment>> allAssessments;

    private static int NUMBER_OF_THREADS = 4; //threads because of asycnronous database building
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS); //opens threads from a thread pool

    public Repository(Application application) {
        DatabaseBuilder database = DatabaseBuilder.getDatabase(application);
        mTermDao = database.termDao();
        mCourseDao = database.courseDao();

//        mentorDao = database.mentorDao();
//        assessmentDao = database.assessmentDao();
    }


    // -------------- Term ------------------//
    public List<TermEntity> getAllTerms() {
        databaseExecutor.execute(() -> {
            mAllTerms = mTermDao.getAllTerms();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return mAllTerms;
    }

    public void insert(TermEntity term){
        databaseExecutor.execute(()->{
            mTermDao.insert(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void update(TermEntity term){
        databaseExecutor.execute(()->{
            mTermDao.update(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete(TermEntity term){
        databaseExecutor.execute(()->{
            mTermDao.delete(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ------------------- Course ------------------//

    public List<CourseEntity> getmAllCourses() {
        databaseExecutor.execute(() -> {
            mAllTerms = mTermDao.getAllTerms();
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return mAllCourses;
    }

    public void insert(CourseEntity course){
        databaseExecutor.execute(()->{
            mCourseDao.insert(course);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void update(CourseEntity course){
        databaseExecutor.execute(()->{
            mCourseDao.update(course);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delete(CourseEntity course){
        databaseExecutor.execute(()->{
            mCourseDao.delete(course);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ------------------- Other ------------------//

}














