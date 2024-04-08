package org.example.repository;

import org.example.model.Aprendiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AprendizRepository extends JpaRepository<Aprendiz,Integer> {
}
