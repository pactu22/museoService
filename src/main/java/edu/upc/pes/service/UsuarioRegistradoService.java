package edu.upc.pes.service;

import java.util.List;

import edu.upc.pes.model.Museo;
import edu.upc.pes.model.UsuarioRegistrado;
import edu.upc.pes.model.Visitante;

public interface UsuarioRegistradoService {
	
	public UsuarioRegistrado nuevoAdministrador(String email, String contraseña);
	public Visitante nuevoVisitante(String email, String contraseña, Museo museo);
	public List<Visitante> getAllVisitantes();
	public Visitante getVisitante(String email);
	public UsuarioRegistrado getUsuarioRegistrado(String email);
	public List<UsuarioRegistrado> getAllUsuariosRegistrados();
	public Visitante editarVisitante(Visitante user, String email, String nombre,
			String apellidos, String contraseña, Museo museo);
}
