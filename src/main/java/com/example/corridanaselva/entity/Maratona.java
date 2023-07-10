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
@ToString
public class Maratona {
    @Id
    private Long id;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "maratona")
    private List<Circuito> circuitos;
}
