package com.classroom.classroomversion08fx.logic;

/**
 * The type Student.
 */
public class Student {

    private final String name;
    private final String major;

    /**
     * Instantiates a new Student.
     *
     * @param name  the name
     * @param major the major
     */
    public Student (String name, String major) {
        this.name = name;
        this.major = major;
    }

    /**
     * Gets final grade.
     *
     * @param preGradeFactor the pre grade factor
     * @return the final grade
     */
    public Double getFinalGrade (Double preGradeFactor) {
        throw new IllegalArgumentException ("Falscher Studententyp");
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName () {
        return name;
    }

    /**
     * Gets majors.
     *
     * @return the majors
     */
    public String getMajors () {
        return major;
    }


    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType () {
        if (this instanceof RegularStudent) return "";
        else if (this instanceof IrregularStudent) return "*";
        else return "Student";
    }

    /**
     * Gets final grade.
     *
     * @param <T> the type parameter
     * @return the final grade
     */
    public <T> Comparable getFinalGrade () {
        return null;
    }
}
