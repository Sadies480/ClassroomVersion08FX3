package com.classroom.classroomversion08fx.io;


import com.classroom.classroomversion08fx.logic.Course;

import java.io.File;
import java.util.Optional;

/**
 * The interface Course data reader.
 */
public interface CourseDataReader {

    /**
     * Gets reader.
     *
     * @param fileName the file name
     * @return the reader
     */
    static Optional<CourseDataReader> getReader (String fileName) {
        if (fileName.endsWith (".csv")) {
            return Optional.of (new DataReaderCSV (new File (fileName)));
        } else if (fileName.endsWith (".txt")) {
            return Optional.of (new DataReaderText (new File (fileName)));
        }
        return Optional.empty ();
    }

    /**
     * Read data optional.
     *
     * @return the optional
     */
    Optional<Course> readData ();

}
