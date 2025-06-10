package com.Soporte.controllers;

import com.Soporte.models.TicketSoporte;
import com.Soporte.services.TicketSoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/soporte")
public class TicketSoporteController {

    @Autowired
    private TicketSoporteService service;

    @PostMapping("/crear")
    public TicketSoporte crear(@RequestBody TicketSoporte ticket) {
        return service.crearTicket(ticket);
    }

    @GetMapping("/cliente/{id}")
    public List<TicketSoporte> listarPorCliente(@PathVariable Long id) {
        return service.listarTicketsPorCliente(id);
    }

    @PutMapping("/estado/{id}")
    public TicketSoporte actualizarEstado(@PathVariable Long id, @RequestParam String estado) {
        return service.actualizarEstado(id, estado);
    }
}