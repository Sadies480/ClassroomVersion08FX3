package com.classroom.classroomversion08fx;


import com.classroom.classroomversion08fx.gui.MainPane;
import com.classroom.classroomversion08fx.io.MajorReader;
import com.classroom.classroomversion08fx.logic.Course;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Map;

/**
 * The type Main app.
 */
public class MainApp extends Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main (String[] args) {
        launch (args);
    }

    /**
     * Display average grades string.
     *
     * @param majorMap       the major map
     * @param course         the course
     * @param preGradeFactor the pre grade factor
     * @return the string
     */
    public static String displayAverageGrades (Map<String, String> majorMap, Course course, double preGradeFactor) {

        int numberOfStudents = course.getStudents ().size ();
        StringBuilder studentText = new StringBuilder ();
        String printName;
        String printMajor;
        String printType;
        double printaverage;

        for (int i = 0; i < numberOfStudents; i++) {
            printName = course.getStudents ().get (i).getName ();
            printType = course.getStudents ().get (i).getType ();

            printaverage = Math.round (course.getStudents ().get (i).getFinalGrade (preGradeFactor) * 100.0) / 100.0;
            printMajor = majorMap.get (course.getStudents ().get (i).getMajors ());
            studentText.append ("The average grade for ").append (printName).append (printType).append ("(").append (printMajor).append (") is: ").append (printaverage).append ("\n");
        }
        return studentText.toString ();
    }

    @Override
    public void start (Stage primaryStage) {
        File classesData = new File ("major-map.txt");
        MajorReader mapReader = new MajorReader (classesData);
        Map<String, String> majorMap = mapReader.readMap ();

        MainPane mainPane = new MainPane (majorMap);

        // Kick-off
        StackPane rootPane = new StackPane (mainPane);
        Scene scene = new Scene (rootPane, 500, 300);
        Stage stage = new Stage ();
        stage.setScene (scene);
        stage.setTitle ("Classroom App");
        stage.show ();
    }
}
