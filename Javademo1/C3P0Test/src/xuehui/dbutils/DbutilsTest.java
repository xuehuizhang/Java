package xuehui.dbutils;

import xuehui.datasource.*;

import java.util.List;

import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import xuehui.bean.*;

import org.junit.Test;

public class DbutilsTest {
	DataSource dataSource=MyDataSource.getDataSource();
	
	
	@Test
	public void searchTest() {
		QueryRunner qRunner=new QueryRunner(dataSource);
		try {
		@SuppressWarnings("unchecked")
	    List<UserBean>	list=(List<UserBean>)qRunner.query("select * from userinfo", new BeanListHandler(UserBean.class));
		for(UserBean item: list) {
			System.out.println(item.getUId());
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
