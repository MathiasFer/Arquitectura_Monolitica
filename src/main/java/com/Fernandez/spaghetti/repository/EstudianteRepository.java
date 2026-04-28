package com.Fernandez.spaghetti.repository;

import com.Fernandez.spaghetti.model.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EstudianteRepository {

    private List<Estudiante> estudiantes = new ArrayList<>();
    private int idCounter = 1;

    public List<Estudiante> findAll() {
        return estudiantes;
    }

    public Estudiante findById(int id) {
        for (Estudiante e : estudiantes) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public Estudiante save(Estudiante estudiante) {
        estudiante.setId(idCounter++);
        estudiantes.add(estudiante);
        return estudiante;
    }

    public void delete(int id) {
        estudiantes.removeIf(e -> e.getId() == id);
    }

    public void update(Estudiante estudiante) {
        for (Estudiante e : estudiantes) {
            if (e.getId() == estudiante.getId()) {
                e.setNombre(estudiante.getNombre());
                e.setDireccion(estudiante.getDireccion());
                e.setTelefono(estudiante.getTelefono());
                e.setEmail(estudiante.getEmail());
            }
        }
    }
}