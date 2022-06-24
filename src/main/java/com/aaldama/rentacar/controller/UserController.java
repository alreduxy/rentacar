package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.dto.UserDTO;
import com.aaldama.rentacar.exception.ModeloNotFoundException;
import com.aaldama.rentacar.model.User;
import com.aaldama.rentacar.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Obtener todos los Usuario existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "BAD REQUEST"),
            @ApiResponse(code = 401, message = "UNAUTHORIZED"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "The request has succeeded")})
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @ApiOperation(value = "Obtener Usuario existente por Id",
            notes = "Se necesita el id del Usuario como parametros de entrada",
            response = User.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "BAD REQUEST"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "The request has succeeded")})

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable("id") Integer id) {
        Optional<User> user = Optional.ofNullable(userService.findById(id));
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();

    }

    @ApiOperation(value = "Crea un nuevo Usuario",
            notes = "Se necesitan los parametros del Usuario",
            response = User.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 409, message = "Conflict, the email already exists"),
            @ApiResponse(code = 200, message = "Successful operation")})
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        Optional<User> dbUser = userService.findByEmail(user.getEmail());
        if (dbUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(dbUser.get());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

   @ApiOperation(value = "Actualiza una Usuario existente en el sistema",
            notes = "Se necesitan los parametros del Usuario",
            response = User.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "BAD REQUEST"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "The request has succeeded")})
    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }



@ApiOperation(value = "Elimina un usuario del sistema",
        notes = "Se necesita el id del Usuario como parametros de entrada",
        response = String.class,
        responseContainer = "Usuario")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 200, message = "The request has succeeded")})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ("id") Integer id){
        Optional<User> u = Optional.ofNullable(userService.findById(id));
        if(u.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/resume/{id}")
    public ResponseEntity<List<UserDTO>> listUserByUserId(@PathVariable("id") int idUser) {
        Optional<User> us = Optional.ofNullable(userService.findById(idUser));
        if (us.isPresent()) {
            List<UserDTO> users = userService.listUserByUserId(idUser);
            return ResponseEntity.ok(userService.listUserByUserId(idUser));
        }
        return ResponseEntity.notFound().build();

    }
}
