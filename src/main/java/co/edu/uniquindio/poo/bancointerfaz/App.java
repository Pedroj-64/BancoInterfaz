package co.edu.uniquindio.poo.bancointerfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import co.edu.uniquindio.poo.bancointerfaz.Model.Banco;
import co.edu.uniquindio.poo.bancointerfaz.Serializador.Serializador;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class App extends Application {

    private static Stage primaryStage;
    private static Banco banco; 
    private static final String ARCHIVO_SERIALIZACION = "Banco.ser";


    @Override
    public void init() {
        try {
            File archivo = new File(ARCHIVO_SERIALIZACION);
            if (archivo.exists()) {
                banco = Serializador.cargarEstado(ARCHIVO_SERIALIZACION);
                System.out.println("Estado del objeto cargado exitosamente.");
            } else {
                banco = Banco.getInstancia(); // Crear nueva instancia si no existe el archivo
                System.out.println("No se encontró el archivo de estado, se creó una nueva instancia del objeto.");
            }
        } catch (IOException | ClassNotFoundException e) {
            banco = Banco.getInstancia(); // Crear nueva instancia en caso de error
            System.out.println("No se pudo cargar el estado del objeto, se creó una nueva instancia.");
        }
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        try {
            Scene scene = new Scene(loadFXML("inicio"), 600, 340);
            stage.setScene(scene); // Establecer la escena en el escenario
            stage.show(); // Mostrar la escena
        } catch (IOException e) {
            showAlert("Error al cargar la interfaz", "No se pudo cargar el archivo FXML: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void stop() {
        // Guardar el estado del concesionario antes de cerrar la aplicación
        try {
            Serializador.guardarEstado(banco, ARCHIVO_SERIALIZACION);
            System.out.println("Estado del objeto guardado exitosamente.");
        } catch (IOException e) {
            showAlert("Error al guardar el estado", "No se pudo guardar el estado del objeto: " + e.getMessage(), AlertType.ERROR);
        }
    }






    public static void loadScene(String fxml, double width, double height) {
        try {
            Parent root = loadFXML(fxml);
            Scene newScene = new Scene(root, width, height);
            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            showAlert("Error", "No se pudo cargar la vista: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public static void loadScene(String fxml, double width, double height, ActionEvent event) {
        loadScene(fxml, width, height);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/co/edu/uniquindio/poo/bancointerfaz/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showAlertAndRedirect(String title, String message, Alert.AlertType type, String fxml, double width, double height) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setOnHidden(evt -> loadScene(fxml, width, height));
        alert.show();
    }

    public static Banco getBanco() {
        return Banco.getInstancia();
    }

    public static void main(String[] args) {
        launch();
    }
}