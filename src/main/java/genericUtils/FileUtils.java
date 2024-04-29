package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	
	public String ReadDataFromPropertyFile(String Key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(Key);
	}
	
}
