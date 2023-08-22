package com.example.controller;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

    private UsuarioRepository repository;

    UsuarioController(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }
    // métodos do CRUD aqui
    @GetMapping
    public List findAll(){
        return repository.findAll();
    }
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
   @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }
}