package org.example.repository;

import org.example.model.Aprendiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AprendizRepository extends JpaRepository<Aprendiz,Integer > {
}
