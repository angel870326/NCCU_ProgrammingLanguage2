import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource {
	private static String url;
	private static String username;
	private static String password;

	public static Connection getConnection() throws SQLException {
		String server = "jdbc:mysql://140.119.19.73:9306/";
		String database = "TG06";
		String config= "?useUnicode=true&characterEncoding=utf8";
		url = server + database + config;
		username = "TG06"; 
		password = "i8p3q6";
		return DriverManager.getConnection(url, username, password);
	}
}