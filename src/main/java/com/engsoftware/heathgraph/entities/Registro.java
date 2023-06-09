package com.engsoftware.heathgraph.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @Column(name = "idade",nullable = false)
    private int idade;
    @Temporal(TemporalType.DATE)
    @Column(name = "data",nullable = false)
    private LocalDate data;
    @Column(name = "imc")
    private Double imc;
//    @Column(name = "peso_por_idade")
//    private Double pesoXidade;
//    @Column(name = "altura_por_idade")
//    private Double alturaXidade;
//    @Column(name = "imc_por_idade")
//    private Double imcXidade;
    @ManyToOne
    @JoinColumn(name = "id_crianca")
    @JsonIgnoreProperties({"registros"})
    private Crianca crianca;

    public Registro (Double peso, Double altura, int idade){
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
    }
    
    public Registro(){
    }

    public Long getId() {
        return id;
    }

    public Double getPeso(){
        return peso;
    }

    public void setPeso(Double peso){
        this.peso = peso;
    }

    public Double getAltura(){
        return altura;
    }

    public void setAltura(Double altura){
        this.altura = altura;
    }

    public int getIdade(){
        return idade;
    }

    public void setAltura(int altura) {
        this.idade = idade;
    }

    public LocalDate getData(){
        return data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public Double getImc(){
        return imc;
    }

    public void setImc(Double imc){
        this.imc = imc;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }

}
