package co.edu.uniquindio.poo.bancointerfaz.Controller;

import co.edu.uniquindio.poo.bancointerfaz.Model.Banco;

public class RegistroController {

    public static void registrarUsuario(String id, String nombre, String direccion, String email, String password) throws Exception {
        Banco banco = Banco.getInstancia();
        banco.registrarUsuario(id, nombre, direccion, email, password);
    }

}
