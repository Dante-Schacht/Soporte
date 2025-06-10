package com.Soporte.repository;

import com.Soporte.models.TicketSoporte;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketSoporteRepository extends JpaRepository<TicketSoporte, Long> {
    List<TicketSoporte> findByClienteId(Long clienteId);
}