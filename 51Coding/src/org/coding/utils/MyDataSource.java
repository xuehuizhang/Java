package org.coding.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyDataSource {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getCurrentConnection() {
		Connection conn=tl.get();
		if(conn==null) {
		 conn=getConnection();	
		 tl.set(conn);
		}
		return conn;
	}
	
	public static void commit() throws SQLException {
		Connection conn=getCurrentConnection();
		conn.commit();
		conn.close();
		tl.remove();
	}
	
	public static void rollback() throws SQLException {
		Connection conn=getCurrentConnection();
		conn.rollback();
	}
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
		}catch(Exception  ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
