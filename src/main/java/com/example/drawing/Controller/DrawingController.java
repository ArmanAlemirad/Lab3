package com.example.drawing.Controller;

import com.example.drawing.Model.*;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.example.drawing.Model.ShapeType.*;

public class DrawingController {
    public ColorPicker colorPicker;
    public Button undo;
    public Button save;
    public Canvas canvas;
    public TextField shapeSize;
    public BorderPane borderPane;
    public Button zoomIn;
    public Button zoomOut;
    public ChoiceBox<ShapeType> choiceBox;

    ObservableList<ShapeType> shapeTypes = FXCollections.observableArrayList(ShapeType.values());

    public void initialize(){
        choiceBox.setItems(shapeTypes);
        choiceBox.setValue(BRUSH);
        colorPicker.setValue(Color.BLACK);
}
    public void canvasClicked(MouseEvent mouseEvent) {
        Shape shape = Shape.createShape(choiceBox.getValue(), mouseEvent.getX(), mouseEvent.getY());
        System.out.println(shape);
    }
}






