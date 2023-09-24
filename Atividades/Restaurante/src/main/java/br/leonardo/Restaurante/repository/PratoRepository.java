package br.leonardo.Restaurante.repository;

import br.leonardo.Restaurante.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PratoRepository extends JpaRepository<Prato, Long > {
}
