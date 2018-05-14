package xuehui.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import java.util.LinkedList;
import java.sql.Connection;

import javax.sql.DataSource;

import xuehui.Utils.JDBCUtils;
import xuehui.Utils.MyConnection;

public class MyDataSource implements DataSource{

	private static LinkedList<Connection> pool=new LinkedList<Connection>();
	
	static {
		Connection conn=null;
		if(pool.size()==0) {
			for(int i=0;i<5;i++) {
				conn=JDBCUtils.GetConnection();
				MyConnection myConn=new MyConnection(conn,pool);
				pool.add(myConn);
			}
		}
	}
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn=null;
		if(pool.size()==0) {
			for(int i=0;i<5;i++) {
				conn=JDBCUtils.GetConnection();
				MyConnection myConn=new MyConnection(conn,pool);
				pool.add(myConn);
			}
		}
		conn=pool.removeFirst();
		return conn;
	}
	
	public void realse(Connection conn) {
		pool.add(conn);
	}
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
