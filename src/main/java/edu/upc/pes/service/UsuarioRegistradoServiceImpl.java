package edu.upc.pes.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.dao.MuseoRepository;
import edu.upc.pes.dao.UsuarioRegistradoRepository;
import edu.upc.pes.dao.VisitanteRepository;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.UsuarioRegistrado;
import edu.upc.pes.model.Visitante;


@Service
public class UsuarioRegistradoServiceImpl implements UsuarioRegistradoService{


	@Autowired
	private MuseoRepository museoRepository;
	
	@Autowired
	private UsuarioRegistradoRepository usuarioRegistradoRepository;
	
	@Autowired
	private VisitanteRepository visitanteRepository;
	
	@Override
	public UsuarioRegistrado nuevoAdministrador(String email, String contraseña) {
		UsuarioRegistrado admin = new UsuarioRegistrado(email,contraseña,"administrador");
		return usuarioRegistradoRepository.save(admin);
	}

	@Override
	public Visitante nuevoVisitante(String email, String contraseña, Museo museo) {
		Visitante visitante = new Visitante(email, contraseña, museo);
		return visitanteRepository.save(visitante);
	}

	@Override
	public List<Visitante> getAllVisitantes() {
		return visitanteRepository.findAll();
	}
	@Override
	public List<UsuarioRegistrado> getAllUsuariosRegistrados() {
		return usuarioRegistradoRepository.findAll();
	}

	@Override
	public Visitante getVisitante(String email) {
		return visitanteRepository.findOne(email);
	}

	@Override
	public UsuarioRegistrado getUsuarioRegistrado(String email) {
		return usuarioRegistradoRepository.findOne(email);
	}

	@Override
	public Visitante editarVisitante(Visitante user, String email,
			String nombre, String apellidos, String contraseña, Museo museo) {
		user.setEmail(email);
		user.setContraseña(contraseña);
		user.setApellidos(apellidos);
		user.setNombre(nombre);
		user.setMuseo(museo);
		user.setTipo("visitante");
		return visitanteRepository.save(user);
	}

}
