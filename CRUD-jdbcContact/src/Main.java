import java.sql.*;
import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResourceBundle rb = ResourceBundle.getBundle("mysql");
		String url ="jdbc:mysql://localhost/vlibrary";
		String username = "localhost";
		String password ="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT cid,name,address,phone FROM vlibrary";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String cid = rs.getString("cid");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");

				// Display values
				System.out.print("Cid: "+cid);
				System.out.print(", Name: " + name);
				System.out.print(", Address: " + address);
				System.out.println(", Phone: " + phone);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
