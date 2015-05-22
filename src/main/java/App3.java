
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import edu.upc.pes.dao.MultimediaRepository;
import edu.upc.pes.model.MultimediaItem;

public class App3 {
	
	public static void main(String[] args) {
		
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
			
		MultimediaRepository imgRepo = context.getBean(MultimediaRepository.class);
		
		// Preparo la carga inicial de todas las imagenes desde una carpeta predefinida
		
		String folder = "/home/felipe/Downloads/"; // he puesto todas mis imagenes en esta carpeta: solo hay dos: image1.jpg & image2.jpg
		
		for (int i=1; i <=2; ++i) {
						
			File file = new File(folder + "image"+i+".jpg"); // lee la imagen como un fichero
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
