package com.example.drawing.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class Model {

    private final ObservableList<ShapeType> choiceBoxList;
    private final ObservableList<Shape> shapeList;

    public ObjectProperty<String> size;
    private final ObjectProperty<Color> color;
    private final ObjectProperty<ShapeType> shapeType;

    public Model() {
        this.choiceBoxList = FXCollections.observableArrayList(ShapeType.values());
        this.shapeList = FXCollections.observableArrayList();
        this.size = new SimpleObjectProperty<>();
        this.color = new SimpleObjectProperty<>(Color.BLACK);
        this.shapeType = new SimpleObjectProperty<>(ShapeType.LINE);
    }
    public ObjectProperty<ShapeType> shapeTypeProperty() {
        return shapeType;
    }

    public Property<String> sizeProperty() {
        return size;
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

}