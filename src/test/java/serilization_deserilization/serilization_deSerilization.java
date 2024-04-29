   package serilization_deserilization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.MobileBrand;

public class serilization_deSerilization {
	@Test
	public void serilization() throws Throwable, JsonMappingException{
		MobileBrand mobile = new MobileBrand("Samsung", "128GB", "black", 20000, 12);
		ObjectMapper obj = new ObjectMapper();
		obj.writerWithDefaultPrettyPrinter().writeValue(new File(".//output//serilization.json"),mobile);
	}
	@Test
	public void deserilization() throws Throwable, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		MobileBrand mob = obj.readValue(new File(".//output//serilization.json"), MobileBrand.class);
		System.out.println(mob.getBrandName());
		System.out.println(mob.getCapacity());
		System.out.println(mob.getColor());
		System.out.println(mob.getPrice());
		System.out.println(mob.getRam());
	}
}
