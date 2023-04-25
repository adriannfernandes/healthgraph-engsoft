package com.engsoftware.repositories;

import com.engsoftware.entities.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriancaRepository extends JpaRepository<Crianca, Long> {
}
