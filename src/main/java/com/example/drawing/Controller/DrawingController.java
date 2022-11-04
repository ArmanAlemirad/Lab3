package com.example.drawing.Controller;

import com.example.drawing.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.util.*;

public class DrawingController {
    public ColorPicker colorPicker;
    public Button undo;
    public Button save;
    public Canvas canvas;
    public TextField shapeSize;
    public BorderPane borderPane;
    public Button zoomIn;
    public Button zoomOut;
    public CheckBox checkBox;
    public Button lineButton;
    public Button rectButton;

    public boolean isLineClicked = false;

    public boolean isRectClicked = false;


    ObservableList<ShapeType> shapeTypes = FXCollections.observableArrayList(ShapeType.values());
    Stack<Shape> shapeStack = new Stack<>();

    public String line = "Line";


    GraphicsContext context;

    public void undoBtn(MouseEvent mouseEvent) {
        if (!shapeStack.isEmpty()) {
            shapeStack.pop();
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (Shape s : shapeStack) {
                s.draw(canvas);
            }
        }
    }

    public void initialize() {
        context = canvas.getGraphicsContext2D();
        colorPicker.setValue(Color.BLACK);
        shapeSize.setText("12");
    }


    public void deleteAll(ActionEvent actionEvent) {
        if (checkBox.isSelected()) {
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

    public void drawFirstCordination(MouseEvent mouseEvent) {

        if(isLineClicked){
            shapeStack.add(new Line(mouseEvent.getX(), mouseEvent.getY(), 0, 0, Double.parseDouble(shapeSize.getText()), colorPicker.getValue()));

        } else if (isRectClicked){
            shapeStack.add(new Rectangle(mouseEvent.getX(), mouseEvent.getY(), mouseEvent.getX(), mouseEvent.getY(), Double.parseDouble(shapeSize.getText()), colorPicker.getValue(), 0, 0));

            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setStroke(colorPicker.getValue());
            gc.strokeRect(mouseEvent.getX(), mouseEvent.getY(), mouseEvent.getX(), mouseEvent.getY());
            gc.setFill(colorPicker.getValue());
            gc.fillRect(mouseEvent.getX(), mouseEvent.getY(), mouseEvent.getX(), mouseEvent.getY());
        }
            //shapeStack.add(new Rectangle(mouseEvent.getX(), mouseEvent.getY(), mouseEvent.getX(), mouseEvent.getY(), Double.parseDouble(shapeSize.getText()), colorPicker.getValue(), 0, 0));

    }

    public void drawLastCordination(MouseEvent mouseEvent) {

        if (isLineClicked) {
            Shape s = shapeStack.peek();
            s.setEndX(mouseEvent.getX());
            s.setEndY(mouseEvent.getY());
            s.setFillColor(colorPicker.getValue());
            s.draw(canvas);
        } else if (isRectClicked){
            Shape s = shapeStack.peek();
            s.setEndX(mouseEvent.getX());
            s.setEndY(mouseEvent.getY());
            s.setFillColor(colorPicker.getValue());
            s.draw(canvas);
        }
    }

    public void zoomOut(MouseEvent mouseEvent) {
    }

    public void zoomIn(MouseEvent mouseEvent) {
    }

    public void lineAction(ActionEvent actionEvent) {
    }

    public void rectangleAction(ActionEvent actionEvent) {
    }

    public void saveAction(ActionEvent actionEvent) {
    }

    public void canvasClicked(MouseEvent mouseEvent) {
    }

    public void lineClicked(MouseEvent mouseEvent) {
        isLineClicked = true;
        isRectClicked = false;
    }

    public void rectClicked(MouseEvent mouseEvent) {
        isLineClicked = false;
        isRectClicked = true;
    }


    //Variabel med current shapetype typ. if sats.., tex enum. för att sen köra onAction på knappen.
}







