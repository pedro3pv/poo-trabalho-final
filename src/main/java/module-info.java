module com.poo.javafx.pootrabalhofinaljavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.poo.javafx.pootrabalhofinaljavafx to javafx.fxml;
    exports com.poo.javafx.pootrabalhofinaljavafx;
}