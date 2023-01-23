package com.classroom.classroomversion08fx.logic;

public class IrregularStudent extends Student {

    private final Double examGrade;

    public IrregularStudent (String name, String major, Double examGrade) {
        super (name, major);
        this.examGrade = examGrade;
    }

    @Override
    public Double getFinalGrade (Double preGradeFactor) {
        return examGrade;
    }

}
