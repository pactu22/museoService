package edu.upc.pes.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.Autor;

public interface AutorRepository  extends JpaRepository<Autor, Long> {
	public Autor findByNombreAndApellidosAndFechaNacimientoAndNacionalidad(String nombre, String apellidos, Date fechaNacimiento, String nacionalidad);
}
