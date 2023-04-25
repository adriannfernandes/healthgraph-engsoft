package com.engsoftware.heathgraph.repository;

import java.util.List;
import com.engsoftware.heathgraph.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
    
    List<Registro> findAllByIdCrianca (Long idCrianca);
}
