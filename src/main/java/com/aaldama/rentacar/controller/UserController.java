package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.model.User;
import com.aaldama.rentacar.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Obtener todos los Usuario existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @ApiOperation(value = "Obtener Usuario existente por Id",
            notes = "Se necesita el id del Usuario como parametros de entrada",
            response = User.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @ApiOperation(value = "Crea un nuevo Usuario",
            notes = "Se necesitan los parametros del Usuario",
            response = User.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @ApiOperation(value = "Actualiza una Usuario existente en el sistema",
            notes = "Se necesitan los parametros del Usuario",
            response = User.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @ApiOperation(value = "Elimina un Usuario del sistema",
            notes = "Se necesita el id del Usuario como parametros de entrada",
            response = String.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
         userService.deleteById(id);
    }
}
