package info.microdev.payroll.controller;

import info.microdev.payroll.model.Cliente;
import info.microdev.payroll.repository.ClienteRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/clientes")
    public List<Cliente> all(){
        return clienteRepository.findAll();
    }

    @PostMapping("/clientes")
    public Cliente newCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //TODO: Add a throwable exception
    @GetMapping("/clientes/{id}")
    public Cliente one(@PathVariable String id){
        return clienteRepository.findById(id).orElseThrow(() -> new ExpressionException("Error!"));
    }

    @PutMapping("/clientes/{id}")
    public Cliente replaceEmployee(@RequestBody Cliente newCliente, @PathVariable String id){
        return clienteRepository.findById(id)
                .map(cliente ->{
                    cliente.setDireccion(newCliente.getDireccion());
                    cliente.setEmail(newCliente.getEmail());
                    cliente.setNombre(newCliente.getNombre());
                    cliente.setTelefono(newCliente.getTelefono());
                    return clienteRepository.save(cliente);
                }).orElseGet(()->{
                    newCliente.setCedula(id);
                    return clienteRepository.save(newCliente);
                });
    }

    @DeleteMapping("/clientes/{id}")
    public void deleteCliente(@PathVariable String id){
        clienteRepository.deleteById(id);
    }

}
