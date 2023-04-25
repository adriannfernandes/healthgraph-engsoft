package com.engsoftware.heathgraph.controlers;

import com.engsoftware.heathgraph.entities.Registro;
import com.engsoftware.heathgraph.service.RegistroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/registros")
public class RegistroControler {

    @Autowired
    private final RegistroService registroService;


    @GetMapping
    public ResponseEntity<List<Registro>> findAllRegistros() {
        return ResponseEntity.status(HttpStatus.OK).body(registroService.findAllRegistros());
    }

    @PostMapping
    public ResponseEntity<Registro> saveRegistro(@RequestParam(value = "idCrianca") Long id, @RequestBody @Valid Registro registro) {
        return new ResponseEntity(registroService.saveRegistro(id, registro), HttpStatus.CREATED);
    }


}
