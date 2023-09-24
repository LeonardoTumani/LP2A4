package br.leonardo.Restaurante.dto;

import br.leonardo.Restaurante.model.Endereco;

public record EnderecoResponseDTO(Long id, String rua, String cidade) {
    public EnderecoResponseDTO(Endereco endereco){
        this(endereco.getId(), endereco.getRua(), endereco.getCidade());
    }
}
