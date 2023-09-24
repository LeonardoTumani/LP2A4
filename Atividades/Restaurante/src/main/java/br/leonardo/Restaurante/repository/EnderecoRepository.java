package br.leonardo.Restaurante.repository;

import br.leonardo.Restaurante.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
