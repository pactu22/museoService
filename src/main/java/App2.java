

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import edu.upc.pes.dao.ColeccionRepository;
import edu.upc.pes.dao.ExposicionRepository;
import edu.upc.pes.dao.MultimediaRepository;
import edu.upc.pes.dao.MuseoRepository;
import edu.upc.pes.dao.ObraRepository;
import edu.upc.pes.dao.VisitanteRepository;
import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Exposicion;
import edu.upc.pes.model.MultimediaItem;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;
import edu.upc.pes.model.Visitante;


/**
 * Standalone application with Spring Data JPA, Hibernate and Maven
 *
 */
public class App2 {
	
	public static void main(String[] args) {
		
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
	
	
		ObraRepository obraRepo = context.getBean(ObraRepository.class);
		MuseoRepository museoRepo = context.getBean(MuseoRepository.class);
		ColeccionRepository coleccionRepo = context.getBean(ColeccionRepository.class);
		ExposicionRepository expoRepo = context.getBean(ExposicionRepository.class);
		
		
		
		Museo museo = new Museo("Museu de la Música", "Museum of music with displays of 500 musical instruments from ancient civilizations to present.");
		museoRepo.save(museo);
		Exposicion expo = new Exposicion("Exposicion1", new Date(), museo);
		expoRepo.save(expo);
		
		Coleccion coleccion = new Coleccion("Coleccion antigua", museo);
		coleccion.setExposicion(expo);
		coleccionRepo.save(coleccion);
		
		coleccion = new Coleccion("Coleccion 2", museo);
		coleccion.setExposicion(expo);
		
		
		Obra o;
		for(int i = 0; i <= 3; i++){
			o = new Obra("Orpheus: visita audiovisual pel Museu"+i, "autor","estilo",museo);
			coleccion.addObra(o);
			coleccionRepo.save(coleccion);
			o.setColeccion(coleccion);
			obraRepo.save(o);
		}
		
		museo = new Museo("Museo2", "Otro museo");
		museoRepo.save(museo);
		coleccion = new Coleccion("Coleccion moderna", museo);
		
		for(int i = 0; i <= 3; i++){
			o = new Obra("Obra"+i, "autorrrr","estiloooo", museo);
			coleccion.addObra(o);
			coleccionRepo.save(coleccion);
			o.setColeccion(coleccion);
			obraRepo.save(o);
		}
		
		VisitanteRepository visitanteRepo = context.getBean(VisitanteRepository.class);
		Visitante user = new Visitante("email", "contraseña", "alejandra", "porras mateo", museo);
		visitanteRepo.save(user);
		MultimediaRepository imgRepo = context.getBean(MultimediaRepository.class);
		
		String folder = "/home/ale/picture/"; // he puesto todas mis imagenes en esta carpeta: solo hay dos: image1.jpg & image2.jpg
		Obra obraAux = obraRepo.findByTitulo("Obra1");
		for (int i=1; i <=2; ++i) {
			
			File file = new File(folder + "image"+i+".png"); // lee la imagen como un fichero
			try {
				FileInputStream multimediaFile = new FileInputStream(file);
				
				byte[] arrayBytes = new byte[(int) file.length()];  // un array del tamanho del fichero
				System.out.println("len Imagen:"+ arrayBytes.length);
				
				try {
					multimediaFile.read(arrayBytes);
					
					// Creo el objeto multimedia y lo guardo en BD
					MultimediaItem imagen = new MultimediaItem();
					imagen.setId("image"+i+".jpg");  // nombre de la imagen
					imagen.setContent(arrayBytes);     // el contenido, o sea la imagen misma
					imagen.setObra(obraAux);
					imgRepo.save(imagen);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  // el array ahora tiene el fichero multimedia
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		context.close();
		
	}
}