package com.classroom.classroomversion08fx.gui;

import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

import java.util.Map;


/**
 * The type Main pane.
 */
public class MainPane extends StackPane {

    /**
     * The Major map.
     */
    Map<String, String> majorMap;

    /**
     * Instantiates a new Main pane.
     *
     * @param majorMap the major map
     */
    public MainPane (Map<String, String> majorMap) {
        StateModel stateModel = new StateModel ();

        this.majorMap = majorMap;

        GraphicsPane graphicsPane = new GraphicsPane ();
        ControlPane controlPane = new ControlPane (majorMap, graphicsPane);

        final SplitPane verticalSplitPane = new SplitPane ();
        verticalSplitPane.setOrientation ((Orientation.HORIZONTAL));
        verticalSplitPane.setDividerPosition (0, 0.5);
        verticalSplitPane.getItems ().addAll (controlPane, graphicsPane.getPane ());

        this.getChildren ().add (verticalSplitPane);

    }

}
