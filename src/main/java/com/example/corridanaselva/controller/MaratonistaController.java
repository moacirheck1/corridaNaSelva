package com.example.corridanaselva.controller;
import com.example.corridanaselva.entity.Maratonista;
import com.example.corridanaselva.service.MaratonistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/maratonista")
public class MaratonistaController {
    @Autowired
    private MaratonistaService maratonistaService;
    @PostMapping("/salvar")
    public ResponseEntity<Maratonista> salvarMaratonista(@RequestBody Maratonista maratonista){
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonistaService.salvarMaratonista(maratonista));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Maratonista> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonistaService.maratonistaPorId(id));
    }
    @GetMapping("/todosMaratonistas")
    public ResponseEntity<List<Maratonista>> listaMaratonista(){
        return ResponseEntity.status(HttpStatus.CREATED).body(maratonistaService.maratonistaList());
    }
}
