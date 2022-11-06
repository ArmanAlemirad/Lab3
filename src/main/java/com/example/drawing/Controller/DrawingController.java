package com.example.drawing.Controller;

import com.example.drawing.Model.Line;
import com.example.drawing.Model.Rectangle;
import com.example.drawing.Model.Shape;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.util.*;

public class DrawingController<RenderedImage> {

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
    public boolean isZoomInClicked = false;
    public boolean isZoomOutClicked = false;


    public boolean isRectClicked = false;
    public ColorPicker secondColorPicker;

    Stack<Shape> shapeStack = new Stack<>();

    GraphicsContext context;

    public void undoBtn(MouseEvent mouseEvent) {

        if (!shapeStack.isEmpty()) {
            shapeStack.pop();
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (Shape shape : shapeStack) {
                shape.draw(canvas);
            }
        }

    }


    public void initialize() {
        context = canvas.getGraphicsContext2D();
        colorPicker.setValue(Color.BLACK);
        secondColorPicker.setValue(Color.WHITE);


        shapeSize.setText("12");
    }


    public void deleteAll(ActionEvent actionEvent) {
        if (checkBox.isSelected()) {
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }


    public void zoomOut(MouseEvent mouseEvent) {
    }

    public void zoomIn(MouseEvent mouseEvent) {
        if (isZoomInClicked) {
            canvas.setOnMousePressed(e -> {
                canvas.getOnZoom();
                canvas.setScaleX(2);
            });
        }
    }

    public void lineAction(ActionEvent actionEvent) {
        if (isLineClicked) {
            double size = Double.parseDouble(shapeSize.getText());
            canvas.setOnMousePressed(e -> {
                Line line = new Line(0, 0, 0, 0, size, colorPicker.getValue());

                System.out.println("canvas is pressed for Line");
                context.setStroke(colorPicker.getValue());
                context.setLineWidth(size);
                line.setStartX(e.getX());
                line.setStartY(e.getY());
                shapeStack.push(line);
            });
            canvas.setOnMouseDragged(e -> {

                System.out.println("Line is dragged");
            });
            canvas.setOnMouseReleased(e -> {
                Line line = (Line) shapeStack.peek();
                System.out.println("Line is release");
                line.setEndX(e.getX());
                line.setEndY(e.getY());
                context.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
            });


        }
    }

    public void rectangleAction(ActionEvent actionEvent) {
        double size = Double.parseDouble(shapeSize.getText());

        if (isRectClicked) {
            canvas.setOnMousePressed(e -> {
                Rectangle rectangle = new Rectangle(0,0,0,0,size, colorPicker.getValue(),0,0,secondColorPicker.getValue());

                context.setStroke(colorPicker.getValue());
                    context.setFill(secondColorPicker.getValue());
                    context.setLineWidth(size);
                    rectangle.setStartX(e.getX());
                    rectangle.setStartY(e.getY());
                shapeStack.push(rectangle);

            });
                canvas.setOnMouseDragged(e -> {
                });
                canvas.setOnMouseReleased(e -> {
                    Rectangle rectangle = (Rectangle) shapeStack.peek();

                    if(rectangle.getStartX() > e.getX()) {
                        rectangle.setEndX(rectangle.getStartX());
                        rectangle.setStartX(e.getX());
                    } else {
                        rectangle.setEndX(e.getX());
                    }
                    if(rectangle.getStartY() > e.getY()) {
                        rectangle.setEndY(rectangle.getStartY());
                        rectangle.setStartY(e.getY());
                    } else {
                        rectangle.setEndY(e.getY());
                    }
                    rectangle.setWidth(Math.abs(rectangle.getEndX() - rectangle.getStartX()));
                    rectangle.setHeight(Math.abs(rectangle.getEndY() - rectangle.getStartY()));
                    context.fillRect(rectangle.getStartX(), rectangle.getStartY(), rectangle.getWidth(), rectangle.getHeight());
                    context.strokeRect(rectangle.getStartX(), rectangle.getStartY(),rectangle.getWidth(), rectangle.getHeight());
                });
        }



    }

    public void saveAction(ActionEvent actionEvent) {

    }


    public void lineClicked(MouseEvent mouseEvent) {
        isLineClicked = true;
        isRectClicked = false;
    }

    public void rectClicked(MouseEvent mouseEvent) {
        isLineClicked = false;
        isRectClicked = true;
    }

    public void saveClick(MouseEvent mouseEvent) {
    }

    public void selectOnAction(ActionEvent actionEvent) {
       /* AtomicReference<Shape> chosenShape = null;
        canvas.setOnMousePressed(e->{
           List <Shape> list = shapeStack.stream().filter(i-> i instanceof Line).filter(l -> ((Line) l).getShapeCordinateX().contains(e.getX())&& ((Line) l).getShapeCordinateY().contains(e.getY())).toList();
            if (list.size() == 1){
               chosenShape.set(list.get(0));

            }
        });*/
    }

    public void selectShapeOnAction(ActionEvent actionEvent) {
    }


    //Variabel med current shapetype typ. if sats.., tex enum. för att sen köra onAction på knappen.
}







