package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class getColumnNames {
	public static void main(String[] args) throws Exception {
		Driver sdriver = new Driver();

		DriverManager.registerDriver(sdriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement stmt = conn.createStatement();
		int i = 1, count = 0;

		ResultSet row = stmt.executeQuery("select * from project;");
		ResultSetMetaData ro = row.getMetaData();
		System.out.println(ro.getColumnCount());
		while (row.next()) {
			try {
				System.out.println(ro.getColumnName(i));
				System.out.println(ro.getColumnTypeName(i));
				count++;
				i++;
			} catch (Exception e) {
				break;
			}
			
		}
		System.out.println(count);
		
	}
}
