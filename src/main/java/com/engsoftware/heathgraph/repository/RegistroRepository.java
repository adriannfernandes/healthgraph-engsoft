package com.engsoftware.heathgraph.repository;

import java.util.List;
import com.engsoftware.heathgraph.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
    @Query("SELECT r FROM Registro r WHERE r.crianca.id = :idCrianca")
    List<Registro> findAllByIdCrianca (Long idCrianca);








}
