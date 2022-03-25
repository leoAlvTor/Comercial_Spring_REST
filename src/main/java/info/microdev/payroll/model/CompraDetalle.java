package info.microdev.payroll.model;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CompraDetalle {

    @Transient
    private int pseudoID;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private CompraCabecera compraCabecera;
    private int cantidad;
    private double precioUnitario;
    private double valorTotal;
    private double precioVentaUnitario;
    private double precioCaja;
    private double valorTotalCaja;
    private double precioVentaCaja;
    private String tarifa;
    @Temporal(TemporalType.DATE)
    private Calendar fechaVencimiento;
    private char representacion;
    private int dummy;

}
