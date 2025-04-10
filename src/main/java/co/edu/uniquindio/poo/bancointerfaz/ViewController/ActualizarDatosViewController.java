package co.edu.uniquindio.poo.bancointerfaz.ViewController;

import co.edu.uniquindio.poo.bancointerfaz.App;
import co.edu.uniquindio.poo.bancointerfaz.Controller.ActulizarDatosController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ActualizarDatosViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCorreo"
    private TextField txtCorreo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDireccion"
    private TextField txtDireccion; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdentificacion"
    private TextField txtIdentificacion; // Value injected by FXMLLoader

    @FXML // fx:id="txtNombre"
    private TextField txtNombre; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassword"
    private PasswordField txtPassword; // Value injected by FXMLLoader

    ActulizarDatosController controller = new ActulizarDatosController();

    public void actulizarUsuario(ActionEvent actionEvent) {
        String id = txtIdentificacion.getText();
        String nombre = txtNombre.getText();
        String password = txtPassword.getText();
        String correo = txtCorreo.getText();
        String direccion = txtDireccion.getText();


        if(controller.actulizarUsuario(id, nombre, password, correo, direccion)){
            txtIdentificacion.clear();
            txtNombre.clear();
            txtPassword.clear();
            txtCorreo.clear();
            txtDireccion.clear();
            App.showAlertAndRedirect("Éxito", "Datos actualizados correctamente", Alert.AlertType.INFORMATION, "panelCliente.fxml", 400, 400);
        };


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}

