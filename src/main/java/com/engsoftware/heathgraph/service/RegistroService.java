package com.engsoftware.heathgraph.service;

import com.engsoftware.heathgraph.entities.Registro;
import com.engsoftware.heathgraph.repository.RegistroRepository;
import com.engsoftware.heathgraph.service.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

import com.engsoftware.heathgraph.service.exceptions.ObjectAlreadyExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RegistroService {


    private final RegistroRepository registroRepository;



    public List<Registro> findAllRegistros(){
        return registroRepository.findAll();
    }

    public Registro findById(Long id){
        return registroRepository.findById(id).get();
    }

    public Registro saveRegistro(Registro registro){
        Double imc = calculaIMC(registro);
        registro.setImc(imc);


        return registroRepository.save(registro);
    }
//    public Collection<Registro> registrosByIdCrianca(Long idCrianca){
//        return registroRepository.findAllByIdCrianca(idCrianca);
//    }

    public void calculaDados(){
        
        calculaPesoPorIdade();
        calculaAlturaPorIdade();
        calculaImcPorIdade();
    }
    private Double calculaIMC(Registro registro){
        // PESO / ALTURA * ALTURA
        Double imc = registro.getPeso() / (registro.getAltura() * registro.getAltura());
        return imc;
    }

    public void calculaPesoPorIdade(){

    }
    public void calculaAlturaPorIdade(){

    }
    public void calculaImcPorIdade(){

    }
    










}