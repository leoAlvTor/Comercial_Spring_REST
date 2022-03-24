package info.microdev.payroll.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class FacturaDetalle {

    @Transient
    private int pseudoID;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @ManyToOne
    private Producto producto;
    private double cantidad;
    private double total;
    private char representacion;
    @ManyToOne(
            cascade = {CascadeType.PERSIST}
    )
    private FacturaCabecera facturaCabecera;

}
