module co.edu.uniquindio.poo.bancointerfaz {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires static lombok;

    opens co.edu.uniquindio.poo.bancointerfaz to javafx.fxml;
    exports co.edu.uniquindio.poo.bancointerfaz;

    opens co.edu.uniquindio.poo.bancointerfaz.Controller to javafx.fxml;
    exports co.edu.uniquindio.poo.bancointerfaz.Controller;

    opens co.edu.uniquindio.poo.bancointerfaz.ViewController to javafx.fxml;
    exports co.edu.uniquindio.poo.bancointerfaz.ViewController;
}