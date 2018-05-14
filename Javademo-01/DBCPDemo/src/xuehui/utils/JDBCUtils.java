package xuehui.utils;

import javax.sql.DataSource;
import java.util.Properties;
import java.io.*;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtils {
	private  static Properties properties=new Properties();
	private static DataSource dataSource;
	
	static {
		try {
			FileInputStream is=new FileInputStream("db.properties");
			properties.load(is);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			dataSource=BasicDataSourceFactory.createDataSource(properties);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			conn.setAutoCommit(false);
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
