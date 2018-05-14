package zuehui.test;

import org.junit.Test;
import xuehui.utils.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {
    @Test
    public void testAdd(){
        Connection conn=null;
        PreparedStatement pstmt;
        ResultSet rs=null;
        try{
            conn=MyDataSource.getConnection();
            String sql="insert into userinfo select null,?,?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"我是张三");
            pstmt.setString(2,"root");
            int r=pstmt.executeUpdate();
            if(r>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void testDel(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            conn=MyDataSource.getConnection();
            String sql="delete from userinfo where uid=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,1);
            int n=pstmt.executeUpdate();
            if(n>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testEdit(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            conn=MyDataSource.getConnection();
            String sql="update userinfo set uName=? where uid=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"Test Edit");
            pstmt.setInt(2,3);
            int n=pstmt.executeUpdate();
            if(n>0){
                System.out.println("修改成功");
            }else
            {
                System.out.println("修改失敗");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testSelect(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=MyDataSource.getConnection();
            String sql="select * from userinfo";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                System.out.println("uId="+rs.getInt(1)+",uName="+rs.getString(2)+"uPwd="+
                rs.getString(3));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
