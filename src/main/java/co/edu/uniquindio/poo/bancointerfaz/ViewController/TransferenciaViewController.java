package co.edu.uniquindio.poo.bancointerfaz.ViewController;

import co.edu.uniquindio.poo.bancointerfaz.App;
import co.edu.uniquindio.poo.bancointerfaz.Model.Banco;
import co.edu.uniquindio.poo.bancointerfaz.Model.Categoria;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lombok.Setter;

public class TransferenciaViewController {

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    private TextField txtMontoTransferir;

    @FXML
    private ComboBox<Categoria> comboCategoria;

    /**
     * -- SETTER --
     *  Método que permite pasar la billetera de origen desde la vista anterior.
     */
    @Setter
    private String numeroBilleteraOrigen;

    /**
     * Método que se ejecuta al iniciar la vista.
     * Llena el ComboBox con las categorías.
     */
    @FXML
    public void initialize() {

        comboCategoria.getItems().setAll(Categoria.values());
        comboCategoria.setOnAction(event -> {
            Categoria seleccionada = comboCategoria.getValue();
            if (seleccionada == Categoria.RECARGA && numeroBilleteraOrigen != null) {
                txtNumeroCuenta.setText(numeroBilleteraOrigen);
                txtNumeroCuenta.setDisable(true);
            } else {
                txtNumeroCuenta.clear();
                txtNumeroCuenta.setDisable(false);
            }
        });
    }

    /**
     * Este método lo llama el botón de transferencia.
     */
    @FXML
    private void Transferir() {
        try {
            String numeroDestino = txtNumeroCuenta.getText();
            String montoTexto = txtMontoTransferir.getText();
            Categoria categoria = comboCategoria.getValue();

            if (numeroDestino.isEmpty() || montoTexto.isEmpty() || categoria == null) {
                throw new Exception("Por favor, completa todos los campos.");
            }

            float monto = Float.parseFloat(montoTexto);

            if (numeroBilleteraOrigen == null || numeroBilleteraOrigen.isEmpty()) {
                throw new Exception("No se ha definido la billetera de origen.");
            }

            if (numeroDestino.equals(numeroBilleteraOrigen) && categoria != Categoria.RECARGA) {
                throw new Exception("No puedes transferirte a ti mismo.");
            }

            if (categoria == Categoria.RECARGA) {
                Banco.getInstancia().recargarBilletera(numeroDestino, monto);
            } else {
                Banco.getInstancia().realizarTransferencia(numeroBilleteraOrigen, numeroDestino, monto, categoria);
            }

            App.showAlert("Éxito", "La transferencia fue realizada exitosamente", Alert.AlertType.INFORMATION);
            limpiarCampos();
        } catch (NumberFormatException e) {
            App.showAlert("Error", "El monto debe ser un número válido", Alert.AlertType.ERROR);
        } catch (Exception e) {
            App.showAlert("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }


    private void limpiarCampos() {
        txtNumeroCuenta.clear();
        txtMontoTransferir.clear();
        comboCategoria.getSelectionModel().clearSelection();
    }


}
