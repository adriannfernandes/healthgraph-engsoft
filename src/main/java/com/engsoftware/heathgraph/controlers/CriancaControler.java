package com.engsoftware.heathgraph.controlers;

import com.engsoftware.heathgraph.entities.Crianca;
import com.engsoftware.heathgraph.repository.CriancaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/crianca")
@RequiredArgsConstructor
public class CriancaControler {

    private final CriancaRepository criancaRepository;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Crianca>> listAll(){
        return ResponseEntity.ok(criancaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Crianca> save(@RequestBody @Valid Crianca c){
        return new ResponseEntity<>(criancaRepository.save(c), HttpStatus.CREATED);
    }
}
