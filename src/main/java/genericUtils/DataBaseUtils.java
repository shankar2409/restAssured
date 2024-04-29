package genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static genericUtils.IPathConstants.*;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	Connection conn;

	public void readSingleDataFromDataBase(String query, int columnIndex, String expData) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			String actual = result.getString(columnIndex);

			if (actual.equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("data is present");
		} else {
			System.out.println("data is not present");
		}
		
	}

	public void ConnectToDB() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(DBURL, DBUserNAme, DBPassword);
	}

	public void disconnectToDB() throws SQLException {
		conn.close();
	}
}
