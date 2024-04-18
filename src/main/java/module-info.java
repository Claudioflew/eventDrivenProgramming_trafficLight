module org.example.lab12_javafx_trafficlight {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab12_javafx_trafficlight to javafx.fxml;
    exports org.example.lab12_javafx_trafficlight;
}