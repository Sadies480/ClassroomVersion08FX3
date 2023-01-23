package com.classroom.classroomversion08fx.gui;

import com.classroom.classroomversion08fx.logic.Student;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.List;


/**
 * The type Graphics pane.
 */
public class GraphicsPane extends Pane {

    private static List<Student> students;
    private static double preGradeFactor;
    private static Pane pane = new Pane ();


    private static void drawGraphic () {

        pane.getChildren ().clear ();
        double barWidth = 250 / students.size ();
        double barHeight;
        double x;
        double y;

        for (int i = 0; i < students.size (); i++) {
            barHeight = (Double) students.get (i).getFinalGrade (preGradeFactor) / 6.0 * 300;
            x = i * barWidth;
            y = 300-barHeight;
            Text nameText = new Text (students.get (i).getName ());
            nameText.getTransforms ().add (new Translate (x+barWidth / 2, 300-10));
            nameText.getTransforms ().add (new Rotate (-90));

            Rectangle gradeBar = new Rectangle (x, y, barWidth, barHeight);

            if (students.get (i).getFinalGrade (preGradeFactor) > 4) {
                gradeBar.setFill (Color.CORNFLOWERBLUE);
            } else {
                gradeBar.setFill (Color.INDIANRED);
            }
            pane.getChildren ().add (gradeBar);
            pane.getChildren ().add (nameText);

            Double fourLineHeight = 300-(4.0 / 6.0 * 300);

            Rectangle fourLine = new Rectangle (0, fourLineHeight, 400, 5);
            fourLine.setFill (Color.GREEN);

            pane.getChildren ().add (fourLine);
        }

    }

    /**
     * Gets pane.
     *
     * @return the pane
     */
    public static Pane getPane () {
        return pane;
    }

    /**
     * Sets students.
     *
     * @param students the students
     */
    public void setStudents (List<Student> students) {
        this.students = students;
        drawGraphic ();
    }

    /**
     * Sets pre grade factor.
     *
     * @param preGradeFactor the pre grade factor
     */
    public void setPreGradeFactor (double preGradeFactor) {
        this.preGradeFactor = preGradeFactor;
        drawGraphic ();
    }
}
