package com.Fernandez.spaghetti.repository;

import com.Fernandez.spaghetti.model.Asignatura;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AsignaturaRepository {

    private List<Asignatura> asignaturas = new ArrayList<>();
    private int idCounter = 1;

    public List<Asignatura> findAll() {
        return asignaturas;
    }

    public Asignatura findById(int id) {
        for (Asignatura a : asignaturas) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public Asignatura save(Asignatura a) {
        a.setId(idCounter++);
        asignaturas.add(a);
        return a;
    }

    public void delete(int id) {
        asignaturas.removeIf(a -> a.getId() == id);
    }

    public void update(Asignatura a) {
        for (Asignatura x : asignaturas) {
            if (x.getId() == a.getId()) {
                x.setNombre(a.getNombre());
                x.setCodigo(a.getCodigo());
                x.setCreditos(a.getCreditos());
                x.setDocente(a.getDocente());
            }
        }
    }
}