package com.engsoftware.heathgraph;

import com.engsoftware.heathgraph.entities.Crianca;
import com.engsoftware.heathgraph.entities.Registro;
import com.engsoftware.heathgraph.repository.CriancaRepository;
import com.engsoftware.heathgraph.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.engsoftware.heathgraph.entities.Sexo.MASCULINO;

@SpringBootApplication
public class HeathgraphApplication implements CommandLineRunner {

	@Autowired
	private CriancaRepository criancaRepository;

	@Autowired
	private RegistroRepository registroRepository;

	public static void main(String[] args) {
		SpringApplication.run(HeathgraphApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Crianca c = new Crianca("Criança", 12, MASCULINO,"111.111.111-11");
		criancaRepository.save(c);

		Registro r = new Registro(10.0, 50.0);

		registroRepository.save(r);
	}
}
