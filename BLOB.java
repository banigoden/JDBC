import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.sql.*;
import java.sql.Connection;

public class BLOB {

    public void blob() throws ClassNotFoundException, SQLException {

        String name ="root";
        String pass = "199106baN";
        String connUrl = "jdbc:mysql://localhost:3306/mysql";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connUrl, name, pass)) {

            System.out.println("We are connected");        ///////// write
            Statement statement = connection.createStatement();
            statement.execute("drop table TableA");
            statement.executeUpdate("create TABLE IF NOT EXISTS TableA(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL,  PRIMARY KEY(id));");
            statement.executeUpdate("insert into TableA(name) values('apple'),('pineapple'),('banan'),('pear')");


            statement.execute("drop table TableB");
            statement.executeUpdate("create TABLE IF NOT EXISTS TableB(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NULL, PRIMARY KEY(id));");
            statement.executeUpdate("insert into TableB(name) values('pineapple'),('apple'),('melon'),('banan')");

            ResultSet resultSet = statement.executeQuery("select * from TableA inner join TableB ON TableA.name = TableB.name");

            while(resultSet.next()){

                System.out.println(resultSet.getString(2));
            }
            System.out.println("-------------------");

            ResultSet resultSet1 = statement.executeQuery("select * from TableB left outer join TableA on TableA.name = TableB.name ");

            while (resultSet1.next()){

                System.out.println(resultSet1.getString(4));

            }
            statement.executeUpdate("alter table TableB ADD shelf_life CHAR(30) null");
            System.out.println("-------------------");

            statement.executeUpdate("insert into TableB(shelf_life) values('3'),('5'),('1'),('1')");

            ResultSet resultSet2 = statement.executeQuery("select  * from TableB order by shelf_life ASC ");

            while (resultSet2.next()){

                System.out.println(resultSet2.getString(3));
            }
    /// select distinct name from TableB;
            System.out.println("-------------------");
            ResultSet resultSet3 = statement.executeQuery("select  max(shelf_life) as Maximum from TableB group by name");

            while (resultSet3.next()){

                System.out.println(resultSet3.getString(1));
            }
        }

    }
}
