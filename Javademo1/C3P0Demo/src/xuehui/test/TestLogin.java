package xuehui.test;

import org.junit.Test;

import xuehui.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestLogin {
	
	@Test
	public void Login() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select * from userinfo";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void Search() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getPool().getConnection();
			String sql="select * from userinfo";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("±‡∫≈£∫"+rs.getInt(1)+"–’√˚£∫"+rs.getString(2)+"√‹¬Î£∫"+rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
