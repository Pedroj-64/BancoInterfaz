package co.edu.uniquindio.poo.bancointerfaz.Controller;

import co.edu.uniquindio.poo.bancointerfaz.Model.Banco;
import co.edu.uniquindio.poo.bancointerfaz.Model.BilleteraVirtual;
import co.edu.uniquindio.poo.bancointerfaz.Model.Transaccion;
import co.edu.uniquindio.poo.bancointerfaz.Model.Usuario;

import java.util.List;

public class PanelClienteController {
    private final Banco banco = Banco.getInstancia();
    private final Usuario usuarioActual = banco.getUsuarioActual();
    private final BilleteraVirtual billeteraUsuario = banco.buscarBilleteraUsuario(usuarioActual.getId());

    public List<Transaccion> obtenerTransaccionesUsuarioActual() {
        return billeteraUsuario.getTransacciones();
    }

    public String obtenerNumeroCuentaUsuarioActual() {
        return billeteraUsuario.getNumero();
    }

}
