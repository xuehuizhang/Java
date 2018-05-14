package xuehui.zhang;

import org.junit.Test;

import xuehui.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
	@Test
	public void Search() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select * from userinfo";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("ÐÕÃû£º"+rs.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.realse(conn, pstmt, rs);
		}
	}
}
