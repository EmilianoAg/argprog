package com.ap.ap.controller;

import com.ap.ap.exception.UserNotFoundException;
import com.ap.ap.models.Escuela;
import com.ap.ap.models.Usuario;
import com.ap.ap.repository.EscuelaRepo;
import com.ap.ap.services.EscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escuela")
@CrossOrigin(origins = "http://localhost:4200/")
public class EscuelaController {

    @Autowired
    private final EscuelaService escuelaService;
    private final EscuelaRepo escuelaRepo;


    public EscuelaController(EscuelaService escuelaService, EscuelaRepo escuelaRepo) {
        this.escuelaService = escuelaService;
        this.escuelaRepo = escuelaRepo;
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Escuela> obtenerEscuela(@PathVariable("id")Long id){
        Escuela escuela=escuelaService.buscarEscuelaPorId(id);
        return new ResponseEntity<>(escuela, HttpStatus.OK);
    }

    @GetMapping("/ver")
    @ResponseBody
        public List<Escuela> verEscuelas () {
            return escuelaService.buscarEscuela();
    }

    @PutMapping("/update")
    public ResponseEntity<Escuela> editarEscuela(@RequestBody Escuela escuela){
        Escuela updateEscuela=escuelaService.editarEscuela(escuela);
        return new ResponseEntity<>(updateEscuela,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Escuela> agregarEscuela(@RequestBody Escuela escuela){
        Escuela addEscuela=escuelaService.addEscuela(escuela);
        return new ResponseEntity<>(addEscuela,HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    Escuela updateEscuela(@RequestBody Escuela escuela,@PathVariable Long id){
        return escuelaRepo.findById(id)
                .map(escu -> {
                    escu.setName(escuela.getName());
                    escu.setTituloEsc(escuela.getTituloEsc());
                    escu.setAnioInicio(escuela.getAnioInicio());
                    escu.setAnioFinal(escuela.getAnioFinal());
                    return escuelaRepo.save(escu);
                }).orElseThrow(()->new UserNotFoundException("id"));

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Escuela> deleteEscuela(@PathVariable("id") Long id){
        escuelaService.borrarEscuela(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
