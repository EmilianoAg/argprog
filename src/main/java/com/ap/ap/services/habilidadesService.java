package com.ap.ap.services;

import com.ap.ap.exception.UserNotFoundException;
import com.ap.ap.models.Usuario;
import com.ap.ap.models.habilidades;
import com.ap.ap.repository.HabilidadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class habilidadesService {
    private final HabilidadesRepo habilidadesRepo;

    @Autowired
    public habilidadesService(HabilidadesRepo habilidadesRepo) {
        this.habilidadesRepo = habilidadesRepo;
    }

    public habilidades addHabilidades(habilidades habilidades){
        return habilidadesRepo.save(habilidades);
    }
    public List<habilidades> buscarHabilidades(){
        return habilidadesRepo.findAll();
    }

    public habilidades editarHabilidades(habilidades habilidades){
        return habilidadesRepo.save(habilidades);
    }

    public void borrarHabilidades(Long id){
        habilidadesRepo.deleteById(id);
    }

    public habilidades buscarHabilidadPorId(Long id) {
        return habilidadesRepo.findById(id).orElseThrow (() ->new UserNotFoundException("skill no encontrada"));
    }
}
