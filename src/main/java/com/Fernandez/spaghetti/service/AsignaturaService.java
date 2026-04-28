package com.Fernandez.spaghetti.service;

import com.Fernandez.spaghetti.model.Asignatura;
import com.Fernandez.spaghetti.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository repository;

    public List<Asignatura> listar() {
        return repository.findAll();
    }

    public Asignatura obtenerPorId(int id) {
        Asignatura a = repository.findById(id);
        if (a == null) throw new RuntimeException("Asignatura no encontrada");
        return a;
    }

    public Asignatura crear(String nombre, String codigo, String creditosStr, String docente) {

        if (nombre == null || nombre.trim().length() < 3) {
            throw new RuntimeException("Nombre invalido");
        }

        int creditos;
        try {
            creditos = Integer.parseInt(creditosStr);
        } catch (Exception e) {
            throw new RuntimeException("Creditos deben ser numericos");
        }

        Asignatura a = new Asignatura();
        a.setNombre(nombre);
        a.setCodigo(codigo);
        a.setCreditos(creditos);
        a.setDocente(docente);

        return repository.save(a);
    }

    public void eliminar(int id) {
        if (repository.findById(id) == null) {
            throw new RuntimeException("No existe");
        }
        repository.delete(id);
    }

    public Asignatura actualizar(int id, String nombre, String codigo, String creditosStr, String docente) {

        Asignatura a = repository.findById(id);
        if (a == null) throw new RuntimeException("No encontrada");

        int creditos;
        try {
            creditos = Integer.parseInt(creditosStr);
        } catch (Exception e) {
            throw new RuntimeException("Creditos invalidos");
        }

        a.setNombre(nombre);
        a.setCodigo(codigo);
        a.setCreditos(creditos);
        a.setDocente(docente);

        repository.update(a);

        return a;
    }
}
