package com.example.drawing.Controller;
import com.example.drawing.Models.Rectangle;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DrawingControllerTest {
    DrawingController drawingController = new DrawingController();

    @Test
    void shouldSetWidthOnRectangle(){
        Rectangle rect = new Rectangle(234,234,0, Color.ANTIQUEWHITE, 0, 0);
        Assertions.assertEquals(0, rect.getWidth());
        drawingController.calculateWidth(245,rect);
        Assertions.assertEquals(245-234, rect.getWidth());
    }


    @Test
   void shouldSetEndYOnRectangle(){
        Rectangle rect = new Rectangle(234,234,0, Color.BLACK,0,0);
        Assertions.assertEquals(0, rect.getHeight());
        drawingController.calculateHeight(315,rect);
        Assertions.assertEquals(315-234, rect.getHeight());
    }

    @Test
    void test(){
        Rectangle rect = new Rectangle(234,234,0, Color.BLACK,0,0);
        Assertions.assertEquals(0, rect.getHeight());
        drawingController.calculateHeight(315,rect);
        Assertions.assertEquals(315-234, rect.getHeight());
    }

    @Test
    void test2(){
        Rectangle rect = new Rectangle(234,234,0, Color.BLACK,0,0);
        Assertions.assertEquals(0, rect.getHeight());
        drawingController.calculateHeight(315,rect);
        Assertions.assertEquals(315-234, rect.getHeight());
    }
    @Test
    void test3(){
        Rectangle rect = new Rectangle(235,235,0, Color.BLACK,0,0);
        Assertions.assertEquals(0, rect.getHeight());
        drawingController.calculateHeight(315,rect);
        Assertions.assertEquals(315-235, rect.getHeight());
    }

}
