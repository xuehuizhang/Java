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
}
