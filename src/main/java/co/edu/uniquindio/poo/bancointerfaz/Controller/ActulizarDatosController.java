package co.edu.uniquindio.poo.bancointerfaz.Controller;

import co.edu.uniquindio.poo.bancointerfaz.App;
import co.edu.uniquindio.poo.bancointerfaz.Model.Banco;
import javafx.scene.control.Alert.AlertType;

public class ActulizarDatosController {

    Banco banco= App.getBanco();

    public boolean actulizarUsuario(String id, String nombre, String password, String correo, String direccion) {
        boolean banderilla= false;
        try {
            banco.actualizarUsuario(id, nombre, password, correo, direccion);
            App.showAlert("Éxito", "Datos actualizados correctamente",AlertType.INFORMATION);
            banderilla=true;
        } catch (Exception e) {
            App.showAlert("Error", e.getMessage(), AlertType.ERROR);
        }

        return banderilla;
    }
    
}
