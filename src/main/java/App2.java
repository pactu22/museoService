

import org.springframework.context.support.FileSystemXmlApplicationContext;



/**
 * Standalone application with Spring Data JPA, Hibernate and Maven
 *
 */
public class App2 {
	
	public static void main(String[] args) {
		
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
	
	
		context.close();
		
	}
}