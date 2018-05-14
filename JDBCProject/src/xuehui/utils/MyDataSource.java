package xuehui.utils;

import com.mchange.v2.c3p0.*;

import javax.sql.DataSource;
import java.sql.Connection;

public class MyDataSource {
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();

    public  static DataSource getDataSource(){
        return dataSource;
    }

    public  static Connection getConnection(){
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  conn;
    }
}