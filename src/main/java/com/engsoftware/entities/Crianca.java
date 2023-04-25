package com.engsoftware.entities;


import javax.persistence.*;

@Entity
public class Crianca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
//    @Column(nullable = false)
//    private int idade;
//    @Enumerated(EnumType.STRING)
//    private Sexo sexo;
//    @Column(name = "cpf", nullable = false, unique = true)
//    private String cpf;
//    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
//    @JoinTable(name = "responsavel_crianca",
//            joinColumns=@JoinColumn(name="id_crianca"),
//            inverseJoinColumns = @JoinColumn(name="id_responsavel"))
//    private Collection<Responsavel> responsaveis;
//    @OneToMany(mappedBy = "crianca", fetch = FetchType.EAGER)
//    private Collection<Registro> registros;
}
