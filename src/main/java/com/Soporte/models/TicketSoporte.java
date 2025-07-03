package com.Soporte.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
public class TicketSoporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long clienteId;
    private String asunto;
    private String mensaje;
    private String estado; 
    private LocalDateTime fechaCreacion;
}
