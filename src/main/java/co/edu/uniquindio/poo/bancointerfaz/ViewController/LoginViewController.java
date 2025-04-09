package co.edu.uniquindio.poo.bancointerfaz.ViewController;

import co.edu.uniquindio.poo.bancointerfaz.App;
import co.edu.uniquindio.poo.bancointerfaz.Controller.LoginController;
import co.edu.uniquindio.poo.bancointerfaz.Model.Usuario;
import co.edu.uniquindio.poo.bancointerfaz.Model.UsuarioActivo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
            Usuario usuario = LoginController.verificacion(id, password);
            if (usuario != null) {
                UsuarioActivo.setUsuarioActual(usuario); // <- AQUÍ GUARDAS EL USUARIO
                App.loadScene("panelCliente", 800, 600);
            } else {
                App.showAlert("Error", "Credenciales inválidas", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            App.showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}


