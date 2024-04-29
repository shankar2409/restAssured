package serilization_deserilization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.MobileWithArray;

public class serilization_deserilizationWithArray {
	@Test
	public void Serilization() throws JsonGenerationException, JsonMappingException, IOException {
		int[] price = { 20000, 430000 };
		MobileWithArray mob = new MobileWithArray("oppo", "128GB", "black", price, 12);
		ObjectMapper obj=new ObjectMapper();
		obj.writerWithDefaultPrettyPrinter().writeValue(new File(".//output//serilizationWithArray.json"), mob);
	}
	@Test(dependsOnMethods = "Serilization")
	public void deserilization() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj=new ObjectMapper();
		MobileWithArray mob = obj.readValue(new File(".//output//serilizationWithArray.json"), MobileWithArray.class);
		System.out.println(mob.getBrandName());
		System.out.println(mob.getCapacity());
		System.out.println(mob.getCapacity());
		System.out.println(mob.getRam());
		int[] price = mob.getPrice();
		for (int i : price) {
			System.out.println(i);
		}
	}
}

