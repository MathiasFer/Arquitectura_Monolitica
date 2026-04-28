package com.Fernandez.spaghetti.controller;

import com.Fernandez.spaghetti.model.Estudiante;
import com.Fernandez.spaghetti.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/estudiantes")
    public String listar(Model model) {
        model.addAttribute("estudiantes", service.listar());
        return "estudiantes/list";
    }

    @GetMapping("/estudiantes/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiantes/form";
    }

    @PostMapping("/estudiantes")
    public String crear(@ModelAttribute Estudiante estudiante, Model model) {
        try {
            service.crear(
                    estudiante.getNombre(),
                    estudiante.getDireccion(),
                    estudiante.getTelefono(),
                    estudiante.getEmail()
            );
            return "redirect:/estudiantes";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("estudiante", estudiante);
            return "estudiantes/form";
        }
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        try {
            Estudiante e = service.obtenerPorId(id);
            model.addAttribute("estudiante", e);
            return "estudiantes/form";
        } catch (RuntimeException ex) {
            return "redirect:/estudiantes";
        }
    }

    @PostMapping("/estudiantes/actualizar")
    public String actualizar(@ModelAttribute Estudiante estudiante, Model model) {
        try {
            service.actualizar(
                    estudiante.getId(),
                    estudiante.getNombre(),
                    estudiante.getDireccion(),
                    estudiante.getTelefono(),
                    estudiante.getEmail()
            );
            return "redirect:/estudiantes";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("estudiante", estudiante);
            return "estudiantes/form";
        }
    }

    @GetMapping("/estudiantes/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.eliminar(id);
        return "redirect:/estudiantes";
    }
}