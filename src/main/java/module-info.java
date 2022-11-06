module com.example.drawing {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.drawing to javafx.fxml;
    exports com.example.drawing;
    exports com.example.drawing.Controller;
    opens com.example.drawing.Controller to javafx.fxml;
}