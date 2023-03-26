package com.ap.ap.repository;

import com.ap.ap.models.cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepo extends JpaRepository<cursos,Long> {
}
