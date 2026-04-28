package com.Fernandez.spaghetti.service;

import com.Fernandez.spaghetti.model.Registro;
import com.Fernandez.spaghetti.repository.RegistroRepository;
import com.Fernandez.spaghetti.repository.EstudianteRepository;
import com.Fernandez.spaghetti.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Registro> listar() {
        return registroRepository.findAll();
    }

    public Registro crear(int estudianteId, int asignaturaId) {

        // validar que estudiante exista
        if (estudianteRepository.findById(estudianteId) == null) {
            throw new RuntimeException("El estudiante no existe");
        }

        // validar que asignatura exista
        if (asignaturaRepository.findById(asignaturaId) == null) {
            throw new RuntimeException("La asignatura no existe");
        }

        // evitar duplicados
        if (registroRepository.exists(estudianteId, asignaturaId)) {
            throw new RuntimeException("El registro ya existe");
        }

        Registro r = new Registro();
        r.setEstudianteId(estudianteId);
        r.setAsignaturaId(asignaturaId);

        return registroRepository.save(r);
    }

    public void eliminar(int id) {
        if (registroRepository.findById(id) == null) {
            throw new RuntimeException("Registro no encontrado");
        }
        registroRepository.delete(id);
    }
}