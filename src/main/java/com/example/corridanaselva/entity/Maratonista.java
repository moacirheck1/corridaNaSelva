package com.example.corridanaselva.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maratonista {
    @Id
    private Long id;
    private String grupoSanguinio;
    private String nome;
    private int idade;
    private String celular;
    private String numeroEmergencia;
    private String rg;
    private String sobrenome;
    @JsonIgnore
    @OneToMany(mappedBy = "maratonista")
    private List<Inscricao> inscricoes;




}
