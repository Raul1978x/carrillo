package com.carrillo.RecursosPropios.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Raúl Gómez
 */
@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numOrden;
    private String nombre;
    private String apellido;
    private Integer cantidad;
    private String codigo;
    private String precio;
    
}
