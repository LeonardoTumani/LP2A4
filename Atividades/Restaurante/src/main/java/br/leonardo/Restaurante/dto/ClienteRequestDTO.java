package br.leonardo.Restaurante.dto;

import br.leonardo.Restaurante.model.Endereco;

public record ClienteRequestDTO(String nome, Endereco endereco) {
}
