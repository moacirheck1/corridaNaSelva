package com.example.corridanaselva.controller;

import com.example.corridanaselva.entity.Circuito;
import com.example.corridanaselva.service.CircuitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/circuito")
public class CircuitoController {
    @Autowired
   private CircuitoService circuitoService;
    @PostMapping("/salvar")
    public ResponseEntity<Circuito> salvarCircuito(@RequestBody Circuito circuito){
        return ResponseEntity.status(HttpStatus.CREATED).body(circuitoService.salvarCircuito(circuito));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Circuito> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(circuitoService.circuitoPorId(id));
    }
    @GetMapping("/todosCircuitos")
    public ResponseEntity<List<Circuito>> listaCircuitos(){
        return ResponseEntity.status(HttpStatus.CREATED).body(circuitoService.listaCircuito());
    }

}
