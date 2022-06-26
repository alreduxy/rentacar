package com.aaldama.rentacar.controller;

import com.aaldama.rentacar.exception.ModeloNotFoundException;
import com.aaldama.rentacar.model.Location;
import com.aaldama.rentacar.service.LocationService;
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
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @ApiOperation(value = "Get all branches",
            notes = "The answer will be all the places with their name and zip code",
            response = Location.class,
            responseContainer = "Location")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request or bad client response"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "Success response")})
    @GetMapping
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @ApiOperation(value = "Get existing locations by Id",
            notes = "Location id is needed as input parameters",
            response = Location.class,
            responseContainer = "Location")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request or bad client response"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "Success response")})
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()){
            return ResponseEntity.ok(location.get());
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Create a new location",
            notes = "Lease parameters are needed",
            response = Location.class,
            responseContainer = "Location")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request or bad client response"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "Success response")})
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Location location) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(location));
    }
    @ApiOperation(value = "Updated an existing location",
            notes = "Location Id parameters are needed",
            response = Location.class,
            responseContainer = "Location")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request or bad client response"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "Success response")})
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Location location, @PathVariable Integer id) {
        Optional<Location> lo = locationService.findById(id);
        if (lo.isPresent()){
            Location locationDb = lo.get();
            locationDb.setLocationCode(location.getLocationCode());
            locationDb.setLocationName(location.getLocationName());

            return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(locationDb));
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Delete an existing location",
            notes = "Location Id parameters are needed",
            response = String.class,
            responseContainer = "Location")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request or bad client response"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 200, message = "Success response")})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ("id") Integer id) {
        Optional<Location> lo = locationService.findById(id);
        if (lo.isPresent()){
            locationService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
