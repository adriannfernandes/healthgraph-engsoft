//package com.engsoftware.entities;
//
//import javax.persistence.*;
//import java.util.Collection;
//@Entity
//public class Responsavel {
//    @Id
//    @GeneratedValue
//    private Long id;
//    @Column(name = "nome", nullable = false)
//    private String nome;
//    @Column(name = "idade", nullable = false)
//    private int idade;
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private TipoVinculo tipoVinculo;
//    @Column(name = "cpf", nullable = false, unique = true)
//    private String cpf;
//    @ManyToMany(mappedBy = "responsaveis")
//    private Collection<Crianca> criancas;
//
//}
