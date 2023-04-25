package com.engsoftware.controlers;

import com.engsoftware.entities.Crianca;
import com.engsoftware.repositories.CriancaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/aaa")
@RequiredArgsConstructor
public class CriancaControler {

    private final CriancaRepository criancaRepository;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Crianca>> listAll() {
        return ResponseEntity.ok(criancaRepository.findAll());
    }
}
