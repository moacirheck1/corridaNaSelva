package com.example.corridanaselva.service;

import com.example.corridanaselva.entity.Circuito;
import com.example.corridanaselva.entity.Enum.Categoria;
import com.example.corridanaselva.repository.CircuitoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitoService {
    @Autowired
    private CircuitoRepository circuitoRepository;


    public Circuito salvarCircuito(Circuito circuito) {
        defineDistancia(circuito);
        return circuitoRepository.save(circuito);
    }

    public List<Circuito> listaCircuito() {

        return circuitoRepository.findAll();
    }

    public Circuito circuitoPorId(Long id) {
        return circuitoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Circuito nao encontrado"));
    }


    public Circuito defineDistancia(Circuito circuito) {
        if (circuito.getTipoCorrida().equals(Categoria.PEQUENO)) {
            circuito.setDistancia("2km pela selva e riachos");
        } else if (circuito.getTipoCorrida().equals(Categoria.MEDIO)) {
            circuito.setDistancia("5km pela selva,riachos e lama");
        } else if (circuito.getTipoCorrida().equals(Categoria.AVANCADO)) {
            circuito.setDistancia("10km pela selva, riachos, lama e escalada");
        }
        return circuito;
    }
}



