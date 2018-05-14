package xuehui.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;  
import org.apache.commons.dbutils.QueryRunner;  
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import xuehui.Utils.ConnectDb;
import xuehui.Beans.UserBean;

public class JDBCUtils {
	private static Connection conn=ConnectDb.GetConnection();
	
	public static void main(String[] args) throws SQLException {
		//insertTest();
		//selectTest();
		//updateTest();
		deleteTest();
	}
	
	
	public  static void insertTest() {
		//创建sql执行工具
		QueryRunner qRunner=new QueryRunner();
		try {
		qRunner.update(conn,"insert into userinfo select null,'lisi','1234'");
		System.out.println("插入成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
	}
	
	public static void selectTest() throws SQLException {
		QueryRunner qRunner=new QueryRunner();
		@SuppressWarnings("unchecked")
	    List<UserBean> list=(List<UserBean>)qRunner.query(conn, "select uid,uname,upwd from userinfo",new BeanListHandler(UserBean.class));
		
		for(UserBean u:list) {
			System.out.println("id="+u.getUId()+"name="+u.getUName()+"pwd="+u.getUPwd());
		}
		DbUtils.closeQuietly(conn);
	}
	
	public static void updateTest() {
		QueryRunner qRunner=new QueryRunner();
		try {
		qRunner.update(conn,"update userinfo set uname='haha' where uid=1");
		}catch(Exception e) {
			System.out.println("修改成功");
			e.printStackTrace();
		}
		DbUtils.closeQuietly(conn);
	}
	
	public static void deleteTest() {
		QueryRunner qRunner=new QueryRunner();
		try {
		qRunner.update(conn,"delete from userinfo where uid=2");
		System.out.println("删除成功");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
