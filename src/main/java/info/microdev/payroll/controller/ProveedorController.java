package info.microdev.payroll.controller;

import info.microdev.payroll.model.Proveedor;
import info.microdev.payroll.repository.ProveedorRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProveedorController {

    private final ProveedorRepository proveedorRepository;

    public ProveedorController(ProveedorRepository proveedorRepository){
        this.proveedorRepository = proveedorRepository;
    }

    @GetMapping("/proveedores")
    public List<Proveedor> all(){
        return proveedorRepository.findAll();
    }

    @PostMapping("/proveedores")
    public Proveedor newProveedor(@RequestBody Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    @GetMapping("proveedores/{id}")
    public Proveedor one(@PathVariable String id){
        return proveedorRepository.findById(id).orElseThrow(() -> new ExpressionException("Proveedor not found with id: " + id));
    }

    @PutMapping("proveedores/{id}")
    public Proveedor replaceProveedor(@RequestBody Proveedor newProveedor, @PathVariable String id){
        return proveedorRepository.findById(id)
                .map(proveedor -> {
                    proveedor.setNombre(newProveedor.getNombre());
                    proveedor.setDireccion(newProveedor.getDireccion());
                    proveedor.setTelefono(newProveedor.getTelefono());
                    proveedor.setEmail(newProveedor.getEmail());
                    proveedor.setObservaciones(newProveedor.getObservaciones());
                    proveedor.setCompraCabeceraList(null);
                    proveedor.setProductoList(null);
                    return proveedorRepository.save(proveedor);
                }).orElseGet(()->{
                    newProveedor.setRuc(id);
                    return proveedorRepository.save(newProveedor);
                });
    }

    @DeleteMapping("/proveedores/{id}")
    public void deleteProveedor(@PathVariable String id){
        proveedorRepository.deleteById(id);
    }

}
