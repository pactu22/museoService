package edu.upc.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.Visitante;


public interface VisitanteRepository extends JpaRepository<Visitante, String> {

}
