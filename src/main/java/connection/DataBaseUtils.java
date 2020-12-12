package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtils {
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/petclinic?serverTimezone=UTC";
    private String user = "root1";
    private String password = "Root123456";

    public DataBaseUtils() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("error in connection creating process");
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.connection;
    }
}
