package co.edu.uniquindio.poo.bancointerfaz.ViewController;

import co.edu.uniquindio.poo.bancointerfaz.App;
import co.edu.uniquindio.poo.bancointerfaz.Controller.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginViewController {

    private final LoginController loginController = new LoginController();

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public void iniciarSesion() {
        String id = txtIdentificacion.getText();
        String password = txtPassword.getText();

        try {
            if (loginController.verificacion(id, password)) {
                App.loadScene("panelCliente", 800, 600); // Cambia por tu vista real
            } else {
                App.showAlert("Error", "Credenciales inválidas", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            App.showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}


