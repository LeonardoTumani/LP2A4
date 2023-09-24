package br.leonardo.Restaurante.repository;

import br.leonardo.Restaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
