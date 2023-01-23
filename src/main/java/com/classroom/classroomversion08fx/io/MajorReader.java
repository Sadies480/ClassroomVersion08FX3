package com.classroom.classroomversion08fx.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorReader {

    private final File majorMapFile;

    public MajorReader (File majorMapFile) {
        this.majorMapFile = majorMapFile;
    }

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
