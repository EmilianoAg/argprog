package com.ap.ap.controller;

import com.ap.ap.exception.UserNotFoundException;
import com.ap.ap.models.Escuela;
import com.ap.ap.models.Usuario;
import com.ap.ap.models.cursos;
import com.ap.ap.repository.CursosRepo;
import com.ap.ap.services.cursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "http://localhost:4200/")
public class CursosController {
    @Autowired
    private final cursosService cursoService;
    private final CursosRepo cursosRepo;

    public CursosController(cursosService cursoService, CursosRepo cursosRepo) {
        this.cursoService = cursoService;
        this.cursosRepo = cursosRepo;
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<cursos> verCursos () {
        return cursoService.buscarCursos();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<cursos> obtenerCurso(@PathVariable("id")Long id){
        cursos curso=cursoService.buscarCursoPorId(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    cursos updateCurso(@RequestBody cursos curso, @PathVariable Long id){
        return cursosRepo.findById(id)
                .map(curs -> {
                    curs.setName(curso.getName());
                    curs.setAnio(curso.getAnio());
                    return cursosRepo.save(curs);
                }).orElseThrow(()->new UserNotFoundException("id"));

    }

    @PutMapping("/update")
    public ResponseEntity<cursos> editarCursos(@RequestBody cursos curso){
        cursos updateCursos=cursoService.editarCursos(curso);
        return new ResponseEntity<>(updateCursos,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<cursos> agregarCursos(@RequestBody cursos curso){
        cursos addCursos=cursoService.addCurso(curso);
        return new ResponseEntity<>(addCursos,HttpStatus.OK);
    }

    @DeleteMapping("delete/id")
    public ResponseEntity<cursos> deleteCurso(@PathVariable("id") Long id){
        cursoService.borrarCursos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
