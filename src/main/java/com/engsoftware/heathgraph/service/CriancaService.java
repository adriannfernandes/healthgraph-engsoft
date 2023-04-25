package com.engsoftware.heathgraph.service;

import com.engsoftware.heathgraph.entities.Crianca;
import com.engsoftware.heathgraph.repository.CriancaRepository;
import com.engsoftware.heathgraph.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriancaService {

    @Autowired
    private CriancaRepository criancaRepository;

    public Crianca findById(Long id) {
        Optional<Crianca> criancaOptional = criancaRepository.findById(id);

        return criancaOptional.orElseThrow(() -> new ObjectNotFoundException(
                "Criança não encontrada. Id: " + id + ", Tipo: " + Crianca.class.getName()));
    }
}
