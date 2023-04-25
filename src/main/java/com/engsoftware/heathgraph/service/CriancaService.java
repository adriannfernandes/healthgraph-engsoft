package com.engsoftware.heathgraph.service;

import com.engsoftware.heathgraph.entities.Crianca;
import com.engsoftware.heathgraph.repository.CriancaRepository;
import com.engsoftware.heathgraph.service.exceptions.ObjectNotFoundException;
import com.engsoftware.heathgraph.service.exceptions.ObjectAlreadyExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CriancaService {

    @Autowired
    private CriancaRepository criancaRepository;

    public List<Crianca> findAll() {
        return criancaRepository.findAll();
    }

    public Crianca findById(Long id) {
        Optional<Crianca> criancaOptional = criancaRepository.findById(id);

        return criancaOptional.orElseThrow(() -> new ObjectNotFoundException(
                "Criança não encontrada. Id: " + id + ", Tipo: " + Crianca.class.getName()));
    }

    public void create(Crianca crianca){
        if (criancaPeloCpf(crianca.getCpf()) != null) {
            throw new ObjectAlreadyExistException("Criança já cadastrada. Cpf: " + crianca.getCpf() + ", Tipo: "
                    + Crianca.class.getName());
        }

        criancaRepository.save(crianca);
    }

    public void delete(Long id){
        criancaRepository.deleteById(id);
    }
    public void update(Long id, Crianca crianca){
        Crianca criancaCadastrada = findById(id);

        criancaCadastrada.setNome(crianca.getNome());
        criancaCadastrada.setCpf(crianca.getCpf());
        criancaCadastrada.setIdade(crianca.getIdade());
        criancaCadastrada.setSexo(crianca.getSexo());
        criancaCadastrada.setRegistros(crianca.getRegistros());

        criancaRepository.save(crianca);
    }

    private Crianca criancaPeloCpf(String cpf) {
        Optional<Crianca> clienteOptional = criancaRepository.findByCpf(cpf);

        return clienteOptional.orElse(null);
    }


}
