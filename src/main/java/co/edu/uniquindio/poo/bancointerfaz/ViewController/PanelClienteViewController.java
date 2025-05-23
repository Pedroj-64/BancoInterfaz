package co.edu.uniquindio.poo.bancointerfaz.ViewController;


import co.edu.uniquindio.poo.bancointerfaz.App;
import co.edu.uniquindio.poo.bancointerfaz.Controller.PanelClienteController;
import co.edu.uniquindio.poo.bancointerfaz.Model.Transaccion;
import co.edu.uniquindio.poo.bancointerfaz.Model.UsuarioActivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


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
    private Label numeroCuenta;

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
        var transacciones = controller.obtenerTransaccionesUsuarioActual();
        System.out.println("Transacciones cargadas: " + transacciones.size());
        transacciones.forEach(System.out::println);
        tablaTransacciones.getItems().setAll(transacciones);
    }

    private void mostrarNumeroCuenta() {
        numeroCuenta.setText(controller.obtenerNumeroCuentaUsuarioActual());
    }

    @FXML
    private void CerrarSesion(ActionEvent event) {
        UsuarioActivo.setUsuarioActual(null);
        App.loadScene("inicio", 400, 400);
    }

    @FXML
    private void Consultar() {
        try {
            var usuario = UsuarioActivo.getUsuario();
            var billetera = App.getBanco().buscarBilleteraUsuario(usuario.getId());

            double saldo = billetera.getSaldo();

            App.showAlert("Saldo Actual", "Tu saldo disponible es: $" + saldo, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            App.showAlert("Error", "No se pudo consultar el saldo:\n" + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }


    public void Transferir (ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("transferencia.fxml"));
            Parent root = fxmlLoader.load();
            TransferenciaViewController controller = fxmlLoader.getController();

            var usuario = UsuarioActivo.getUsuario();
            var billetera = App.getBanco().buscarBilleteraUsuario(usuario.getId());

            if (billetera == null) {
                throw new Exception("No se encontró la billetera del usuario.");
            }

            controller.setNumeroBilleteraOrigen(billetera.getNumero());
            controller.setOnTransferenciaExit(() -> refrescarTransacciones());

            Stage stage = new Stage();
            stage.setTitle("Transferencia");
            stage.setScene(new Scene(root, 400, 400));
            stage.setResizable(false);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            App.showAlert("Error", "No se pudo abrir la ventana de transferencia:\n" + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ActualizarDatos (ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actualizarDatos.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Actualizar datos");
            stage.setScene(new Scene(root, 400, 400));
            stage.setResizable(false);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException e) {
            App.showAlert("Error", "No se pudo abrir la ventana de Actualizar Datos:\n" + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }

    }

    public void refrescarTransacciones() {
        cargarTransacciones();
    }
}




