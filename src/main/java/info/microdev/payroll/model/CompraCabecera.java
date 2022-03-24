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
public class CompraCabecera {

    @Id
    private String autorizacion;
    private String numeroFactura;
    @Temporal(TemporalType.DATE)
    private GregorianCalendar fecha;
    private String formaPago;
    @ManyToOne
    private Proveedor proveedor;
    @OneToMany(
            mappedBy = "compraCabecera",
            cascade = {CascadeType.ALL}
    )
    private List<CompraDetalle> compraDetalleList;
    private String plazo;
    private double abono;
    private double subtotal12;
    private double subtotal0;
    private double totalIva;
    private double ice;
    private double irbp;
    private double total;
    private String anulada;


}
