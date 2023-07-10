package com.example.corridanaselva.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inscricao {
    @Id
    private Long id;
    private double valorInscricao;
    @ManyToOne
    private Circuito circuito;
    @ManyToOne
    private Maratonista maratonista;



}
