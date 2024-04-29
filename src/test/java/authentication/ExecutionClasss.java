package authentication;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ExecutionClasss {
	
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		purchase v1 = new purchase(1162, "Hello.com");
		Title t1 = new Title("Cypress", 40, 4);
		Title t2 = new Title("RPA", 45, 10);
		Title t3 = new Title("Appium", 36, 7);
		Title[] value= {t1,t2,t3};
		pojoclasspract jObj = new pojoclasspract(v1 ,value);
		ObjectMapper map = new ObjectMapper();
		map.writerWithDefaultPrettyPrinter().writeValue(new File("./tasks.json"), jObj);
	}
}
