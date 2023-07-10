package com.example.corridanaselva.service;

import com.example.corridanaselva.entity.Circuito;
import com.example.corridanaselva.entity.Enum.Categoria;
import com.example.corridanaselva.entity.Inscricao;
import com.example.corridanaselva.entity.Maratonista;
import com.example.corridanaselva.repository.CircuitoRepository;
import com.example.corridanaselva.repository.InscricaoRepository;
import com.example.corridanaselva.repository.MaratonistaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {
    @Autowired
    InscricaoRepository inscricaoRepository;
    @Autowired
    CircuitoRepository circuitoRepository;
    @Autowired
    MaratonistaRepository maratonistaRepository;



    public Inscricao salvaInscricao(Inscricao inscricao) throws Exception {
        Maratonista maratonista = maratonistaRepository.findById(inscricao.getMaratonista().getId())
                .orElseThrow(() -> new EntityNotFoundException("Maratonista não encontrado"));

        // Verifica se o maratonista foi encontrado antes de prosseguir
        if (maratonista == null) {
            throw new EntityNotFoundException("Maratonista não encontrado");
        }

        inscricao.setMaratonista(maratonista);

        Circuito circuito = circuitoRepository.findById(inscricao.getCircuito().getId())
                .orElseThrow(() -> new EntityNotFoundException("Circuito não encontrado"));

        // Verifica se o circuito foi encontrado antes de prosseguir
        if (circuito == null) {
            throw new EntityNotFoundException("Circuito não encontrado");
        }

        inscricao.setCircuito(circuito);

        inscrever(inscricao);

        return inscricaoRepository.save(inscricao);
    }


    public Inscricao inscrever(Inscricao inscricao) throws Exception {
       boolean idade = verificaIdade(inscricao.getMaratonista());

        if (inscricao.getCircuito().getTipoCorrida().equals(Categoria.PEQUENO)) {
            if (idade) {
                inscricao.setValorInscricao(1500);
            } else
                inscricao.setValorInscricao(1300);
        } else if (inscricao.getCircuito().getTipoCorrida().equals(Categoria.MEDIO)) {
            if (idade) {
                inscricao.setValorInscricao(2300);
            } else
                inscricao.setValorInscricao(2000);
        } else if (inscricao.getCircuito().getTipoCorrida().equals(Categoria.AVANCADO)) {
            if (idade) {
                inscricao.setValorInscricao(2800);
            } else {
                throw new Exception("Não é possível realizar a operação");
            }
        } else {
            throw new IllegalArgumentException("Categoria de circuito inválida");
        }
        return null;
    }


    public List<Inscricao> inscricaoList() {
        return inscricaoRepository.findAll();
    }

    public Inscricao inscricaoPorId(long id) {
        return inscricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Inscrição não encontrada"));
    }


    public boolean verificaIdade(Maratonista maratonista) {
        if (maratonista != null) {
            int idade = maratonista.getIdade();
            if (idade >= 18) {
               return true;
            }
        }
      return false;
    }

}
