import java.sql.*;
import java.sql.Connection;

public class InjectionAndPrepeareSt {



    public void print() throws ClassNotFoundException, SQLException {

        String name ="root";
        String pass = "";
        String connUrl = "jdbc:mysql://localhost:3306/mysql";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connUrl, name, pass)) {

            System.out.println("We are connected");        ///////// write
            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table Users");
            statement.executeUpdate("create TABLE IF NOT EXISTS Users(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(30) NOT NULL, PRIMARY KEY(id));");
            statement.executeUpdate("insert into Users(name, password) values('Den', '2531ee')");
            statement.executeUpdate("insert into Users set name = 'otherBoy', password = 'sdasfasf'");
        String userId = "1 'or 1 = '1"; //sql Injection
//            ResultSet resultSet = statement.executeQuery("select * from Users where id = ' " + userId + " ' ");
//            while (resultSet.next()){
//                System.out.println("userName: " + resultSet.getString("name"));
//                System.out.println("userPassword: " + resultSet.getString("password"));
//            }


           // String userId = "1";
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Users where id =?");
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println("userName: " + resultSet.getString("name"));
                System.out.println("userPassword: " + resultSet.getString("password"));
            }
        }


    }

}
