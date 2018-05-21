package xuehui.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import xuehui.domain.User;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

public class MyDataSource {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		try{
			conn=dataSource.getConnection();
			return conn;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	@Test
	public void getConnections() throws SQLException {
	   Connection conn=	getConnection();
	   QueryRunner qr=new QueryRunner(MyDataSource.getDataSource());
		String sql="select * from userinfo where uname=? and upwd=?";
		User user=null;
		try {
			user = qr.query(sql,new BeanHandler<User>(User.class),"lisi","123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user);
	}
}
