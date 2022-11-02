package com.example.drawing.Controller;

import com.example.drawing.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import static com.example.drawing.Model.ShapeType.*;

public class DrawingController {
    public ChoiceBox<ShapeType> shapeBoxList;
    public ColorPicker colorPicker;
    public Button undo;
    public Button save;
    public Canvas canvas;

    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());

    public void initialize() {
        shapeBoxList.setItems(shapeTypesList);
        shapeBoxList.setValue(LINE);
        colorPicker.setValue(Color.BLACK);
    }


    public void canvasClicked(MouseEvent mouseEvent) {
        Shape shape = Shape.createShape(shapeBoxList.getValue(), mouseEvent.getX(), mouseEvent.getY());
        System.out.println(shape);

    }
}
