package com.carrillo.RecursosPropios.controladores;

import com.carrillo.RecursosPropios.entidades.Paciente;
import com.carrillo.RecursosPropios.servicios.PacienteServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Raúl Gómez
 */
@Controller
@RequestMapping("/")
public class PacienteControlador {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/registrar")
    public String registrar(ModelMap model) {
        return "index";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Integer numOrden, @RequestParam String nombre, @RequestParam String apellido, @RequestParam(required = false) Integer cantidad,
            @RequestParam String codigo, @RequestParam(required = true) String precio, ModelMap model) {
        try {
            pacienteServicio.crearPaciente(numOrden, nombre, apellido, cantidad, codigo, precio);
            model.put("exito", "El formulario fue cargado con éxito!!");
        } catch (Exception e) {
            model.put("error", e.getMessage());
        }
        return "redirect:/registrar";
    }

    @GetMapping("/listado")
    public String listaPacientes(ModelMap model) {
        List<Paciente> pacientes = pacienteServicio.listaPacientes();
        model.put("pacientes", pacientes);
        return "listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, ModelMap model) {
        Paciente paciente = pacienteServicio.buscarPorId(id);
        model.put("paciente", paciente);
        return "formulario_editar";
    }

    @PostMapping("/modifica/{id}")
    public String modifica(@PathVariable Long id, @RequestParam(required = false) Integer numOrden, @RequestParam String nombre, @RequestParam String apellido, @RequestParam(required = false) Integer cantidad,
            @RequestParam String codigo, @RequestParam(required = true) String precio, ModelMap model) {
        try {
            pacienteServicio.modificarPaciente(id, numOrden, nombre, apellido, cantidad, codigo, precio);
            model.put("exito", "los datos se actualizaron correctamente!!");
            return "redirect:/listado";
        } catch (Exception e) {
            model.put("error", e.getMessage());
        }
        return "redirect:/modificar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        pacienteServicio.eliminarPorId(id);
        return "redirect:/listado";
    }
}
