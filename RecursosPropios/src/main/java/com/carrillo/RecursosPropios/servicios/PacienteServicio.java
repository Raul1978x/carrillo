package com.carrillo.RecursosPropios.servicios;

import com.carrillo.RecursosPropios.entidades.Paciente;
import com.carrillo.RecursosPropios.excepciones.MiExcepcion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.carrillo.RecursosPropios.repositorios.IPacienteRepositorio;
import java.util.Optional;

/**
 *
 * @author Raúl Gómez
 */
@Service
public class PacienteServicio {

    @Autowired
    private IPacienteRepositorio pacienteRepositorio;

    @Transactional
    public void crearPaciente(Integer numOrden, String nombre, String apellido, Integer cantidad, String codigo, String precio) throws MiExcepcion {
        validar(numOrden, nombre, apellido, cantidad, codigo, precio);
        Paciente paciente = new Paciente();
        paciente.setNumOrden(numOrden);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setCantidad(cantidad);
        paciente.setCodigo(codigo);
        paciente.setPrecio(precio);

        pacienteRepositorio.save(paciente);
    }

    @Transactional
    public void modificarPaciente(Long id, Integer numOrden, String nombre, String apellido, Integer cantidad, String codigo, String precio) throws MiExcepcion {
        validar(numOrden, nombre, apellido, cantidad, codigo, precio);
        Optional<Paciente> respuesta = pacienteRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Paciente paciente = respuesta.get();
            paciente.setNumOrden(numOrden);
            paciente.setNombre(nombre);
            paciente.setApellido(apellido);
            paciente.setCantidad(cantidad);
            paciente.setCodigo(codigo);
            paciente.setPrecio(precio);
            pacienteRepositorio.save(paciente);
        }
    }

    @Transactional(readOnly = true)
    public List<Paciente> listaPacientes() {
        return pacienteRepositorio.findAll();
    }

    @Transactional
    public Paciente buscarPorId(Long id) {
        Optional<Paciente> paciente = pacienteRepositorio.findById(id);
        return paciente.get();
    }
    
    @Transactional
    public void eliminarPorId(Long id){
        pacienteRepositorio.deleteById(id);
    }

    public void validar(Integer numOrden, String nombre, String apellido, Integer cantidad, String codigo, String precio) throws MiExcepcion {
        if (numOrden == null) {
            throw new MiExcepcion("El número de orden no puede estar vacio");
        }
        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("El nombre no puede ser nulo o estar vacio");
        }
        if (apellido.isEmpty() || apellido == null) {
            throw new MiExcepcion("El apellido no puede ser nulo o estar vacio");
        }
        if (cantidad == null) {
            throw new MiExcepcion("La cantidad no puede estar vacio");
        }
        if (codigo.isEmpty() || codigo == null) {
            throw new MiExcepcion("El codigo no puede ser nulo o estar vacio");
        }
        if (precio.isEmpty() || precio == null) {
            throw new MiExcepcion("El precio del código no puede ser nulo o estar vacio");
        }
    }
}
