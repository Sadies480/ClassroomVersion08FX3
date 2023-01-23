package com.classroom.classroomversion08fx.logic;

import java.util.ArrayList;

public class RegularStudent extends Student {
    private final ArrayList<Double> grades;
    private final Double examGrade;

    public RegularStudent (String name, String major, ArrayList<Double> grades, Double examGrade) {
        super (name, major);
        this.grades = grades;
        this.examGrade = examGrade;
    }

    public Double computeGradeAverage () {
        double worst = this.grades.get (0);
        double sum = 0;
        for (final double mark : this.grades) {
            if (mark < worst) worst = mark;
            sum = sum+mark;
        }
        return (sum-worst) / (this.grades.size ()-1);

    }

    @Override
    public Double getFinalGrade (Double preGradeFactor) {
        Double preGradeAverage = computeGradeAverage ();
        return preGradeAverage * (preGradeFactor / 100)+examGrade * (1-(preGradeFactor / 100));
    }

}
