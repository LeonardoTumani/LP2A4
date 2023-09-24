package br.leonardo.Restaurante.controller;

import br.leonardo.Restaurante.dto.ClienteRequestDTO;
import br.leonardo.Restaurante.dto.ClienteResponseDTO;
import br.leonardo.Restaurante.dto.PedidoRequestDTO;
import br.leonardo.Restaurante.dto.PedidoResponseDTO;
import br.leonardo.Restaurante.model.Cliente;
import br.leonardo.Restaurante.model.Pedido;
import br.leonardo.Restaurante.model.Prato;
import br.leonardo.Restaurante.repository.ClienteRepository;
import br.leonardo.Restaurante.repository.PedidoRepository;
import br.leonardo.Restaurante.repository.PedidoRepository;
import br.leonardo.Restaurante.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PratoRepository pratoRepository;

    @GetMapping
    public List<PedidoResponseDTO> getAll(){
        return pedidoRepository.findAll().stream().map(PedidoResponseDTO::new).toList();
    }

    @PostMapping
    public void savePedido(@RequestBody PedidoRequestDTO data){
        List<Prato> p = new ArrayList<>();
        for (Long id: data.pratos()) {
            p.add(pratoRepository.findById(id).get());
        }
        pedidoRepository.save(new Pedido(data.title(), clienteRepository.findById(data.cliente()).get(), p));
    }

    @PutMapping
    public void postPedido(@PathVariable Long id, @RequestBody String title){
        Pedido p = pedidoRepository.findById(id).get();
        p.setTitle(title);
        pedidoRepository.save(p);
    }

    @DeleteMapping("{id}")
    public void deletePedido(@PathVariable Long id){
        pedidoRepository.deleteById(id);
    }
}
