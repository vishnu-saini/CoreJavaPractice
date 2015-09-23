import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ContactDAO {
	private static ResourceBundle rb = ResourceBundle.getBundle("mysql");
	private String url = rb.getString("db.url");
	private String username = rb.getString("db.username");
	private final String password = rb.getString("db.password");
	// private final String driver = rb.getString("db.driverclass");
	private final String driver = "com.mysql.jdbc.Driver";

	Connection getConnection() throws SQLException {
		Connection dbconnection = null;
		try {
			Class.forName(driver);
			dbconnection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			throw new SQLException("Driver Not Found");
		}
		return dbconnection;
	}

	public List<Contact> getAllContacts() {
		List<Contact> contactList = new ArrayList<Contact>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String query = "select firstname,lastname,email,phoneno from contact";
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setFirstName(resultSet.getString("firstname"));
				contact.setLastName(resultSet.getString("lastname"));
				contact.setEmail(resultSet.getString("email"));
				contact.setPhoneNo(resultSet.getString("phoneno"));
				contactList.add(contact);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return contactList;
	}

	public void insertContact(Contact contact) {

		ResourceBundle rb = ResourceBundle.getBundle("mysql");
		String url = rb.getString("db.url");
		String userName = rb.getString("db.username");
		String passWord = rb.getString("db.password");
		Connection connection = null;
		PreparedStatement pstatement = null;
		String query = "insert into  contact(firstname,lastname,email,phoneno) values(?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, passWord);
			pstatement = connection.prepareStatement(query);
			pstatement.setString(1, contact.getFirstName());
			pstatement.setString(2, contact.getLastName());
			pstatement.setString(3, contact.getEmail());
			pstatement.setString(4, contact.getPhoneNo());
			pstatement.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstatement != null)
					pstatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}