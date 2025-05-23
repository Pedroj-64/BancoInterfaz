package co.edu.uniquindio.poo.bancointerfaz.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * Clase que representa una transacción bancaria
 * 
 * @version 1.0
 * @author
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaccion {
    private String id;
    private float monto;
    private LocalDateTime fecha;
    private Categoria tipo;
    private BilleteraVirtual billeteraOrigen, billeteraDestino;
    private float comision;


}