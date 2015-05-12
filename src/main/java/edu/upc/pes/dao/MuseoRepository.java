package edu.upc.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.Museo;

public interface MuseoRepository extends JpaRepository<Museo, String> {

}
