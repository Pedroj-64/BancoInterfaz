package co.edu.uniquindio.poo.bancointerfaz.ViewController;

import co.edu.uniquindio.poo.bancointerfaz.App;
import co.edu.uniquindio.poo.bancointerfaz.Controller.RegistroController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroViewController {

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public void registrarse() {
        String id = txtIdentificacion.getText();
        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String email = txtCorreo.getText();
        String password = txtPassword.getText();

        try {
            RegistroController.registrarUsuario(id, nombre, direccion, email, password);
            App.showAlert("Éxito", "Usuario registrado correctamente", Alert.AlertType.INFORMATION);
            App.loadScene("login", 400, 400);
        } catch (Exception e) {
            App.showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
