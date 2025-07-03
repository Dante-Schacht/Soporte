package com.Soporte.assembler;

import com.Soporte.controllers.TicketSoporteController;
import com.Soporte.models.TicketSoporte;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class TicketSoporteAssembler implements RepresentationModelAssembler<TicketSoporte, EntityModel<TicketSoporte>> {

    @Override
    public EntityModel<TicketSoporte> toModel(TicketSoporte ticket) {
        return EntityModel.of(ticket,
                linkTo(methodOn(TicketSoporteController.class).listarPorCliente(ticket.getClienteId())).withRel("tickets-del-cliente"),
                linkTo(methodOn(TicketSoporteController.class).actualizarEstado(ticket.getId(), ticket.getEstado())).withRel("actualizar-estado")
        );
    }
}
