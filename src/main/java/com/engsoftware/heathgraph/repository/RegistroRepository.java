package com.engsoftware.heathgraph.repository;

import com.engsoftware.heathgraph.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
}
