

import org.springframework.context.support.FileSystemXmlApplicationContext;

import edu.upc.pes.dao.MuseoRepository;
import edu.upc.pes.dao.ObraRepository;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;


/**
 * Standalone application with Spring Data JPA, Hibernate and Maven
 *
 */
public class App2 {
	
	public static void main(String[] args) {
		
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
	
	
		
		ObraRepository obraRepo = context.getBean(ObraRepository.class);
		MuseoRepository museoRepo = context.getBean(MuseoRepository.class);
		Obra o;
		Museo museo = new Museo("Museu de la Música", "Museum of music with displays of 500 musical instruments from ancient civilizations to present.");
		museoRepo.save(museo);
		for(int i = 0; i <= 3; i++){
			o = new Obra("Orpheus: visita audiovisual pel Museu"+i, "autor","estilo", "Fons Sonor",museo);
			obraRepo.save(o);
		}
		
		museo = new Museo("Museo2", "Otro museo");
		museoRepo.save(museo);
		for(int i = 0; i <= 3; i++){
			o = new Obra("Obra"+i, "autor","estilo", "coleccion",museo);
			obraRepo.save(o);
		}
		context.close();
		
	}
}