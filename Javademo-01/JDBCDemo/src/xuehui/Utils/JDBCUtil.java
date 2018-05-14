package xuehui.Utils;

import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class JDBCUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		try {
		ResourceBundle bundle=ResourceBundle.getBundle("db");
		driver=bundle.getString("driver");
		url=bundle.getString("url");
		username=bundle.getString("username");
		password=bundle.getString("password");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void realse(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
