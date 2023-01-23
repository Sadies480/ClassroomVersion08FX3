package com.classroom.classroomversion08fx.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Major reader.
 */
public class MajorReader {

    private final File majorMapFile;

    /**
     * Instantiates a new Major reader.
     *
     * @param majorMapFile the major map file
     */
    public MajorReader (File majorMapFile) {
        this.majorMapFile = majorMapFile;
    }

    /**
     * Read map map.
     *
     * @return the map
     */
    public Map<String, String> readMap () {

        String abbreviation;
        String fullMajorName;
        HashMap<String, String> majorMap = new HashMap<String, String> ();
        Scanner scanner;

        try {
            scanner = new Scanner (majorMapFile);
            while (scanner.hasNextLine ()) {
                abbreviation = scanner.next ();
                fullMajorName = scanner.next ();
                majorMap.put (abbreviation, fullMajorName);
            }
            scanner.close ();
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }

        return majorMap;
    }
}
