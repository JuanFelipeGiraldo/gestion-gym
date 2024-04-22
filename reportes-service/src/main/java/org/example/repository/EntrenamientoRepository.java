package org.example.repository;

import org.example.model.Entrenamiento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenamientoRepository extends MongoRepository<Entrenamiento,String> {

}
