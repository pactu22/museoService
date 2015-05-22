package edu.upc.pes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;

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
		public Obra nuevaObraMuseo(Obra obra, String nombreMuseo) {
			Museo museo = museoService.findByNombre(nombreMuseo);
			if(museo != null){
				if(!museo.tieneObra(obra)){
					System.out.println("TIENE");
					return obraService.newObra(obra, museo);
				}
			}
			return null;
		}
	
}
