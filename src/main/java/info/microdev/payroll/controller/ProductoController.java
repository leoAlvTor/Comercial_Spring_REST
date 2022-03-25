package info.microdev.payroll.controller;

import info.microdev.payroll.model.Producto;
import info.microdev.payroll.repository.ProductoRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @GetMapping("/productos")
    public List<Producto> all(){
        return productoRepository.findAll();
    }

    @PostMapping("/productos")
    public Producto newProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @GetMapping("/productos/{id}")
    public Producto one(@PathVariable String id){
        return productoRepository.findById(id).orElseThrow(() -> new ExpressionException("Error producto not found with id: " + id));
    }

    @PutMapping("/productos/{id}")
    public Producto replaceProducto(@RequestBody Producto newProducto, @PathVariable String id){
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setCodigo(newProducto.getCodigo());
                    producto.setCodigoPrincipal(newProducto.getCodigoPrincipal());
                    producto.setNombre(newProducto.getNombre());
                    producto.setNombrePrincipal(newProducto.getNombrePrincipal());
                    producto.setFecha(newProducto.getFecha());
                    producto.setProveedor(newProducto.getProveedor());
                    producto.setCompraDetalleList(null);
                    producto.setFacturaDetalleList(null);
                    producto.setCategoria(newProducto.getCategoria());
                    producto.setRepresentacion(newProducto.getRepresentacion());
                    producto.setCantidadInterna(newProducto.getCantidadInterna());
                    producto.setStockPaquete(newProducto.getStockPaquete());
                    producto.setStockUnitario(newProducto.getStockUnitario());
                    producto.setPrecioCaja(newProducto.getPrecioCaja());
                    producto.setPrecioUnitario(newProducto.getPrecioUnitario());
                    producto.setImpuesto(newProducto.getImpuesto());
                    producto.setPrecioCaja12(newProducto.getPrecioCaja12());
                    producto.setPrecioUnitario12(newProducto.getPrecioUnitario12());
                    producto.setPrecioVentaCaja(newProducto.getPrecioVentaCaja());
                    producto.setPrecioVentaUnidad(newProducto.getPrecioVentaUnidad());
                    return productoRepository.save(producto);
                }).orElseGet(Producto::new);
    }

    @DeleteMapping("/productos/{id}")
    public void deleteProducto(@PathVariable String id){
        productoRepository.deleteById(id);
    }

}
