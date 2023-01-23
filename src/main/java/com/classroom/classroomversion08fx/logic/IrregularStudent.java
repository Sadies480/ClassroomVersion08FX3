package com.classroom.classroomversion08fx.logic;

/**
 * The type Irregular student.
 */
public class IrregularStudent extends Student {

    private final Double examGrade;

    /**
     * Instantiates a new Irregular student.
     *
     * @param name      the name
     * @param major     the major
     * @param examGrade the exam grade
     */
    public IrregularStudent (String name, String major, Double examGrade) {
        super (name, major);
        this.examGrade = examGrade;
    }

    @Override
    public Double getFinalGrade (Double preGradeFactor) {
        return examGrade;
    }

}
