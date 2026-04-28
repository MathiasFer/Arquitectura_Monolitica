package com.Fernandez.spaghetti.repository;

import com.Fernandez.spaghetti.model.Registro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegistroRepository {

    private List<Registro> registros = new ArrayList<>();
    private int idCounter = 1;

    public List<Registro> findAll() {
        return registros;
    }

    public Registro findById(int id) {
        for (Registro r : registros) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public Registro save(Registro registro) {
        registro.setId(idCounter++);
        registros.add(registro);
        return registro;
    }

    public void delete(int id) {
        registros.removeIf(r -> r.getId() == id);
    }

    public boolean exists(int estudianteId, int asignaturaId) {
        for (Registro r : registros) {
            if (r.getEstudianteId() == estudianteId &&
                    r.getAsignaturaId() == asignaturaId) {
                return true;
            }
        }
        return false;
    }
}