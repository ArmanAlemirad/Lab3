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
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.util.*;

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
    Stack<Shape> shapeStack = new Stack<>();
     Stack<ArrayList<Shape>> primary = new Stack<ArrayList<Shape>>();
     Stack<ArrayList<Shape>> secondary = new Stack<ArrayList<Shape>>();
    ArrayList<Shape> shapeList = new ArrayList<Shape>();
    GraphicsContext context;

    public void undoBtn(MouseEvent mouseEvent) {
        if (!shapeStack.isEmpty()){
        shapeStack.pop();
        context.clearRect(0,0, canvas.getWidth(), canvas.getHeight() );
        for (Shape s: shapeStack) {
            s.draw(canvas);
        }
    }
    }



    public void initialize() {
        context = canvas.getGraphicsContext2D();
        choiceBox.setItems(shapeTypes);
        choiceBox.setValue(LINE);
        colorPicker.setValue(Color.BLACK);
        shapeSize.setText("12");
    }

    public void drawOnCanvas(MouseEvent mouseEvent) {

      /*  GraphicsContext context = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e -> {

            double size = Double.parseDouble(shapeSize.getText());
            context.setFill(colorPicker.getValue());
            context.fillRect(e.getX(),);
        });*/

    }


    public void drawFirstCordination(MouseEvent mouseEvent) {


        shapeStack.add(new Line(mouseEvent.getX(), mouseEvent.getY(), 0,0, Double.parseDouble(shapeSize.getText()),colorPicker.getValue()));
    }

    public void drawLastCordination(MouseEvent mouseEvent) {
        Shape s = shapeStack.peek();
        s.setEndX(mouseEvent.getX());
        s.setEndY(mouseEvent.getY());
        s.draw(canvas);

    }


    //Shape size  double size = Double.parseDouble(shapeSize.getText());

}






