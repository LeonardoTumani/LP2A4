package br.leonardo.Restaurante.dto;

import br.leonardo.Restaurante.model.Cliente;
import br.leonardo.Restaurante.model.Endereco;
import br.leonardo.Restaurante.model.Prato;
import br.leonardo.Restaurante.model.Pedido;

import java.util.List;

public record ClienteResponseDTO(Long id, String nome, Endereco endereco/*, List<PedidoResponseDTO> pedidos*/) {
    public ClienteResponseDTO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEndereco()/*, cliente.getPedidos().stream().map(PedidoResponseDTO::new).toList()*/);
    }
}
