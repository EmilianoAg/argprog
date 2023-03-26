package com.ap.ap.controller;

import com.ap.ap.exception.UserNotFoundException;
import com.ap.ap.models.Usuario;
import com.ap.ap.repository.UsuarioRepo;
import com.ap.ap.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200/")

public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;
    private final UsuarioRepo usuarioRepo;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepo usuarioRepo) {
        this.usuarioService = usuarioService;
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id")Long id){
        Usuario usuario=usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    Usuario updateUser(@RequestBody Usuario newUser,@PathVariable Long id){
        return usuarioRepo.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setCiudad(newUser.getCiudad());
                    user.setPais(newUser.getPais());
                    user.setTitulo(newUser.getTitulo());
                    return usuarioRepo.save(user);
                }).orElseThrow(()->new UserNotFoundException("id"));

    }

    @PostMapping("/update")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        Usuario updateUsuario=usuarioService.editarUsuario(usuario);
        return new ResponseEntity<>(updateUsuario,HttpStatus.OK);
    }
}
