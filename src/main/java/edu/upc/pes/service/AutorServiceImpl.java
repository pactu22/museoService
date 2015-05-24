package edu.upc.pes.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.dao.AutorRepository;
import edu.upc.pes.model.Autor;

@Service
public class AutorServiceImpl implements AutorService {
	@Autowired
	AutorRepository autorRepo;
	
	@Override
	public Autor getAtutor(Long id) {
		
		return autorRepo.findOne(id);
	}

	@Override
	public Autor newAutor(Autor autor) {
		
		return autorRepo.save(autor);
	}

	@Override
	public boolean tiene(Autor autor) {
		Autor aux = getAtutor(autor.getNombre(), autor.getApellidos(), autor.getFechaNacimiento(), autor.getNacionalidad());
		return (aux != null);
	}

	@Override
	public Autor getAtutor(String nombre, String apellidos,
			Date fechaNacimiento, String nacionalidad) {

		return autorRepo.findByNombreAndApellidosAndFechaNacimientoAndNacionalidad(nombre, apellidos, fechaNacimiento, nacionalidad);
	}

}
