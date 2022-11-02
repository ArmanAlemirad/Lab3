package com.example.drawing.Controller;

import com.example.drawing.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import static com.example.drawing.Model.ShapeType.*;

public class DrawingController {
    public ChoiceBox<ShapeType> shapeBoxList;
    public ColorPicker colorPicker;
    public Button undo;
    public Button save;
    public Canvas canvas;
    public TextField shapeSize;

    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());
GraphicsContext context;
    public void initialize() {
        shapeBoxList.setItems(shapeTypesList);
        shapeBoxList.setValue(LINE);
        colorPicker.setValue(Color.BLACK);
        shapeSize.setText("12");

        context = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e->{
            double size = Double.parseDouble(shapeSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;
            context.setFill(colorPicker.getValue());
            context.fillRect(x,y,size,size);
        });
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        Shape shape = Shape.createShape(shapeBoxList.getValue(), mouseEvent.getX(), mouseEvent.getY());
        System.out.println(shape);

    }

    public void draw(MouseEvent mouseEvent) {
        canvas.setOnMouseDragged(e->{
            double size = Double.parseDouble(shapeSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

        });
    }
}
