package xuehui.Test;

import xuehui.DataSource.MyDataSource;
import xuehui.Utils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mchange.v2.c3p0.*;
import org.junit.Test;

public class LoginTest {
	
	public static void main(String[] args) {
		TestLogin();
	}
	@Test
	public void login() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ComboPooledDataSource cpds=JDBCUtils.getConnectionFromPool();
		try {
		    conn=cpds.getConnection();
			String sql="select * from userinfo where uid=? and uname=? and upwd=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setString(2, "root");
			pstmt.setString(3,"root");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.realseFromPool(cpds);
		}
	}
	
	
	public static void TestLogin() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MyDataSource ms=new MyDataSource();
		try {
		  conn=ms.getConnection();
		  String sql="select * from userinfo where uid=?";
		  pstmt=conn.prepareStatement(sql);
		  pstmt.setInt(1, 1);
		  rs= pstmt.executeQuery();
		  if(rs.next()) {
			  System.out.println(rs.getInt(1));
		  }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
