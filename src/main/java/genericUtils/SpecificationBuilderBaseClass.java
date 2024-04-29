package genericUtils;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationBuilderBaseClass {
	FileUtils flib=new FileUtils();
	javaUtils jLib=new javaUtils();
	ExcelUtils eLib=new ExcelUtils();
	
	public RequestSpecBuilder builder;
	public RequestSpecification reqSpec;
	public ResponseSpecification re;
	public ResponseSpecBuilder builder2;
	/**
	 * this will give the specification common for all api requests
	 * @author Shankar
	 */
	@BeforeSuite
	public void bsConfig() {
		/*		 
		String BaseUri = flib.ReadDataFromPropertyFile("BaseUri");
		String portNo = flib.ReadDataFromPropertyFile("portNo");
		int portno = Integer.parseInt(portNo);
		*/
		
		builder=new RequestSpecBuilder();
		builder.setBaseUri("http://rmgtestingserver");
		builder.setPort(8084);
		builder.setContentType(ContentType.JSON);
		reqSpec=builder.build();
		
		builder2=new ResponseSpecBuilder();
		builder2.expectContentType(ContentType.JSON);
		builder2.expectResponseTime(Matchers.lessThanOrEqualTo(3000l),TimeUnit.MILLISECONDS);
		 re = builder2.build();
		 
	}
}
