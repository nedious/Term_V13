package com.example.termv13.helper;

import com.example.termv13.entities.AssessmentEntity;
import com.example.termv13.entities.AssessmentType;
import com.example.termv13.entities.CourseEntity;
import com.example.termv13.entities.CourseStatus;
import com.example.termv13.entities.TermEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SampleData {

    private static final LocalDate DATE = LocalDate.of(2023,10,1);

    // TODO: modify dummy data
        public static List<TermEntity> getSampleTerms() {
            List<TermEntity> terms = new ArrayList<>();
            terms.add(new TermEntity(0, "Term 1" , "10/1/2023", "4/1/2024"));
            terms.add(new TermEntity(1, "Term 2" , "10/1/2023", "4/1/2024"));
            terms.add(new TermEntity(2, "Term 3" , "10/1/2023", "4/1/2024"));

            return terms;
        }

        // TODO: modify dummy data
        public static List<CourseEntity> getSampleCourses() {
            List<CourseEntity> courses = new ArrayList<>();
            courses.add(new CourseEntity(0, "Math Course", "10/1/2023", "4/1/2024",  CourseStatus.IN_PROGRESS, "Test course notes to be completed, first assignment due, contact instructor, etc stuff", "Jimmy Johnson","541-555-555", "JJohnson@email.com", 0));
            courses.add(new CourseEntity(1, "English Course","10/1/2023", "4/1/2024",  CourseStatus.DROPPED, "Test Course Notes", "Jimmy Johnson","541-555-555", "JJohnson@email.com", 0));
            courses.add(new CourseEntity(2, "History Course", "10/1/2023", "4/1/2024",  CourseStatus.PLAN_TO_TAKE, "Test Course Notes", "Jimmy Johnson","541-555-555", "JJohnson@email.com", 0));
            courses.add(new CourseEntity(3, "Geography Course", "10/1/2023", "4/1/2024",  CourseStatus.IN_PROGRESS, "Test Course Notes", "James Reed","541-555-555", "JReed@email.com", 1));
            courses.add(new CourseEntity(4, "Politics Course", "10/1/2023", "4/1/2024",  CourseStatus.IN_PROGRESS, "Test Course Notes", "James Reed","541-555-555", "JReed@email.com", 1));
            courses.add(new CourseEntity(5, "Computer Science Course", "10/1/2023", "4/1/2024",  CourseStatus.IN_PROGRESS, "Test Course Notes", "Mary Clancy","541-555-555", "MClancy@email.com", 2));

            return courses;
        }

    // TODO: modify dummy data

        public static List<AssessmentEntity> getSampleAssessments() {
            List<AssessmentEntity> assessments = new ArrayList<>();
            assessments.add(new AssessmentEntity(0, "Sample Assessment 1", AssessmentType.OA, DATE, DATE.plusMonths(1),0));
            assessments.add(new AssessmentEntity(1, "Sample Assessment 2", AssessmentType.PA, DATE, DATE.plusMonths(1),0));
            assessments.add(new AssessmentEntity(2, "Sample Assessment 3", AssessmentType.PA, DATE, DATE.plusMonths(1),1));
            assessments.add(new AssessmentEntity(3, "Sample Assessment 4", AssessmentType.OA, DATE, DATE.plusMonths(1),1));


            return assessments;
        }
}
