package com.Fernandez.spaghetti.controller;

import com.Fernandez.spaghetti.service.RegistroService;
import com.Fernandez.spaghetti.service.EstudianteService;
import com.Fernandez.spaghetti.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/registros")
    public String listar(Model model) {
        model.addAttribute("registros", registroService.listar());
        return "registros/list";
    }

    @GetMapping("/registros/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("estudiantes", estudianteService.listar());
        model.addAttribute("asignaturas", asignaturaService.listar());
        return "registros/form";
    }

    @PostMapping("/registros")
    public String crear(@RequestParam int estudianteId,
                        @RequestParam int asignaturaId,
                        Model model) {

        try {
            registroService.crear(estudianteId, asignaturaId);
            return "redirect:/registros";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("estudiantes", estudianteService.listar());
            model.addAttribute("asignaturas", asignaturaService.listar());
            return "registros/form";
        }
    }

    @GetMapping("/registros/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        registroService.eliminar(id);
        return "redirect:/registros";
    }
}