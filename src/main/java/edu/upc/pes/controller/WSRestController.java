package edu.upc.pes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.upc.pes.model.Autor;
import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;
import edu.upc.pes.model.WrapperObra;
import edu.upc.pes.rest.RestService;

@RestController
@RequestMapping("/rest")
public class WSRestController {

	@Autowired
	private RestService restService;
	
	@RequestMapping(value = RestUrisConstants.NEW_MUSEO, method = RequestMethod.POST)
	public Museo nuevoMuseo(@RequestBody Museo museo) {
		return restService.nuevoMuseo(museo);
	}
	
	@RequestMapping(value = RestUrisConstants.NEW_AUTOR, method = RequestMethod.POST)
	public Autor nuevoAutor(@RequestBody Autor autor) {
		//autor.setFechaNacimiento(new Date());
		return restService.nuevoAutor(autor);
	}
	
	@RequestMapping(value = RestUrisConstants.NEW_COLECCION, method = RequestMethod.POST)
	public Coleccion nuevoColeccion(@RequestBody Coleccion coleccion, @PathVariable("museo") String museo) {
		return restService.nuevaColeccion(coleccion, museo);
	}
	
	
	@RequestMapping(value = RestUrisConstants.NEW_OBRA_OF_MUSEO, method = RequestMethod.POST)
	public Obra nuevaObraAlMuseo(@RequestBody WrapperObra obra, @PathVariable("museo") String museo) {
		System.out.println("DENTRO");
		return restService.nuevaObraMuseo(obra,museo);
	}

	@RequestMapping(value = RestUrisConstants.GET_OBRAS_MUSEO, method = RequestMethod.GET)
	public List<Obra> getAllObrasByMuseo(@PathVariable("museo") String museo) {
		System.out.println("MUSEO:" + museo);
		return restService.obrasDeMuseo(museo);
	}
	
	@RequestMapping(value = RestUrisConstants.EDITAR_OBRA_OF_MUSEO, method = RequestMethod.PUT)
	public Obra editarObra(@RequestBody WrapperObra obra, @PathVariable("museo") String museo, @PathVariable("id") Long idObra) {
		//TODO MODIFICAR OBRA DE MSEO
		return restService.editarObraMuseo(obra,museo, idObra);
	}
	@RequestMapping(value = RestUrisConstants.BORRAR_OBRA_OF_MUSEO, method = RequestMethod.POST)
	public List<Obra> borrarObra( @PathVariable("museo") String museo, @PathVariable("id") Long idObra) {
		return restService.borrarObraMuseo(idObra,museo);
	}
	
	
	@RequestMapping(value = RestUrisConstants.GET_OBRAS, method = RequestMethod.GET)
	public List<Obra> getAllObras() {
		return restService.allObras();
	}
	
	@RequestMapping(value = RestUrisConstants.GET_COLECCIONES_MUSEO, method = RequestMethod.GET)
	public List<Coleccion> getAllColeccionesByMuseo(@PathVariable("museo") String museo) {
		return restService.coleccionesDeMuseo(museo);
	}
	@RequestMapping(value = RestUrisConstants.GET_COLECCIONES, method = RequestMethod.GET)
	public List<Coleccion> getAllColecciones() {
		return restService.allColecciones();
	}
	
     
}
