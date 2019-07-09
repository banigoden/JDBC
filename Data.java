import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Data {

    public void test() throws ClassNotFoundException ,SQLException{
        String name ="root";
        String pass = "";
        String connUrl = "jdbc:mysql://localhost:3306/mysql";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connUrl, name, pass)){

            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table Books");
            statement.executeUpdate("create TABLE IF NOT EXISTS Books(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, dt DATE, PRIMARY KEY(id));");

            PreparedStatement preparedStatement =  connection.prepareStatement("insert into Books (name, dt) values ('someNames',?)");
            preparedStatement.setDate(1, new Date(1242444346));
            preparedStatement.execute();
            System.out.println(preparedStatement);
            ResultSet resultSet = statement.executeQuery("select  * from Books");

            while (resultSet.next()){
                System.out.println(resultSet.getDate("dt"));
            }

            CallableStatement callableStatement = connection.prepareCall("{call BookCount(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));


 }
    }
}
