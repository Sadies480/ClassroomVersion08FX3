package com.classroom.classroomversion08fx.gui;


import com.classroom.classroomversion08fx.io.CourseDataReader;
import com.classroom.classroomversion08fx.logic.Course;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Map;
import java.util.Optional;

import static com.classroom.classroomversion08fx.MainApp.displayAverageGrades;


/**
 * The type Control pane.
 */
public class ControlPane extends StackPane {

    private static Map<String, String> majorMap;
    private static GraphicsPane graphicsPane;
    private Course course;

    /**
     * Instantiates a new Control pane.
     *
     * @param majorMap     the major map
     * @param graphicsPane the graphics pane
     */
    public ControlPane (Map<String, String> majorMap, GraphicsPane graphicsPane) {
        this.majorMap = majorMap;
        this.graphicsPane = graphicsPane;

        Button loadButton = new Button ("Choose File");

        Label numberLabel = new Label ("Anzahl Schüler: ");
        Label numberLabelValue = new Label ();
        TextArea textArea = new TextArea ();

        Slider preGradeFactorSlider = new Slider ();
        preGradeFactorSlider.setMin (0);
        preGradeFactorSlider.setMax (100);
        preGradeFactorSlider.setValue (30);
        preGradeFactorSlider.setShowTickLabels (true);
        preGradeFactorSlider.setShowTickMarks (true);
        preGradeFactorSlider.setMajorTickUnit (10);
        preGradeFactorSlider.setMinorTickCount (5);
        preGradeFactorSlider.setBlockIncrement (10);

        // Define the logic

        loadButton.setOnAction (event -> {
            FileChooser fileChooser = new FileChooser ();
            File dataFile = fileChooser.showOpenDialog (null);
            if (dataFile != null) {
                String fileName = dataFile.getAbsolutePath ();
                Optional<CourseDataReader> dataReader = CourseDataReader.getReader (fileName);
                if (dataReader.isPresent ()) {
                    Optional<Course> courseData = dataReader.get ().readData ();
                    if (courseData.isPresent ()) {
                        course = courseData.get ();
                        refreshText (course, textArea, preGradeFactorSlider.getValue ());
                        graphicsPane.setStudents (course.getStudents ());
                        numberLabelValue.setText (String.valueOf (course.getStudents ().size ()));

                    } else {
                        Alert alert = new Alert (Alert.AlertType.ERROR, "Unable to read coursedata from file"+fileName);
                        alert.showAndWait ();
                    }
                } else {
                    Alert alert = new Alert (Alert.AlertType.ERROR, "File format unknown for file"+fileName);
                    alert.showAndWait ();
                }

            }
        });

        preGradeFactorSlider.valueProperty ().addListener (observable -> {
            refreshText (course, textArea, preGradeFactorSlider.getValue ());
            graphicsPane.setPreGradeFactor (preGradeFactorSlider.getValue ());
        });

        // Layout the components
        VBox mainPane = new VBox ();
        HBox numberHBox = new HBox ();
        numberHBox.getChildren ().addAll (numberLabel, numberLabelValue);
        mainPane.getChildren ().add (numberHBox);
        mainPane.getChildren ().add (textArea);
        mainPane.getChildren ().add (preGradeFactorSlider);
        mainPane.getChildren ().add (loadButton);
        this.getChildren ().add (mainPane);
    }

    /**
     * Refresh text.
     *
     * @param course         the course
     * @param textArea       the text area
     * @param preGradeFactor the pre grade factor
     */
    public static void refreshText (Course course, TextArea textArea, Double preGradeFactor) {
        String studentText = displayAverageGrades (majorMap, course, preGradeFactor);
        textArea.setText (studentText);
    }

}
