package com.example.corridanaselva.controller;
import com.example.corridanaselva.entity.Maratona;
import com.example.corridanaselva.service.MaratonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/maratona")
public class MaratonaController {
    @Autowired
    private MaratonaService maratonaService;
    @PostMapping("/salvar")
    public ResponseEntity<Maratona> salvarMaratona(@RequestBody Maratona maratona){
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonaService.salvarMaratona(maratona));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Maratona> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonaService.maratonaPorId(id));
    }
    @GetMapping("/todasMaratonas")
    public ResponseEntity<List<Maratona>> listaMaratona(){
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonaService.maratonaList());
    }
}
