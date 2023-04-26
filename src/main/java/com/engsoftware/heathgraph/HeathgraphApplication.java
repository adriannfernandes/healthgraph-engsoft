package com.engsoftware.heathgraph;

import com.engsoftware.heathgraph.entities.Crianca;
import com.engsoftware.heathgraph.entities.Registro;
import com.engsoftware.heathgraph.repository.CriancaRepository;
import com.engsoftware.heathgraph.repository.RegistroRepository;
import com.engsoftware.heathgraph.service.CriancaService;
import com.engsoftware.heathgraph.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

import static com.engsoftware.heathgraph.entities.Sexo.FEMININO;
import static com.engsoftware.heathgraph.entities.Sexo.MASCULINO;

@SpringBootApplication
public class HeathgraphApplication implements CommandLineRunner {


	@Autowired
	private CriancaService criancaService;
	@Autowired
	private RegistroService registroService;

	public static void main(String[] args) {
		SpringApplication.run(HeathgraphApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Crianca c = new Crianca("Criança", 12, FEMININO,"111.111.111-11");
		criancaService.create(c);
		Registro r = new Registro(46.0,1.62,13);
		r.setData(LocalDate.now());
		//r.setCrianca(c);
		registroService.saveRegistro(c.getId(), r);
		Registro r2 = new Registro(47.0,1.64,14);
		r2.setData(LocalDate.now());
//		r2.setCrianca(c);
		registroService.saveRegistro(c.getId(), r2);
		Registro r3 = new Registro(48.0,1.66,15);
		r3.setData(LocalDate.now());
//		r3.setCrianca(c);
		registroService.saveRegistro(c.getId(), r3);
	}
}
