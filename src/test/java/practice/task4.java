package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericUtils.javaUtils;

public class task4 {
	@Test
	public void t1() throws Exception {
		int ran = new javaUtils().getRandomNumber();
		Driver sdriver = new Driver();
		String projId="TYPROJ_"+ran;
		String createdBy="qwerty"+ran;
		
		DriverManager.registerDriver(sdriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement stmt = conn.createStatement();
		String query = "insert into project values('"+projId+"','"+createdBy+"','today','"+createdBy+"','Created',20)";
		int result = stmt.executeUpdate(query);
		if (result >= 1) {
			System.out.println("resource added");
		} else {
			System.out.println("resource not added");
		}
	}
}
