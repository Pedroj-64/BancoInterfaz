package co.edu.uniquindio.poo.bancointerfaz.Controller;

import co.edu.uniquindio.poo.bancointerfaz.App;
import co.edu.uniquindio.poo.bancointerfaz.Model.Banco;
import co.edu.uniquindio.poo.bancointerfaz.Model.Usuario;
import com.fasterxml.jackson.core.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginController {

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private PasswordField txtPassword;

    public static boolean verificacion(String id, String password) throws Exception {
        Usuario usuario = Banco.getInstancia().buscarUsuario(id);

        if (usuario == null) {
            throw new Exception("El usuario no existe");
        }

        if (!usuario.getPassword().equals(password)) {
            throw new Exception("Contraseña incorrecta");
        }

        return true;
    }
}
