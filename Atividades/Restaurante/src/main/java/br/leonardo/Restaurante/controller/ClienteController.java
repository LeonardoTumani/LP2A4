package br.leonardo.Restaurante.controller;

import br.leonardo.Restaurante.dto.ClienteRequestDTO;
import br.leonardo.Restaurante.dto.ClienteResponseDTO;
import br.leonardo.Restaurante.model.Cliente;
import br.leonardo.Restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteResponseDTO> getAll(){
        return clienteRepository.findAll().stream().map(ClienteResponseDTO::new).toList();
    }

    @PostMapping
    public void postCliente(@RequestBody ClienteRequestDTO data){
        clienteRepository.save(new Cliente(data));
    }

    @PutMapping
    public void putCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO data) {
        Cliente c = new Cliente(data);
        c.setId(id);
        clienteRepository.save(c);
    }

    @DeleteMapping("{id}")
    public void deleteCliente(@PathVariable Long id) { clienteRepository.deleteById(id);}
}
