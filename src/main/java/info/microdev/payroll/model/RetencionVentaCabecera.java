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
public class RetencionVentaCabecera {

    @Id
    public String numero;
    private String autorizacion;
    @Temporal(TemporalType.DATE)
    private GregorianCalendar fechaEmision;
    private String tipoComprobante;
    @OneToOne
    public FacturaCabecera facturaCabecera;
    @OneToMany(
            mappedBy = "retencionVentaCabecera"
    )
    private List<RetencionVentaDetalle> retencionVentaDetalles;

}
