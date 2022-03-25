package info.microdev.payroll.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Empleado {

    @Id
    private String cedula;
    private String password;
    private String nombre;
    private String titulo;
    private String telefono;
    private String direccion;
    private int maquinaAsignada;
    private int indexActual;
    private int rangoInicial;
    private int rangoFinal;
    @OneToMany(
            mappedBy = "empleado"
    )
    @ToString.Exclude
    private List<FacturaCabecera> facturaCabeceraList;
}
