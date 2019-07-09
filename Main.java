import java.sql.*;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        String name ="root";
//        String pass = "";
//        String connUrl = "jdbc:mysql://localhost:3306/mysql";
//        Class.forName("com.mysql.jdbc.Driver");
//        try(Connection connection = DriverManager.getConnection(connUrl, name, pass)){
//
//            System.out.println("We are connected");        ///////// write
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("drop table Users");
//            statement.executeUpdate("create TABLE IF NOT EXISTS Users(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(30) NOT NULL, PRIMARY KEY(id));");
//            statement.executeUpdate("insert into Users(name, password) values('Den', '2531ee')");
//            statement.executeUpdate("insert into Users set name = 'otherBoy', password = 'sdasfasf'");sdasfasf

            //Read read = new Read(statement);
//            InjectionAndPrepeareSt injectionAndPrepeareSt = new InjectionAndPrepeareSt();
//            injectionAndPrepeareSt.print();
        Data data = new Data();
        data.test();


    }



    // /usr/local/mysql/bin
    //SET GLOBAL time_zone = '+3:00';
    //create TABLE IF NOT EXISTS Books(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY(id))
}
