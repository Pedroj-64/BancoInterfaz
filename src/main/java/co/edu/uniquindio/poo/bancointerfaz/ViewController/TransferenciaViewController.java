package co.edu.uniquindio.poo.bancointerfaz.ViewController;

import co.edu.uniquindio.poo.bancointerfaz.Controller.TransferenciaController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TransferenciaViewController {

    public void mostrarVistaTransferencia(String numeroBilleteraOrigen) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/bancointerfaz/Transferencia.fxml"));
            Parent root = loader.load();

            TransferenciaController controller = loader.getController();
            controller.setNumeroBilleteraOrigen(numeroBilleteraOrigen);

            Stage stage = new Stage();
            stage.setTitle("Transferencia");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
