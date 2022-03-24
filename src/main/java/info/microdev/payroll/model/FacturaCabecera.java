package info.microdev.payroll.model;

import lombok.*;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class FacturaCabecera {

    @Id
    private int id;
    @ManyToOne
    private Cliente cliente;
    private String tipo;
    @Temporal(TemporalType.DATE)
    private GregorianCalendar gregorianCalendar;
    private double subtotal;
    private double subtotal0;
    private double iva;
    private double descuento;
    private double total;
    private String anulada;
    private double valorCancelado;
    private double cambio;
    @ManyToOne
    private Empleado empleado;

    @OneToMany(
            mappedBy = "facturaCabecera",
            cascade = {CascadeType.PERSIST}
    )
    private List<FacturaDetalle> facturaDetalleList;
    @OneToOne
    private RetencionVentaCabecera retencionVentaCabecera;

}
