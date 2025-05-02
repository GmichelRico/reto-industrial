package com.gmichel.usuarios.controllers;

import com.gmichel.usuarios.dto.ResponseDto;
import com.gmichel.usuarios.models.entities.User;
import com.gmichel.usuarios.services.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
* Controlador RESt para exponer los endpoints
*
* */
// Indicamos que es un RestControler
@RestController
// Mapeamos la Url
@RequestMapping("/api/v1/user")
// Anotacion de argumentos para el constructor con Lombok
@RequiredArgsConstructor

public class UserController {
    // Inyectamos por constructor la capa del servicio
    private final UserServiceImpl service;


    @GetMapping
    public ResponseEntity<List<User>>getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("byEmail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(service.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User userDB){
        return ResponseEntity.ok().body(service.save(userDB));
    }

    @PutMapping("byId/{id}")
    public ResponseEntity<User> update(@RequestBody User userDB, @PathVariable Long id){
        return ResponseEntity.ok().body(service.update(userDB, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(service.deleteById(id));
    }

}
