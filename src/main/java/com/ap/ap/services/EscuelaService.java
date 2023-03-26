package com.ap.ap.services;

import com.ap.ap.exception.UserNotFoundException;
import com.ap.ap.models.Escuela;
import com.ap.ap.models.Usuario;
import com.ap.ap.repository.EscuelaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EscuelaService {
    private final EscuelaRepo escuelaRepo;

    @Autowired
    public EscuelaService(EscuelaRepo escuelaRepo) {
        this.escuelaRepo = escuelaRepo;
    }

    public Escuela addEscuela(Escuela escuela){
        return escuelaRepo.save(escuela);
    }

    public Escuela buscarEscuelaPorId(Long id){
        return escuelaRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Escuela no encontrada"));
    }
    public List<Escuela> buscarEscuela(){
        return escuelaRepo.findAll();
    }

    public Escuela editarEscuela(Escuela escuela){
        return escuelaRepo.save(escuela);
    }

    public void borrarEscuela(Long id){
        escuelaRepo.deleteById(id);
    }


}
