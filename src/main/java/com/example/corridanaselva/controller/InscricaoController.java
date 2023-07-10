package com.example.corridanaselva.controller;
import com.example.corridanaselva.entity.Inscricao;
import com.example.corridanaselva.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/inscricao")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;
    @PostMapping("/salvar")
    public ResponseEntity<Inscricao> salvarInscricao(@RequestBody Inscricao inscricao) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.salvaInscricao(inscricao));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Inscricao> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.inscricaoPorId(id));
    }
    @GetMapping("/todasInscricoes")
    public ResponseEntity<List<Inscricao>> listaInscricao(){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.inscricaoList());
    }
}
