package edu.upc.pes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;
import edu.upc.pes.service.RestService;

@RestController
@RequestMapping("/rest")
public class WSRestController {

	@Autowired
	private RestService restService;
	
	
	
	@RequestMapping(value = RestUrisConstants.GET_ALL_OBRAS, method = RequestMethod.GET)
	public List<Obra> getAllObras() {
		return restService.allObras();
	}
	@RequestMapping(value = RestUrisConstants.GET_OBRAS_MUSEO, method = RequestMethod.GET)
	public List<Obra> getAllObrasByMuseo(@PathVariable("museo") String museo) {
		System.out.println("MUSEO:" + museo);
		return restService.obrasDeMuseo(museo);
	}
	@RequestMapping(value = RestUrisConstants.NEW_MUSEO, method = RequestMethod.POST)
	public Museo nuevoMuseo(@RequestBody Museo museo) {
		return restService.nuevoMuseo(museo);
	}
	@RequestMapping(value = RestUrisConstants.NEW_OBRA_OF_MUSEO, method = RequestMethod.POST)
	public Obra nuevaObraAlMuseo(@RequestBody Obra obra, @PathVariable("museo") String museo) {
		System.out.println("DENTRO");
		return restService.nuevaObraMuseo(obra,museo);
	}
	
     
}
