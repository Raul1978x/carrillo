package com.carrillo.RecursosPropios.repositorios;

import com.carrillo.RecursosPropios.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raúl Gómez
 */
@Repository
public interface IPacienteRepositorio extends JpaRepository<Paciente, Long>{

}
