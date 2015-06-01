package edu.upc.pes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.dao.AutorRepository;
import edu.upc.pes.dao.ObraRepository;
import edu.upc.pes.model.Autor;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;

@Service
public class AutorServiceImpl implements AutorService {
	@Autowired
	AutorRepository autorRepo;
	
	@Autowired
	ObraRepository obraRepo;
	
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

	@Override
	public List<Autor> getAll() {
		return autorRepo.findAll();
	}

	@Override
	public List<Obra> getObrasByAutorAndMuseo(String nombres, Museo museo) {
		System.out.println("BUSCO: " + nombres);
		List<Obra> result = new ArrayList<Obra>();
		List<Autor> autores = autorRepo.findAll();
		for(Autor autor : autores){
			if (autor.getNombreYApellidos().contains(nombres)){
				System.out.println("CONTIENE " + autor.getNombreYApellidos());
				List<Obra> obras = obraRepo.findByMuseoAndAutor(museo, autor);
				result.addAll(obras);
			}
		}
		return result;
	}

}
