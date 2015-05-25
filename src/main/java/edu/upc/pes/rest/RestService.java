package edu.upc.pes.rest;

import java.util.List;

import edu.upc.pes.model.Autor;
import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;
import edu.upc.pes.model.UsuarioRegistrado;
import edu.upc.pes.model.WrapperObra;

public interface RestService {


	
	public Museo nuevoMuseo(Museo museo);
	
	public Autor nuevoAutor(Autor autor);

	public Coleccion nuevaColeccion(Coleccion col, String museo);
	
	public Obra nuevaObraMuseo(WrapperObra obra, String museo);

	public List<Obra> allObras();

	public List<Obra> obrasDeMuseo (String nombreMuseo);

	public List<Coleccion> coleccionesDeMuseo(String museo);

	public List<Coleccion> allColecciones();

	public Obra editarObraMuseo(WrapperObra obra, String museo, Long idObra);

	public List<Obra> borrarObraMuseo(Long idObra, String museo);

	public List<UsuarioRegistrado> allUsuarios();

	
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
