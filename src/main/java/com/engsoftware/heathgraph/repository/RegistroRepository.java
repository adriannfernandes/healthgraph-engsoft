package com.engsoftware.heathgraph.repository;

import java.util.List;
import com.engsoftware.heathgraph.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
//    @Query("SELECT * FROM crianca WHERE idCrianca = :idCrianca")
//    List<Registro> findAllByIdCrianca (Long idCrianca);
}
