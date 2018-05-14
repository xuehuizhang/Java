package xuehui.Utils;

import java.util.ResourceBundle;

import org.omg.CORBA.SystemException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectDb {
	private static String driver;
	private static String url;
	private static String userName;
	private static String passWord;
	
	static {
		ResourceBundle bundle=ResourceBundle.getBundle("db");
		driver=bundle.getString("driver");
		url=bundle.getString("url");
		userName=bundle.getString("username");
		passWord=bundle.getString("password");
	}
	
	public static Connection GetConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			System.out.println(" class not found");
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection(url, userName, passWord);
		}catch(SQLException e) {
			System.out.println("connect failed");
			e.printStackTrace();
		}
		return conn;
	}
}
