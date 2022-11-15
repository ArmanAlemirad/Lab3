package com.example.drawing.Controller;

import com.example.drawing.Models.*;
import com.example.drawing.SVG.FileWriter;
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
    public CheckBox deleteBox;
    public ChoiceBox<ShapeType> choiceBox;
    public CheckBox changeShape;

    Model model = new Model();
    Stack<Shape> undoShapeStack = new Stack<>();
    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());
    GraphicsContext context;

    public void initialize() {
        colorPicker.valueProperty().bindBidirectional(model.colorProperty());
        shapeSize.textProperty().bindBidirectional(model.sizeProperty());
        choiceBox.valueProperty().bindBidirectional(model.shapeTypeProperty());

        choiceBox.setItems(shapeTypesList);
        context = canvas.getGraphicsContext2D();
        colorPicker.setValue(Color.BLACK);
        shapeSize.setText("12");
    }

    public void choiceBoxClicked(MouseEvent mouseEvent) {
        if (choiceBox.getValue() == ShapeType.LINE) {
            double size = Double.parseDouble(shapeSize.getText());
            canvas.setOnMousePressed(e -> {
                if (!changeShape.isSelected()) {
                    Line line = (Line) Shape.createShapes(ShapeType.LINE, 0, 0, size, colorPicker.getValue());
                    context.save();
                    context.setStroke(colorPicker.getValue());
                    context.setLineWidth(size);
                    line.setStartX(e.getX());
                    line.setStartY(e.getY());
                    undoShapeStack.push(line);
                }
            });
            canvas.setOnMouseReleased(e -> {
                if (!changeShape.isSelected()) {
                    Line line = (Line) undoShapeStack.peek();
                    line.setEndX(e.getX());
                    line.setEndY(e.getY());
                    context.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
                    context.restore();
                }
            });

        } else if (choiceBox.getValue() == ShapeType.RECTANGLE) {
            double size = Double.parseDouble(shapeSize.getText());
            canvas.setOnMousePressed(e -> {
                if (!changeShape.isSelected()) {
                    Rectangle rectangle = (Rectangle) Shape.createShapes(ShapeType.RECTANGLE, 0, 0, size, colorPicker.getValue());
                    context.save();
                    context.setFill(colorPicker.getValue());
                    rectangle.setStartX(e.getX());
                    rectangle.setStartY(e.getY());
                    undoShapeStack.push(rectangle);
                }
            });

            canvas.setOnMouseReleased(e -> {
                if (!changeShape.isSelected()) {
                    Rectangle rect = (Rectangle) undoShapeStack.peek();
                    calculateWidth(e.getX(), rect);
                    calculateHeight(e.getY(), rect);
                    context.fillRect(rect.getStartX(), rect.getStartY(), rect.getWidth(), rect.getHeight());
                    context.strokeRect(rect.getStartX(), rect.getStartY(), rect.getWidth(), rect.getHeight());
                    context.restore();

                }
            });
        }
    }

    public void undoBtn(MouseEvent mouseEvent) {

        if (!undoShapeStack.isEmpty()) {
            undoShapeStack.pop();
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (Shape shape : undoShapeStack) {
                shape.draw(canvas);
            }
        }
    }

    public void saveClick(MouseEvent mouseEvent) {
        FileWriter.svgWriter(undoShapeStack);
    }


    public void deleteAll(ActionEvent actionEvent) {
        if (deleteBox.isSelected()) {
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }


    public void calculateHeight(double eventY, Rectangle rectangle) {
        if (rectangle.getStartY() > eventY) {
            double startY = rectangle.getStartY();
            rectangle.setStartY(eventY);
            rectangle.setHeight(startY - eventY);
        } else {
            rectangle.setHeight(eventY - rectangle.getStartY());
        }
    }


    public void calculateWidth(double eventX, Rectangle rectangle) {
        if (rectangle.getStartX() > eventX) {
            double startX = rectangle.getStartX();
            rectangle.setStartX(eventX);
            rectangle.setWidth(startX - eventX);
        } else {
            rectangle.setWidth(eventX - rectangle.getStartX());
        }
    }

    public void changeShapeAction(ActionEvent actionEvent) {
        canvas.setOnMousePressed(e -> {
            if (changeShape.isSelected()) {
                Optional<Shape> selectedShape = undoShapeStack.stream().filter(shape -> shape.checkInsideTheShape(e.getX(), e.getY())).findFirst();

                if (selectedShape.isPresent()) {
                    selectedShape.get().setColor(colorPicker.getValue());

                    selectedShape.get().draw(canvas);
                }
            }
        });

    }
}








