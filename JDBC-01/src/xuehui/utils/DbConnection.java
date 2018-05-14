package xuehui.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DbConnection {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static{
        ResourceBundle bundle=ResourceBundle.getBundle("db");
        driver=bundle.getString("driver");
        url=bundle.getString("url");
        username=bundle.getString("username");
        password=bundle.getString("password");
    }

    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
