package xuehui.datasource;

import com.mchange.v2.c3p0.*;
import javax.sql.DataSource;
import java.sql.Connection;


public class MyDataSource {
	private static	ComboPooledDataSource dataSource=new ComboPooledDataSource();
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
			return conn;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
