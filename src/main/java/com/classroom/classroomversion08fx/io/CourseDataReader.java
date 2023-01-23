package com.classroom.classroomversion08fx.io;



import com.classroom.classroomversion08fx.logic.Course;

import java.io.File;
import java.util.Optional;

public interface CourseDataReader {

    static Optional<CourseDataReader> getReader (String fileName) {
        if (fileName.endsWith (".csv")) {
            return Optional.of (new DataReaderCSV (new File (fileName)));
        } else if (fileName.endsWith (".txt")) {
            return Optional.of (new DataReaderText (new File (fileName)));
        }
        return Optional.empty ();
    }

    Optional<Course> readData ();

}
