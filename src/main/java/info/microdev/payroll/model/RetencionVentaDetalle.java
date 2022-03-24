package info.microdev.payroll.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class RetencionVentaDetalle {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String ejercicioFiscal;
    private double baseImponible;
    private String impuesto;
    private String codigoImpuesto;
    private String porcentajeRetencion;
    private double valorRetenido;
    @ManyToOne
    private RetencionVentaCabecera retencionVentaCabecera;

}
