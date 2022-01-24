package com.marciotecnologia.tutorial.rest.api.controller;

import com.marciotecnologia.tutorial.rest.api.model.UsuarioModel;
import com.marciotecnologia.tutorial.rest.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(path = "/api/usuario/{code}")
    public ResponseEntity consultar(@PathVariable("code") Integer code){
        return repository.findById(code).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/usuario/salvar")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario){
        return repository.save(usuario);
    }
}
