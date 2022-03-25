package info.microdev.payroll.controller;

import info.microdev.payroll.model.Empleado;
import info.microdev.payroll.repository.EmpleadoRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    /*
    Authentication method based on username and password
     */

    @PostMapping("/empleados/login")
    public Empleado login(@RequestBody Empleado empleadoBusqueda){
        return empleadoRepository.findByUserAndPassword(empleadoBusqueda.getCedula(), empleadoBusqueda.getPassword()).orElseGet(Empleado::new);
    }

}
