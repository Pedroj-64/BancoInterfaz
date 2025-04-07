package co.edu.uniquindio.poo.bancointerfaz.ViewController;


import co.edu.uniquindio.poo.bancointerfaz.Controller.PanelClienteController;
import co.edu.uniquindio.poo.bancointerfaz.Model.Transaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class PanelClienteViewController {

    @FXML
    private TableView<Transaccion> tablaTransacciones;
    @FXML
    private TableColumn<Transaccion, String> colTipo;
    @FXML
    private TableColumn<Transaccion, String> colFecha;
    @FXML
    private TableColumn<Transaccion, Double> colValor;
    @FXML
    private TableColumn<Transaccion, String> colUsuario;
    @FXML
    private TableColumn<Transaccion, String> colCategoria;
    @FXML
    private Label NumeroCuenta;

    private final PanelClienteController controller = new PanelClienteController();

    public void initialize() {
        configurarColumnas();
        cargarTransacciones();
        mostrarNumeroCuenta();
    }

    private void configurarColumnas() {
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    }

    private void cargarTransacciones() {
        tablaTransacciones.getItems().setAll(controller.obtenerTransaccionesUsuarioActual());
    }

    private void mostrarNumeroCuenta() {
        NumeroCuenta.setText(controller.obtenerNumeroCuentaUsuarioActual());
    }

    @FXML
    private void CerrarSesion(ActionEvent event) {
        cambiarVista("inicio.fxml", event);
    }

    @FXML
    private void Consultar() {
        cargarTransacciones();
    }

    @FXML
    private void Transferir(ActionEvent event) {
        cambiarVista("transferencia.fxml", event);
    }

    @FXML
    private void ActualizarDatos() {

    }

    @FXML
    public void cambiarVista(String fxml, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/bancointerfaz/" + fxml));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error cargando FXML: " + fxml);
            e.printStackTrace();

        }

    }
}


