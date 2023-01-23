package com.classroom.classroomversion08fx.io;


import com.classroom.classroomversion08fx.logic.Course;
import com.classroom.classroomversion08fx.logic.IrregularStudent;
import com.classroom.classroomversion08fx.logic.RegularStudent;
import com.classroom.classroomversion08fx.logic.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 * The type Data reader text.
 */
public class DataReaderText implements CourseDataReader {

    private final File TagValueFile;

    /**
     * Instantiates a new Data reader text.
     *
     * @param TagValueFile the tag value file
     */
    public DataReaderText (File TagValueFile) {
        this.TagValueFile = TagValueFile;
    }


    public Optional readData () {
        Scanner scanner;
        ArrayList<Student> students = new ArrayList<Student> ();
        ArrayList<Double> grades = new ArrayList<Double> ();
        Course optionalCourse = null;
        String line;
        String[] parts;

        String nameString;
        String majorString;
        String isRepeatingString;
        String examGradeString;

        boolean repeat;
        Double examGrade;

        /*name: Ernst Meier
        major: mi
        is_repeating: false
        exam-grade: 3.5
        pre-grade: 4.3, 5.1, 2.3*/

        try {
            scanner = new Scanner (TagValueFile);

            line = scanner.nextLine ();
            parts = line.split (": ");
            String courseId = parts[1];

            line = scanner.nextLine ();
            parts = line.split (": ");
            String courseName = parts[1];

            while (scanner.hasNextLine ()) { //erstellt einen studenten

                nameString = scanner.nextLine ();
                majorString = scanner.nextLine ();
                isRepeatingString = scanner.nextLine ();
                examGradeString = scanner.nextLine ();

                parts = nameString.split (": ");
                nameString = parts[1];

                parts = majorString.split (": ");
                majorString = parts[1];

                parts = isRepeatingString.split (": ");
                repeat = Boolean.parseBoolean (parts[1]);

                parts = examGradeString.split (": ");
                examGrade = Double.parseDouble (parts[1]);

                if (repeat) {
                    students.add (new IrregularStudent (nameString, majorString, examGrade));
                } else {
                    line = scanner.nextLine ();
                    parts = line.split (": ");
                    line = parts[1];
                    parts = line.split (", ");

                    for (int i = 0; i < parts.length; i++) { // Um einen neuen Kurs in die Liste einzufügen, muss zuerst eine Liste mit Studenten befüllt werden, in welcher jeder einzelne Student eine Liste mit Noten hat
                        grades.add (Double.parseDouble (parts[i]));
                    }
                    students.add (new RegularStudent (nameString, majorString, (ArrayList<Double>) grades.clone (), examGrade));
                    grades.clear (); // leert Liste für nächsten Studenten
                }

            }
            optionalCourse = new Course ((ArrayList<Student>) students.clone ());
            students.clear ();

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
        return Optional.ofNullable (optionalCourse);
    }
}
