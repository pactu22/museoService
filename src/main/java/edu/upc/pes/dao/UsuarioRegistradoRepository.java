package edu.upc.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.UsuarioRegistrado;

public interface UsuarioRegistradoRepository extends JpaRepository<UsuarioRegistrado, String> {
	public UsuarioRegistrado findByTipo(String tipo);
}
