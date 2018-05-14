package xuehui.utils;

import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyDbUtils {
    private static DataSource dataSource=MyDataSource.getDataSource();
    private static Connection conn=MyDataSource.getConnection();
    public  static  void  main(String[] args){
        String sql="insert into userinfo select null,?,?";
        String[] arr=new String[]{"lisiya","124"};
        try {
           int n= insertTest(sql, arr);
           System.out.println(n);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  static  int insertTest(String sql,Object[] params) throws SQLException {
        QueryRunner qr=new QueryRunner(dataSource);
        return qr.update(sql,params);
    }

    public  static  int delTest(String sql,Object[] params) throws SQLException {
        QueryRunner qr=new QueryRunner();
        return qr.update(conn,sql,params);
    }
}
