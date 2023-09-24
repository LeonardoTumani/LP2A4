package br.leonardo.Restaurante.model;

import br.leonardo.Restaurante.dto.EnderecoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enderecos")
@Entity(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String rua;
    @Column
    private String cidade;

    public Endereco(EnderecoRequestDTO enderecoRequestDTO) {
        this.rua = enderecoRequestDTO.rua();
        this.cidade = enderecoRequestDTO.cidade();
    }
}
