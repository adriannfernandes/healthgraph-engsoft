//package com.engsoftware.entities;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.Calendar;
//@Entity
//public class Registro {
//    @Id
//    @GeneratedValue
//    private Long id;
//    @Column(name = "peso",nullable = false)
//    private Double peso;
//    @Column(name = "altura",nullable = false)
//    private Double altura;
//    @Temporal(TemporalType.DATE)
//    @Column(nullable = false)
//    private LocalDate data;
//    @ManyToOne
//    @JoinColumn(name = "id_crianca")
//    private Crianca crianca;
//}
