package co.edu.uniquindio.poo.bancointerfaz.Serializador;

/**
 * Clase para gestionar la serialización y deserialización de objetos.
 */
import java.io.*;

public class Serializador {

    /**
     * Guarda el estado de un objeto Serializable en un archivo.
     * 
     * @param objeto  El objeto a serializar.
     * @param archivo La ruta del archivo donde se guardará el objeto.
     * @throws IOException Si ocurre un error durante la escritura del archivo.
     */
    public static void guardarEstado(Serializable objeto, String archivo) throws IOException {
        File file = new File(archivo);
        System.out.println("Guardando el archivo en: " + file.getAbsolutePath());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(objeto);
        }
    }

    /**
     * Carga el estado de un objeto desde un archivo.
     * 
     * @param <T>     El tipo del objeto a deserializar.
     * @param archivo La ruta del archivo desde donde se cargará el objeto.
     * @return El objeto deserializado.
     * @throws IOException            Si ocurre un error durante la lectura del archivo.
     * @throws ClassNotFoundException Si no se encuentra la clase del objeto deserializado.
     */
    @SuppressWarnings("unchecked")
    public static <T> T cargarEstado(String archivo) throws IOException, ClassNotFoundException {
        File file = new File(archivo);
        System.out.println("Cargando el archivo desde: " + file.getAbsolutePath());
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (T) ois.readObject();
        }
    }
}

