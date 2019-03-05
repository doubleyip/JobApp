package sql;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ApplyQuery {
	public Connection getDBConnection() {
		Connection con = null;
		//First load the driver class
		//Type 1: JDBC-ODBC bridge
		//Type 2:Partial java driver
		//Type 3: Pure Java driver for database middleware
		//Type 4: Pure java driver for direct-to-database
		//Type 5:highly-functional driver 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/sydbase","system","Yippass1");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String args[]) {
		ApplyQuery dbConn = new ApplyQuery();
		Connection conn = dbConn.getDBConnection();
		ResultSet rs = null;
		try {
			System.out.println("Connection is closed? "+conn.isClosed());
			Statement s = conn.createStatement();
			/*
			rs = s.executeQuery("Select * from Job_applications order by job_id where ");
			while(rs.next()){
				System.out.println("Id->"+rs.getInt(1)+" "+rs.getString(2));
			}
			rs.close();
			PreparedStatement ps = conn.prepareStatement("Select * from job_applications where job_id = ? order by employee_id");
			ps.setInt(1, 5);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println("Id PS->"+rs.getInt(1)+" "+rs.getString(2));
			}
			rs.close();
			CallableStatement cs = conn.prepareCall("{call greetings}");
			rs = cs.executeQuery();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
