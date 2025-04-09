package co.edu.uniquindio.poo.bancointerfaz.Model;

import lombok.Getter;
import lombok.Setter;

public class UsuarioActivo {
    @Getter
    @Setter
    private static Usuario usuarioActual;

    public static void cerrarSesion() {
        usuarioActual = null;
    }

}
