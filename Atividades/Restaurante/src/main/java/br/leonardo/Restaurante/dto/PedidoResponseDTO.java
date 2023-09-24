package br.leonardo.Restaurante.dto;

import br.leonardo.Restaurante.model.Cliente;
import br.leonardo.Restaurante.model.Pedido;

import java.util.List;

public record PedidoResponseDTO(Long id, String title, ClienteResponseDTO cliente, List<PratoResponseDTO> pratos) {
    public PedidoResponseDTO(Pedido pedido){
        this(pedido.getId(), pedido.getTitle(), new ClienteResponseDTO(pedido.getCliente()), pedido.getPratos().stream().map(PratoResponseDTO::new).toList());
    }
}
