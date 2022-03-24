package info.microdev.payroll.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Cliente {

    @Id
    private String cedula;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;

    @OneToMany(
            mappedBy = "cliente"
    )
    private List<FacturaCabecera> facturaCabeceraList;

}
