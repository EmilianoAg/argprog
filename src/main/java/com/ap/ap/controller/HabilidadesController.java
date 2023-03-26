package com.ap.ap.controller;

import com.ap.ap.exception.UserNotFoundException;
import com.ap.ap.models.Escuela;
import com.ap.ap.models.Usuario;
import com.ap.ap.models.habilidades;
import com.ap.ap.repository.HabilidadesRepo;
import com.ap.ap.services.habilidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
@CrossOrigin(origins = "http://localhost:4200/")
public class HabilidadesController {
    @Autowired
    private final habilidadesService habilidadService;
    private final HabilidadesRepo habilidadesRepo;

    public HabilidadesController(habilidadesService habilidadService, HabilidadesRepo habilidadesRepo) {
        this.habilidadService = habilidadService;
        this.habilidadesRepo = habilidadesRepo;
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<habilidades> verHabilidad () {
        return habilidadService.buscarHabilidades();
    }

    @PutMapping("edit/{id}")
    habilidades updateHabilidades(@RequestBody habilidades habili, @PathVariable Long id) {
        return habilidadesRepo.findById(id)
                .map(habi -> {
                    habi.setName(habili.getName());
                    habi.setStars(habili.getStars());;
                    return habilidadesRepo.save(habi);
                }).orElseThrow(() -> new UserNotFoundException("id"));

    }

    @PutMapping("/update")
    public ResponseEntity<habilidades> editarHabilidades(@RequestBody habilidades habili){
        habilidades updateHabilidades=habilidadService.editarHabilidades(habili);
        return new ResponseEntity<>(updateHabilidades, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<habilidades> añadirHabilidades(@RequestBody habilidades habili){
        habilidades addHabilidades=habilidadService.addHabilidades(habili);
        return new ResponseEntity<>(addHabilidades, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<habilidades> deleteHabilidad(@PathVariable("id") Long id){
        habilidadService.borrarHabilidades(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("id/{id}")
    public ResponseEntity<habilidades> obtenerHabilidad(@PathVariable("id")Long id){
        habilidades habilidad=habilidadService.buscarHabilidadPorId(id);
        return new ResponseEntity<>(habilidad, HttpStatus.OK);
    }
}
