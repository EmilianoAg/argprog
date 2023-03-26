package com.ap.ap.services;

import com.ap.ap.exception.UserNotFoundException;
import com.ap.ap.models.Usuario;
import com.ap.ap.models.cursos;
import com.ap.ap.repository.CursosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class cursosService {
    private final CursosRepo cursosRepo;

    @Autowired
    public cursosService(CursosRepo cursosRepo) {
        this.cursosRepo = cursosRepo;
    }

    public cursos addCurso(cursos cursos) {
        return cursosRepo.save(cursos);
    }

    public List<cursos> buscarCursos() {
        return cursosRepo.findAll();
    }

    public cursos editarCursos(cursos cursos) {
        return cursosRepo.save(cursos);
    }

    public void borrarCursos(Long id) {
        cursosRepo.deleteById(id);
    }

    public cursos buscarCursoPorId(Long id) {
        return cursosRepo.findById(id).orElseThrow (() ->new UserNotFoundException("Curso no encontrado"));
    }
}
