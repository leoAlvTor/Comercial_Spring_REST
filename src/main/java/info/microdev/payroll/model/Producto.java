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
public class Producto {

    @Id
    private String codigo;
    private String codigoPrincipal;
    private String nombre;
    private String nombrePrincipal;
    @Temporal(TemporalType.DATE)
    private GregorianCalendar fecha;
    @ManyToOne
    private Proveedor proveedor;
    @OneToMany(
            mappedBy = "producto"
    )
    @ToString.Exclude
    private List<CompraDetalle> compraDetalleList;
    @OneToMany(
            mappedBy = "producto"
    )
    @ToString.Exclude
    private List<FacturaDetalle> facturaDetalleList;
    private String categoria;
    private String representacion;
    private int cantidadInterna;
    private double stockPaquete;
    private double stockUnitario;
    private double precioCaja;
    private double precioUnitario;
    private String impuesto;
    private double precioCaja12;
    private double precioUnitario12;
    private double precioVentaCaja;
    private double precioVentaUnidad;

}
