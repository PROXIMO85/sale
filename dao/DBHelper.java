package az.orient.satish.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DBHelper {
    public static Connection getConnection()throws Exception{
        Context context= new InitialContext();
        DataSource dataSource= (DataSource) context.lookup("java:comp/env/jdbc/satish");
        Connection c=dataSource.getConnection();

        return c;
    }
}
