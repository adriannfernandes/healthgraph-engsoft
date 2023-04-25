package com.engsoftware.heathgraph.controlers;

import com.engsoftware.heathgraph.entities.Crianca;
import com.engsoftware.heathgraph.service.CriancaService;
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

    private final CriancaService criancaService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Crianca>> listAll(){
        return ResponseEntity.ok(criancaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid Crianca crianca){
        criancaService.create(crianca);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Crianca> replace(@PathVariable Long id, @RequestBody Crianca crianca) {
        criancaService.update(id, crianca);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        criancaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}