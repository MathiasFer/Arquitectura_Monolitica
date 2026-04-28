package com.Fernandez.spaghetti.controller;

import com.Fernandez.spaghetti.model.Asignatura;
import com.Fernandez.spaghetti.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AsignaturaController {

    @Autowired
    private AsignaturaService service;

    @GetMapping("/asignaturas")
    public String listar(Model model) {
        model.addAttribute("asignaturas", service.listar());
        return "asignaturas/list";
    }

    @GetMapping("/asignaturas/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        return "asignaturas/form";
    }

    @PostMapping("/asignaturas")
    public String crear(@RequestParam String nombre,
                        @RequestParam String codigo,
                        @RequestParam String creditos,
                        @RequestParam String docente,
                        Model model) {

        try {
            service.crear(nombre, codigo, creditos, docente);
            return "redirect:/asignaturas";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "asignaturas/form";
        }
    }

    @GetMapping("/asignaturas/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("asignatura", service.obtenerPorId(id));
        return "asignaturas/form";
    }

    @PostMapping("/asignaturas/actualizar")
    public String actualizar(@RequestParam int id,
                             @RequestParam String nombre,
                             @RequestParam String codigo,
                             @RequestParam String creditos,
                             @RequestParam String docente,
                             Model model) {

        try {
            service.actualizar(id, nombre, codigo, creditos, docente);
            return "redirect:/asignaturas";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "asignaturas/form";
        }
    }

    @GetMapping("/asignaturas/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.eliminar(id);
        return "redirect:/asignaturas";
    }
}