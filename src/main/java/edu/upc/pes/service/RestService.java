package edu.upc.pes.service;

import java.util.List;

import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;

public interface RestService {

	public List<Obra> allObras();
	
	public Museo nuevoMuseo(Museo museo);
	
	
	public List<Obra> obrasDeMuseo (String nombreMuseo);

	public Obra nuevaObraMuseo(Obra obra, String museo);
	
	/*
public Coleccion nuevaColeccion(String nombreColeccion, String nombreMuseo);
	
	public Obra nuevaObra(String titulo, String autor, String estilo,  String nombreMuseo);
	
	public void eliminarObra(Long idObra);
	
	public Obra editarObra(Long idObra, String titulo, String autor, String estilo,  String nombreMuseo);
	
	public List<Obra> obrasDeMuseoYColeccion (String nombreMuseo, String nombreColeccion);
	
	public UsuarioRegistrado nuevoUsuarioRegistrado(String email, String contraseña);
	
	public UsuarioRegistrado nuevoVisitante(String email, String contraseña, Museo museo);
	
	public List<UsuarioRegistrado> allUsuariosRegistrados();
	
	public List<Visitante> allVisitantes();
	
	public List<Visitante> allVisitantesOfMuseo(String museo);
	
	public UsuarioRegistrado editarUsuario(String email, String nombre, String apellidos, String contraseña);
	
	public UsuarioRegistrado editarVisitante(String email, String nombre, String apellidos, String contraseña, String nombreMuseo);
	*/
}
