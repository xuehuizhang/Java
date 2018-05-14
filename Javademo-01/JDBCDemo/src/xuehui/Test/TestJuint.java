package xuehui.Test;

import java.sql.SQLException;

import org.junit.Test;
import xuehui.Test.TestLogin;


public class TestJuint {
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		TestLogin tl=new TestLogin();
		tl.AddUser();
	}
}
