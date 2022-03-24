package info.microdev.payroll.model;

import lombok.*;

import javax.persistence.CascadeType;
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
public class Proveedor {

    @Id
    private String ruc;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String observaciones;
    @OneToMany(
            mappedBy = "proveedor",
            cascade = {CascadeType.ALL}
    )
    private List<CompraCabecera> compraCabeceraList;
    @OneToMany(
            mappedBy = "proveedor",
            cascade = {CascadeType.ALL}
    )
    private List<Producto> productoList;

}
