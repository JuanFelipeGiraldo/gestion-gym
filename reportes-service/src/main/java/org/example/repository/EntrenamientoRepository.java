package org.example.repository;

import org.example.model.Entrenamiento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenamientoRepository extends MongoRepository<Entrenamiento,String> {
    @Query("{'aprendiz_id' : ?0}")
    List<Entrenamiento> findByAprendizId(int aprendizId);

}
