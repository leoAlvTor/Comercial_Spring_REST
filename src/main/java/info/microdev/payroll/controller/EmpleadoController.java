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

    @GetMapping("/empleados")
    public List<Empleado> all(){
        return empleadoRepository.findAll();
    }

    @PostMapping("/empleados")
    public Empleado newEmpleado(@RequestBody Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    // TODO: Add a throwable exception
    @GetMapping("/empleados/{id}")
    public Empleado one(@PathVariable String id){
        return empleadoRepository.findById(id).orElseThrow(()-> new ExpressionException("Not found!"));
    }

    @PutMapping("/empleados/{id}")
    public Empleado replaceEmpleado(@RequestBody Empleado newEmpleado, @PathVariable String id){
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setPassword(newEmpleado.getPassword());
                    empleado.setNombre(newEmpleado.getNombre());
                    empleado.setTitulo(newEmpleado.getTitulo());
                    empleado.setTelefono(newEmpleado.getTelefono());
                    empleado.setDireccion(newEmpleado.getDireccion());
                    empleado.setMaquinaAsignada(newEmpleado.getMaquinaAsignada());
                    empleado.setIndexActual(newEmpleado.getIndexActual());
                    empleado.setRangoInicial(newEmpleado.getRangoInicial());
                    empleado.setRangoFinal(newEmpleado.getRangoFinal());
                    return empleadoRepository.save(empleado);
                })
                .orElseGet(Empleado::new);
    }

    @DeleteMapping("/empleados/{id}")
    public void replaceEmpleado(@PathVariable String id){
        empleadoRepository.deleteById(id);
    }

}
