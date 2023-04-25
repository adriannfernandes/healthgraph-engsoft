package com.engsoftware.heathgraph.controlers;

import com.engsoftware.heathgraph.entities.Registro;
import com.engsoftware.heathgraph.service.RegistroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/registros")
public class RegistroControler {

    @Autowired
    private final RegistroService registroService;

    @GetMapping
    public ResponseEntity<List<Registro>> findAllRegistros(){
        return ResponseEntity.status(HttpStatus.OK).body(registroService.findAllRegistros());
    }

    @PostMapping
    public ResponseEntity<Registro> saveRegistro(@RequestBody @Valid Registro registro){
        return new ResponseEntity(registroService.saveRegistro(registro), HttpStatus.CREATED);
    }

//    @PutMapping(path="/{id}")
//    public ResponseEntity<Registro> replace(@PathVariable Long id, @RequestBody Registro registro) {
//        registroService.update(id, registro);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        registroService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
