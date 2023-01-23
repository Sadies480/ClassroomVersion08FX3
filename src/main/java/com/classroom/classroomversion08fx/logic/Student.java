package com.classroom.classroomversion08fx.logic;

public class Student {

    private final String name;
    private final String major;

    public Student (String name, String major) {
        this.name = name;
        this.major = major;
    }

    public Double getFinalGrade (Double preGradeFactor) {
        throw new IllegalArgumentException ("Falscher Studententyp");
    }

    public String getName () {
        return name;
    }

    public String getMajors () {
        return major;
    }


    public String getType () {
        if (this instanceof RegularStudent) return "";
        else if (this instanceof IrregularStudent) return "*";
        else return "Student";
    }

    public <T> Comparable getFinalGrade () {
        return null;
    }
}
