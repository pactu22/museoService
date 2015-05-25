package edu.upc.pes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.model.Autor;
import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;
import edu.upc.pes.model.UsuarioRegistrado;
import edu.upc.pes.model.WrapperObra;
import edu.upc.pes.service.AutorService;
import edu.upc.pes.service.ColeccionService;
import edu.upc.pes.service.MuseoService;
import edu.upc.pes.service.ObraService;
import edu.upc.pes.service.UsuarioRegistradoService;

@Service
public class RestServiceImpl implements RestService {


	@Autowired
	private MuseoService museoService;

	@Autowired
	private ObraService obraService;

	@Autowired
	private ColeccionService coleccionService;

	@Autowired
	private UsuarioRegistradoService usuarioService;
	
	@Autowired
	private AutorService autorService;

	@Override
	public List<Obra> allObras() {
		return obraService.allObras();
	}

	@Override
	public Museo nuevoMuseo(Museo museo) {
		return museoService.newMuseo(museo);

	}

	@Override
	public List<Obra> obrasDeMuseo(String nombreMuseo) {
		Museo museo = museoService.findByNombre(nombreMuseo);
		if(museo != null){
			return museo.getObras();
		}
		return null;
	}


	@Override
	public Obra nuevaObraMuseo(WrapperObra obra, String nombreMuseo) {
		Museo museo = museoService.findByNombre(nombreMuseo);
		if(museo != null){
			Autor autor = autorService.getAtutor(obra.getIdAutor());
			if(autor != null){
				Obra o =  new Obra(obra.getTitulo(), autor, obra.getEstilo(), museo, obra.getIdBeacon());
				Coleccion coleccion = null;
				//recibo coleccion
				if(obra.getNombreColeccion() != null) {
					coleccion = coleccionService.getColeccion(obra.getNombreColeccion());
					if (coleccion != null && !coleccion.tieneObra(o)){
						if(museo.tieneColeccion(coleccion) && !museo.tieneObra(o)){
							o.setColeccion(coleccion);
							o.setInformacion(obra.getInformacion());
							museo.addObra(o);
							coleccion.addObra(o);
							return obraService.newObra(o);
						}
						System.out.println("ERROR: coleccion no pertenece a museo o Museo ya tiene esa obra");
						//ERROR: coleccion no pertenece a museo o Museo ya tiene esa obra
						return null;
					}
					System.out.println("ERROR: coleccion no existe o ya tiene esa obra");
					//coleccion no existe o ya tiene esa obra
					return null;
				}
				o.setInformacion(obra.getInformacion());
				museo.addObra(o);
				return obraService.newObra(o);
				
			}
			System.out.println("Autor no existe");
			return null;
			
		}
		return null;
	}

	@Override
	public Autor nuevoAutor(Autor autor) {
		if(!autorService.tiene(autor))return autorService.newAutor(autor);
		return null;
	}

	@Override
	public Coleccion nuevaColeccion(Coleccion col, String nombreMuseo) {
		Museo museo = museoService.findByNombre(nombreMuseo);
		if(museo != null){
			if(!museo.tieneColeccion(col)){
				col.setMuseo(museo);
				museo.addColeccion(col);
				return coleccionService.nuevaColeccion(col);
			}
				
		}
		return null;
	}

	@Override
	public List<Coleccion> coleccionesDeMuseo(String nombreMuseo) {
			return museoService.allColecciones(nombreMuseo);

	}
	
	@Override
	public List<Coleccion> allColecciones() {
			return coleccionService.allColecciones();

	}
	/*
	@Override
	public Coleccion nuevaColeccion(String nombreColeccion, String nombreMuseo) {
		Museo museo = museoService.findByNombre(nombreMuseo);
		if(museo != null){
			return coleccionService.nuevaColeccion(nombreColeccion, museo);
		}
		return null;
	}

	@Override
	public Obra nuevaObra(String titulo, String autor, String estilo,
			String nombreMuseo) {
		Museo museo = museoService.findByNombre(nombreMuseo);
		if(museo != null){

				return obraService.newObra(titulo, autor, estilo,  museo);
		}
		return null;
	}

	@Override
	public void eliminarObra(Long idObra) {
		obraService.borrarObra(idObra);

	}

	@Override
	public Obra editarObra(Long idObra, String titulo, String autor, String estilo,
			String nombreMuseo) {
		Obra obra = obraService.getObra(idObra);
		if( obra != null){
				Museo museo = museoService.findByNombre(nombreMuseo);
				if(museo != null){
					return obraService.editarObra(obra, titulo, autor, estilo, museo);

			}


		}
		return null;

	}


@Override
public List<Obra> obrasDeMuseoYColeccion(String nombreMuseo,
		String nombreColeccion) {
	Museo museo = museoService.findByNombre(nombreMuseo);
	if(museo != null){
		Coleccion coleccion = coleccionService.getColeccion(nombreColeccion);
		if(coleccion != null){
			return obraService.findByMuseoAndColeccion(museo, coleccion);
		}
	}
	return null;
}

@Override
public UsuarioRegistrado nuevoUsuarioRegistrado(String email,
		String contraseña) {

	return usuarioService.nuevoAdministrador(email, contraseña);
}

@Override
public UsuarioRegistrado nuevoVisitante(String email, String contraseña, Museo museo) {
	return usuarioService.nuevoVisitante(email, contraseña, museo);
}

@Override
public List<UsuarioRegistrado> allUsuariosRegistrados() {

	return usuarioService.getAllUsuariosRegistrados();
}

@Override
public List<Visitante> allVisitantes() {
	return usuarioService.getAllVisitantes();
}

@Override
public List<Visitante> allVisitantesOfMuseo(String nombreMuseo) {
	Museo museo = museoService.findByNombre(nombreMuseo);
	if(museo != null){
		return museo.getVisitantes();
	}
	return null;
}


@Override
public UsuarioRegistrado editarUsuario(String email, String nombre,
		String apellidos, String contraseña) {
	UsuarioRegistrado user = usuarioService.getUsuarioRegistrado(email);
	if(user != null){

		user.setEmail(email);
		user.setContraseña(contraseña);
		user.setApellidos(apellidos);
		user.setNombre(nombre);
	}

	return null;
}

@Override
public UsuarioRegistrado editarVisitante(String email, String nombre,
		String apellidos, String contraseña, String nombreMuseo) {
	Visitante user = usuarioService.getVisitante(email);
	if(user != null){
		Museo museo = museoService.findByNombre(nombreMuseo);
		if(museo != null){
			return usuarioService.editarVisitante(user, email,  nombre, apellidos, contraseña, museo);
		}
	}
	return null;
}

*/

	@Override
	public Obra editarObraMuseo(WrapperObra obra, String museo, Long idObra) {
		Obra obraAntigua = obraService.getObra(idObra);
		Museo mus = museoService.findByNombre(museo);
		Coleccion antigua = obraAntigua.getColeccion();
		Obra obraNueva = obraService.getObra(idObra);
		Coleccion col = null;
		if(obra.getNombreColeccion() != null){
			if(antigua != null ) antigua.borrarObra(obraAntigua);
			col = coleccionService.getColeccion(obra.getNombreColeccion());
			obraNueva.setColeccion(col);		

		}
		else obraNueva.setColeccion(null);
		
		Autor autor = autorService.getAtutor(obra.getIdAutor());
		
		obraNueva.setTitulo(obra.getTitulo());
		obraNueva.setAutor(autor);
		obraNueva.setEstilo(obra.getEstilo());
		obraNueva.setInformacion(obra.getInformacion());
		obraNueva.setBeacon(obra.getIdBeacon());
		if(col != null) col.addObra(obraNueva);		
		mus.editarObra(obraAntigua,obraNueva);
		return obraService.newObra(obraNueva);
	}

	@Override
	public List<Obra> borrarObraMuseo(Long idObra, String museo) {
		Museo mus = museoService.findByNombre(museo);
		Obra o = obraService.getObra(idObra);
		mus.borrarObra(o);
		obraService.borrarObra(o);
		return mus.getObras();
	}

	@Override
	public List<UsuarioRegistrado> allUsuarios() {
		
		return usuarioService.getAllUsuariosRegistrados();
	}


}
