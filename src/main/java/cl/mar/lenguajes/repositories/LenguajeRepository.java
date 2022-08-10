package cl.mar.lenguajes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.mar.lenguajes.models.Lenguaje;

@Repository
public interface LenguajeRepository extends CrudRepository<Lenguaje, Long> {

}
