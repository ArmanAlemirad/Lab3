package com.example.drawing.SVG;

import com.example.drawing.Models.Shape;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Stack;

public class FileWriter {

    public static void svgWriter(Stack<Shape> shapes ) {
        List<String> svgStrings = shapes.stream().map(Shape::toSvg).toList();
        try {
            Files.writeString(Path.of("svgImage.svg"), "<svg width=\"446.0\" height=\"341.0\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">" + String.join(" ",svgStrings) + "</svg>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
