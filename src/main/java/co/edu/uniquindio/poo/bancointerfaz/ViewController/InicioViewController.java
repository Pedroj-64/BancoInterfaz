package co.edu.uniquindio.poo.bancointerfaz.ViewController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.bancointerfaz.Controller.InicioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class InicioViewController {

    private final InicioController inicioController = new InicioController();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void irIniciarSesion(ActionEvent event) {

        inicioController.cambiarVista("login.fxml", event);
    }

    @FXML
    void irRegistroCliente(ActionEvent event) {

        inicioController.cambiarVista("registro.fxml", event);
    }


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}




