package br.leonardo.Restaurante.dto;

import br.leonardo.Restaurante.model.Funcionario;

public record FuncionarioResponseDTO(Long id, String nome, String cpf) {
    public FuncionarioResponseDTO(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCpf());
    }
}
