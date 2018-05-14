package xuehui.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xuehui.Utils.*;

public class TestLogin {
	public static void main(String[] args) {
		EditUser();
	}
    public void Login(String name,String passWord) throws ClassNotFoundException, SQLException {
       //注册驱动
       Class.forName("com.mysql.jdbc.Driver");
       //获取连接
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "root");
       
       String sql="select * from userinfo";
       
       PreparedStatement pstmt=conn.prepareStatement(sql);
       
       ResultSet rs= pstmt.executeQuery();
       
      if(rs.next()) {
    	  System.out.println(rs.getString(1)+rs.getString(2));
      }
      
      if(rs!=null) rs.close();
      if(pstmt!=null) pstmt.close();
      if(conn!=null) conn.close();
    }
    
    public static void AddUser() {
    	Connection conn=null;
    	PreparedStatement pstmt=null;
    	try {
    	//获取连接
        conn=JDBCUtil.getConnection();
        String sql="insert into userinfo select null,?,?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,"lisi");
        pstmt.setString(2, "123");
        
        int r= pstmt.executeUpdate();
        
        if(r>0) {
        	System.out.println("success");
        }else {
        	System.out.println("fail");
        }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		JDBCUtil.realse(conn, pstmt, null);
    	}
    }
    
    public static void EditUser() {
    	Connection conn=null;
    	PreparedStatement pstmt=null;
    	try {
    	conn=JDBCUtil.getConnection();
    	String sql="update userinfo set uname=? where uid=?";
    	pstmt=conn.prepareStatement(sql);
    	pstmt.setString(1,"zhangsan");
    	pstmt.setInt(2, 2);
       int r=pstmt.executeUpdate();
       if(r>0) {
    	   System.out.println("Success");
       }else {
    	   System.out.println("fail");
       }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
