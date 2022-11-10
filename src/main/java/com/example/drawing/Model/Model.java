package com.example.drawing.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class Model {

    private  ObservableList<ShapeType> choiceBoxList;
    private ObservableList<Shape> shapeList;

    public ObjectProperty<String> size;
    private  ObjectProperty<Color> color;
    private ObjectProperty<ShapeType> shapeType;

    public Model() {
        this.choiceBoxList = FXCollections.observableArrayList(ShapeType.values());
        this.shapeList = FXCollections.observableArrayList();
        this.size = new SimpleObjectProperty<>("12");
        this.color = new SimpleObjectProperty<>(Color.BLACK);
        this.shapeType = new SimpleObjectProperty<>(ShapeType.LINE);
    }

    public ObjectProperty<ShapeType> shapeTypeProperty() {
        return shapeType;
    }

    public ShapeType getShapeType() {
        return shapeType.get();
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType.set(shapeType);
    }

    public Property<String> sizeProperty() {
        return size;
    }

    public String getSize() {
        return size.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public Color getColor() {
        return color.get();
    }

    public ObservableList<ShapeType> getchoiceBoxList() {
        return choiceBoxList;
    }

    public ObservableList<Shape> getShapeList() {
        return shapeList;
    }




}
