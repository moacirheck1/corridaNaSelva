package com.example.corridanaselva.entity;

import com.example.corridanaselva.entity.Enum.Categoria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Circuito {

    @Id
    private Long id;
    private Categoria tipoCorrida;
    private String distancia;

    @JsonIgnore
    @OneToMany(mappedBy = "circuito")
    private List<Inscricao> inscricaoList;
    @ManyToOne()
    private Maratona maratona;
}