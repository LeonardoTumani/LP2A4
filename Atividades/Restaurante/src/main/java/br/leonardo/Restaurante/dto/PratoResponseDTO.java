package br.leonardo.Restaurante.dto;

import br.leonardo.Restaurante.model.Prato;

public record PratoResponseDTO(Long id, String titulo, String descricao, Double preco) {
    public PratoResponseDTO(Prato p){
        this(p.getId(), p.getTitulo(), p.getDescricao(), p.getPreco());
    }
}
