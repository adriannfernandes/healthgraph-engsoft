package com.engsoftware.heathgraph.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Registro {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "peso",nullable = false)
    private Double peso;
    @Column(name = "altura",nullable = false)
    private Double altura;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "id_crianca")
    private Crianca crianca;
}
