package br.leonardo.Restaurante.dto;

import java.util.List;

public record PedidoRequestDTO(String title, Long cliente, List<Long> pratos) {
}
