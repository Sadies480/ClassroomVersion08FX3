package com.classroom.classroomversion08fx.logic;

import java.util.ArrayList;
import java.util.Comparator;

public class Course {

    private final ArrayList<Student> students;

    public Course (ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents () {
        return students;
    }

    public void sortStudents (boolean sortByGrade) {
        if (sortByGrade) {
            students.sort((s1, s2) -> s2.getFinalGrade().compareTo(s1.getFinalGrade()));
        } else {
            students.sort(Comparator.comparing (Student::getName));


        }
    }
}
