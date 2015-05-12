package edu.upc.pes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.upc.pes.model.Obra;
import edu.upc.pes.service.MuseoService;
import edu.upc.pes.service.ObraService;

@RestController
public class WSRestController {

	@Autowired
	private ObraService obraService;
	
	@Autowired
	private MuseoService museoService;
	
	
	
	@RequestMapping(value = RestUrisConstants.GET_ALL_OBRAS, method = RequestMethod.GET)
	public List<Obra> getAllObras() {
		return obraService.allObras();
	}
	@RequestMapping(value = RestUrisConstants.GET_OBRAS_MUSEO, method = RequestMethod.GET)
	public List<Obra> getAllObrasByMuseo(@PathVariable("museo") String museo) {
		System.out.println("MUSEO:" + museo);
		
		return museoService.getAllObrasByMuseo(museo);
	}
	
	//Operaciones CRUD
	
	@RequestMapping(value = RestUrisConstants.CREATE_OBRA, method = RequestMethod.POST)
    public void nuevaObra(@PathVariable("titulo") String titulo,@PathVariable("autor") String autor,@PathVariable("estilo") String estilo,@PathVariable("coleccion") String coleccion,@PathVariable("museo") String museo) {
		
		museoService.agregarObra(titulo, autor,estilo,coleccion,museo);
    }
	
	@RequestMapping(value = RestUrisConstants.DELETE_OBRA, method = RequestMethod.POST)
    public void borrarObra(@PathVariable("id") String id) {
		museoService.borrarObra(id);
    }
	
	@RequestMapping(value = RestUrisConstants.EDIT_OBRA, method = RequestMethod.POST)
    public void editarObra(@PathVariable("id") String idObra, @PathVariable("titulo") String titulo,@PathVariable("autor") String autor,@PathVariable("estilo") String estilo,@PathVariable("coleccion") String coleccion,@PathVariable("museo") String museo) {
		museoService.editarObra(idObra, titulo, autor,estilo,coleccion,museo);
    }
	
	@RequestMapping(value = RestUrisConstants.GET_OBRA, method = RequestMethod.GET)
    public Obra getObra(@PathVariable("id") String idObra) {
		return museoService.getObra(idObra);
    }
	
     
}
