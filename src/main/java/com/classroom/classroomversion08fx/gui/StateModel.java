package com.classroom.classroomversion08fx.gui;

import com.classroom.classroomversion08fx.logic.Course;

import java.util.ArrayList;
import java.util.List;

public class StateModel {
private Course course;
private double preGradeFactor;
private boolean sortByGrade;

    private final List<StateObserver> observers;

    public StateModel() {
        observers = new ArrayList<>();
    }

    public Course getCourse() {
        return course;
    }

    public double getPreGradeFactor () {
        return preGradeFactor;
    }

    public boolean isSortByGrade () {
        return sortByGrade;
    }

    public void setCourse(Course course) {
        this.course = course;
        refreshStudentSort();
        sendStateChangedEvent ();
    }
    public void refreshStudentSort() {
        if (course != null) {
            course.sortStudents(sortByGrade);
        }
    }


    public void addObserver(StateObserver observer) {
        observers.add(observer);
    }

    private void sendStateChangedEvent() {
        for (StateObserver observer : observers) {
            observer.stateChanged();
        }
    }
}
