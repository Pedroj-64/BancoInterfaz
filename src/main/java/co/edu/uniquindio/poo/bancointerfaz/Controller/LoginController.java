package co.edu.uniquindio.poo.bancointerfaz.Controller;

import co.edu.uniquindio.poo.bancointerfaz.App;
import co.edu.uniquindio.poo.bancointerfaz.Model.Banco;
import co.edu.uniquindio.poo.bancointerfaz.Model.Usuario;
import com.fasterxml.jackson.core.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import javafx.scene.control.TextField;


public class LoginController {

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private PasswordField txtPassword;

    public static Usuario verificacion(String id, String password) throws Exception {
        Banco banco = Banco.getInstancia();
        Usuario usuario = banco.buscarUsuario(id);

        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }

        return null;
    }
}
