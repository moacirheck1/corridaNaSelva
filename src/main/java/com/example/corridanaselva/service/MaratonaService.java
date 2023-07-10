package com.example.corridanaselva.service;

import com.example.corridanaselva.entity.Maratona;
import com.example.corridanaselva.repository.MaratonaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaratonaService {
    @Autowired
    MaratonaRepository maratonaRepository;

    public Maratona salvarMaratona(Maratona maratona) {
        return maratonaRepository.save(maratona);
    }

    public List<Maratona> maratonaList() {
        return maratonaRepository.findAll();
    }

    public Maratona maratonaPorId(Long id) {
        return maratonaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maratona nao encontrada"));
    }

}
