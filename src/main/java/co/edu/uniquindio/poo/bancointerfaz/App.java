package co.edu.uniquindio.poo.bancointerfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

import co.edu.uniquindio.poo.bancointerfaz.Model.Banco;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

public class App extends Application {

    private static Stage primaryStage;

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