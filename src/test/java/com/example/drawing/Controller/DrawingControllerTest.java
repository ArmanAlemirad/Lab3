package com.example.drawing.Controller;
import com.example.drawing.Model.Rectangle;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DrawingControllerTest {
    DrawingController drawingController = new DrawingController();

    @Test
    void shouldSetWidthOnRectangle(){
        Rectangle rect = new Rectangle(234,234,0, Color.ANTIQUEWHITE, 0, 0);
        Assertions.assertEquals(rect.getWidth() ,0);
        drawingController.setWidth(245,rect);
        Assertions.assertEquals(rect.getWidth(),245-234);
    }
    @Test
    void shouldSetEndYOnRectangle(){
        Rectangle rect = new Rectangle(234,234,0,0,123, Color.BLACK,0,0,Color.SALMON);
        Assertions.assertEquals(rect.getEndY(),0);
        drawingController.setY(315,rect);
        Assertions.assertEquals(rect.getEndY(),315);
    }

}