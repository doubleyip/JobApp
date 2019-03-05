package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ApplyQuery {
	
	public void runQuery(String sql, Connection conn) {
		ResultSet rs = null;
		try {
			Statement state = conn.createStatement();
			rs = state.executeQuery(sql);
			System.out.println("Insert Success");
			} 
		catch(SQLException e) {
			e.printStackTrace();
			}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				} 
			catch (SQLException e) {
				e.printStackTrace();
				}
		}
	}
	
	
}
