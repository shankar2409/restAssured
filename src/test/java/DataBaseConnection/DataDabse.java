package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataDabse {
	@Test
	public void name() throws Throwable {
		Driver sdriver = new Driver();

		DriverManager.registerDriver(sdriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement stmt = conn.createStatement();

		ResultSet result = stmt.executeQuery("select project_name from project where project_id='TY_PROJ_009'");
		while (result.next()) {
			System.out.println(result.getString(1));
		}
	}
}
