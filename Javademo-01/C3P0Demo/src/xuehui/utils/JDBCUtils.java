package xuehui.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import com.mchange.v2.c3p0.*;

public class JDBCUtils {
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
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);
		    conn=DriverManager.getConnection(url, userName, passWord);
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
	
	public static ComboPooledDataSource getPool(){
		ComboPooledDataSource pool=null;
		try {
			pool=new ComboPooledDataSource();
			pool.setDriverClass(driver);
			pool.setJdbcUrl(url);
			pool.setUser(userName);
			pool.setPassword(passWord);
			
			pool.setMinPoolSize(5);
			pool.setMaxPoolSize(20);
			pool.setAcquireIncrement(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pool;
	}
	
	public static void backConnection(ComboPooledDataSource combo) {
		combo.close();
	}
}
