package com.Soporte.services;

import com.Soporte.models.TicketSoporte;
import com.Soporte.repository.TicketSoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketSoporteService {

    @Autowired
    private TicketSoporteRepository repo;

    public TicketSoporte crearTicket(TicketSoporte ticket) {
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setEstado("abierto");
        return repo.save(ticket);
    }

    public List<TicketSoporte> listarTicketsPorCliente(Long clienteId) {
        return repo.findByClienteId(clienteId);
    }

    public TicketSoporte actualizarEstado(Long id, String nuevoEstado) {
        TicketSoporte t = repo.findById(id).orElseThrow();
        t.setEstado(nuevoEstado);
        return repo.save(t);
    }
}
