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
    public Button brushBtn;
    public Button rectBtn;
    public Button CircleBtn;


    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());
    Rectangle  rectangle;
    Stack<Image> undoList = new Stack<>();
    GraphicsContext context;

    public void initialize() {
        colorPicker.setValue(Color.BLACK);
        shapeSize.setText("12");
        //context = canvas.getGraphicsContext2D();
    }


    public void canvasClicked(MouseEvent mouseEvent) {





    }

    public void draw(MouseEvent mouseEvent) {
        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(shapeSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;
            context.setFill(colorPicker.getValue());
            context.fillRect(x, y, size, size);
        });
        FileChooser lineFile = new FileChooser();

    }

    public void undoButton(MouseEvent mouseEvent) {

    }
    public void drawRect ( ){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(colorPicker.getValue());
        gc.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getHeight(), rectangle.getWidth());
        gc.setFill(colorPicker.getValue());
        gc.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getHeight(), rectangle.getWidth());
    }

    public void rectDraw(MouseEvent mouseEvent) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(colorPicker.getValue());
        gc.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getHeight(), rectangle.getWidth());
        gc.setFill(colorPicker.getValue());
        gc.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getHeight(), rectangle.getWidth());
    }

    public void drawBrush(MouseEvent mouseEvent) {
    }

    public void drawStartRect(MouseEvent mouseEvent) {
    }

    public void drawShapeRect(MouseEvent mouseEvent) {
    }

    public void drawEndRect(MouseEvent mouseEvent) {
    }

    public void drawStartCircle(MouseEvent mouseEvent) {
    }

    public void drawShapeCircle(MouseEvent mouseEvent) {
    }

    public void drawEndCile(MouseEvent mouseEvent) {
    }

/*    //Rectangle draw
    GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(super.getColor());
        gc.strokeRect(super.getTopLeft().getX(), super.getTopLeft().getY(), width, height);
        gc.setFill(super.getFillColor());
        gc.fillRect(super.getTopLeft().getX(), super.getTopLeft().getY(), width, height);
}*/

}





