package edu.upc.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.Obra;

public interface  ObraRepository extends JpaRepository<Obra, Long> {

	public Obra findByTitulo(String titulo);
}
