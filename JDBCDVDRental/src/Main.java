import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Application application = new Application();

        Connection connection = DriverManager.getConnection(Application.url, Application.userName, Application.password);

        System.out.println(connection);
    }
}