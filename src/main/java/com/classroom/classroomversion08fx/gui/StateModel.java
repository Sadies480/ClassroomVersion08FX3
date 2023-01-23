package com.classroom.classroomversion08fx.gui;

import com.classroom.classroomversion08fx.logic.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * The type State model.
 */
public class StateModel {
    private final List<StateObserver> observers;
    private Course course;
    private double preGradeFactor;
    private boolean sortByGrade;

    /**
     * Instantiates a new State model.
     */
    public StateModel () {
        observers = new ArrayList<> ();
    }

    /**
     * Gets course.
     *
     * @return the course
     */
    public Course getCourse () {
        return course;
    }

    /**
     * Sets course.
     *
     * @param course the course
     */
    public void setCourse (Course course) {
        this.course = course;
        refreshStudentSort ();
        sendStateChangedEvent ();
    }

    /**
     * Gets pre grade factor.
     *
     * @return the pre grade factor
     */
    public double getPreGradeFactor () {
        return preGradeFactor;
    }

    /**
     * Is sort by grade boolean.
     *
     * @return the boolean
     */
    public boolean isSortByGrade () {
        return sortByGrade;
    }

    /**
     * Refresh student sort.
     */
    public void refreshStudentSort () {
        if (course != null) {
            course.sortStudents (sortByGrade);
        }
    }


    /**
     * Add observer.
     *
     * @param observer the observer
     */
    public void addObserver (StateObserver observer) {
        observers.add (observer);
    }

    private void sendStateChangedEvent () {
        for (StateObserver observer : observers) {
            observer.stateChanged ();
        }
    }
}
