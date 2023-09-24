package br.leonardo.Restaurante.model;

import br.leonardo.Restaurante.dto.FuncionarioRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "funcionarios")
@Entity(name = "funcionarios")

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cpf;

    public Funcionario(FuncionarioRequestDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
    }
}
