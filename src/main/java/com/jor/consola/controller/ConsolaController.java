package com.jor.consola.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jor.consola.dto.ConsolaDTO;
import com.jor.consola.exceptions.NoSuchConsolaException;
import com.jor.consola.model.Consola;
import com.jor.consola.service.IConsolaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/consola")
public class ConsolaController {
	
	@Autowired
	private IConsolaService consolaService;

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Consola> add(@Valid @RequestBody ConsolaDTO dto) {
    	Consola consola = new Consola();
    	consola.setFabricante(dto.getFabricante());
    	consola.setPrecio(dto.getPrecio());
    	consola.setModelo(dto.getModelo());
    	Consola consolaPersisted = consolaService.addConsola(consola);
        return new ResponseEntity<Consola>(consolaPersisted, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public List<Consola> getAllConsola() {
        return consolaService.findAllConsola();
    }

    @GetMapping("/{id}")
    public Consola getConsolaById(@PathVariable long id) {
    	Consola consola = null;
    	if (id > 0) {
    		consola = consolaService.findConsolaByID(id);
    	}
    	return consola;
    }

    @DeleteMapping("/delete")
    public void delete() {
    	consolaService.deleteAllData();
    }
    
    @DeleteMapping("/{id}")
    public void deleteConsolaById(@PathVariable long id) {
    	if (id > 0) {
    		consolaService.deleteConsolaByID(id);
    	}
    }
    
    @ExceptionHandler(value = NoSuchConsolaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchElementException(NoSuchConsolaException ex) {
        return new ErrorResponseException(HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
