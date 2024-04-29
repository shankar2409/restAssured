package serilization_deserilization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.MobilSubBrand;
import pojoClass.MobileWithObject;

public class serializatioWithObject {
	@Test
	public void serilization() throws JsonGenerationException, JsonMappingException, IOException {
		int[] price = { 1000, 2000 };
		int[] priceForOppo = { 30000, 29999 };
		MobilSubBrand subBrand = new MobilSubBrand("realme", "128GB", "pink", price, 128);
		MobileWithObject mob = new MobileWithObject("oppo", "256GB", "black", priceForOppo, 12, subBrand);

		ObjectMapper map = new ObjectMapper();
		map.writerWithDefaultPrettyPrinter().writeValue(new File("./mobileWithObj.json"), mob);
	}
	@Test
	public void deserilization() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper map=new ObjectMapper();
		MobileWithObject mob = map.readValue(new File("./mobileWithObj.json"), MobileWithObject.class);
		System.out.println(mob.getBrandName());
		System.out.println(mob.getCapacity());
		System.out.println(mob.getColor());
		System.out.println(mob.getRam());
		for (int i : mob.getPrice() ){
			System.out.println(i);
		}
		System.out.println("===============");
		MobileWithObject sub = mob.getSubBrand();
		System.out.println(sub.getBrandName());
		System.out.println(sub.getCapacity());
		System.out.println(sub.getColor());
		System.out.println(sub.getRam());
		for (int i : sub.getPrice()) {
			System.out.println(i);
		}
		System.out.println(sub.getSubBrand());
	}
}
