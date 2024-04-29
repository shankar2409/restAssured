package genericUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class javaUtils {
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(2000);
	}

	public String getSystemDate() {
		Date date = new Date();
		return date.toString();
	}
	
	
}
