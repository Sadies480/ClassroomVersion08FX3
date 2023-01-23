package com.classroom.classroomversion08fx.logic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The type Course.
 */
public class Course {

    private final ArrayList<Student> students;

    /**
     * Instantiates a new Course.
     *
     * @param students the students
     */
    public Course (ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * Gets students.
     *
     * @return the students
     */
    public ArrayList<Student> getStudents () {
        return students;
    }

    /**
     * Sort students.
     *
     * @param sortByGrade the sort by grade
     */
    public void sortStudents (boolean sortByGrade) {
        if (sortByGrade) {
            students.sort ((s1, s2) -> s2.getFinalGrade ().compareTo (s1.getFinalGrade ()));
        } else {
            students.sort (Comparator.comparing (Student::getName));

        }
    }
}
