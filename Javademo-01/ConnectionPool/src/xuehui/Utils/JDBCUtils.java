package xuehui.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import com.mchange.v2.c3p0.*;

public class JDBCUtils {
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
	
	public static Connection GetConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);
		    conn=DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void realse(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
			
		}
		
	}

	public static ComboPooledDataSource getConnectionFromPool() {
		ComboPooledDataSource cpds=null;
		try{
	    cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver            
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/web08");
		cpds.setUser("root");                                  
		cpds.setPassword("root");                                  
		    
		cpds.setMinPoolSize(5);                                     
		cpds.setMaxPoolSize(20);
		cpds.setAcquireIncrement(5);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cpds;
	}
	
	public static void realseFromPool(ComboPooledDataSource cpds) {
		cpds.close();
	}
	
}
