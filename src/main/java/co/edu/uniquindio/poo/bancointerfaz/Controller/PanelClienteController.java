package co.edu.uniquindio.poo.bancointerfaz.Controller;

import co.edu.uniquindio.poo.bancointerfaz.Model.*;

import java.util.List;

public class PanelClienteController {
    private final Banco banco = Banco.getInstancia();
    private final Usuario usuarioActual = UsuarioActivo.getUsuarioActual();
    private final BilleteraVirtual billeteraUsuario = banco.buscarBilleteraUsuario(usuarioActual.getId());

    public List<Transaccion> obtenerTransaccionesUsuarioActual() {
        return billeteraUsuario.getTransacciones();
    }

    public String obtenerNumeroCuentaUsuarioActual() {
        return billeteraUsuario.getNumero();
    }

}
