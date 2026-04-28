package com.Fernandez.spaghetti.service;

import com.Fernandez.spaghetti.model.Estudiante;
import com.Fernandez.spaghetti.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public List<Estudiante> listar() {
        return repository.findAll();
    }

    public Estudiante obtenerPorId(int id) {
        Estudiante e = repository.findById(id);
        if (e == null) {
            throw new RuntimeException("Estudiante no encontrado");
        }
        return e;
    }

    public Estudiante crear(String nombre, String direccion, String telefono, String email) {

        if (nombre == null || nombre.trim().length() < 3) {
            throw new RuntimeException("Nombre invalido");
        }

        if (email == null || !email.contains("@")) {
            throw new RuntimeException("Email invalido");
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setDireccion(direccion);
        estudiante.setTelefono(telefono);
        estudiante.setEmail(email);

        return repository.save(estudiante);
    }

    public void eliminar(int id) {
        Estudiante e = repository.findById(id);
        if (e == null) {
            throw new RuntimeException("No se puede eliminar, no existe");
        }
        repository.delete(id);
    }

    public Estudiante actualizar(int id, String nombre, String direccion, String telefono, String email) {

        Estudiante existente = repository.findById(id);

        if (existente == null) {
            throw new RuntimeException("Estudiante no encontrado");
        }

        if (nombre == null || nombre.trim().length() < 3) {
            throw new RuntimeException("Nombre invalido");
        }

        existente.setNombre(nombre);
        existente.setDireccion(direccion);
        existente.setTelefono(telefono);
        existente.setEmail(email);

        repository.update(existente);

        return existente;
    }
}