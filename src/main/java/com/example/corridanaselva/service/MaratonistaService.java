package com.example.corridanaselva.service;

import com.example.corridanaselva.entity.Maratonista;
import com.example.corridanaselva.repository.MaratonistaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaratonistaService {
    @Autowired
    MaratonistaRepository maratonistaRepository;
public Maratonista salvarMaratonista(Maratonista maratonista){

    return maratonistaRepository.save(maratonista);
}
public List<Maratonista> maratonistaList(){

    return maratonistaRepository.findAll();
}
    public Maratonista maratonistaPorId(Long id) {
        return maratonistaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maratonista nao encontrado"));
    }


}
