package xuehui.test;

import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import xuehui.datasource.*;

public class SearchTest {
	@Test
	public void SearTest() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		conn=MyDataSource.getConnection();
		String sql="select * from userinfo";
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			System.out.println("id="+rs.getInt(1));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
