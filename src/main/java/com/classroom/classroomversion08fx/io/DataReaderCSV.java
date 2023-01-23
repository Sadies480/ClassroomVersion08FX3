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

public class DataReaderCSV implements CourseDataReader {

    private final File CSVFile;

    public DataReaderCSV (File CSVFile) {
        this.CSVFile = CSVFile;
    }


    public Optional readData () {
        Scanner scanner;
        ArrayList<Student> students = new ArrayList<Student> ();
        ArrayList<Double> grades = new ArrayList<Double> ();
        Course optionalCourse = null;
        String line;
        String[] parts;
        int i = 0;

        try {
            scanner = new Scanner (CSVFile);

            String line1 = scanner.nextLine ();
            String line2 = scanner.nextLine ();

            while (scanner.hasNextLine ()) { //erstellt einen studenten
                line = scanner.nextLine ();
                parts = line.split (",");

                if (parts[2].equals ("r") | parts[2].equals (" r") | parts[2].equals ("r ") | parts[2].equals (" r ")) {
                    students.add (new IrregularStudent (parts[0], parts[1], Double.parseDouble (parts[3])));
                } else if (parts[2].equals ("")) {

                    for (int j = 4; j < parts.length; j++) { // Um einen neuen Kurs in die Liste einzufügen, muss zuerst eine Liste mit Studenten befüllt werden, in welcher jeder einzelne Student eine Liste mit Noten hat
                        grades.add (Double.parseDouble (parts[j]));
                    }
                    students.add (new RegularStudent (parts[0], parts[1], (ArrayList<Double>) grades.clone (), Double.parseDouble (parts[3])));
                    grades.clear (); // leert Liste für nächsten Studenten
                    i++;
                } else {
                    throw new IllegalArgumentException ("Falscher Studententyp");
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
