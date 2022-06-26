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
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get all existing User",
            notes = "No need input parameters",
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

    @ApiOperation(value = "Get Existing User by Id",
            notes = "User id is needed as input parameters",
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

    @ApiOperation(value = "Create a new User",
            notes = "User parameters are needed to create a new User",
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

   @ApiOperation(value = "Is updated an existing Usuario",
            notes = "We need the id of the Usuario and the new values",
            response = User.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "The request has succeeded")})
    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }



@ApiOperation(value = "Delete a user from the system",
        notes = "User id is needed as input parameters",
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
    @ApiOperation(value = "Show a especific user by id",
            notes = "User id is needed as input parameters",
            response = String.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "The request has succeeded")})
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
