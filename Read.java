import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {

    private Statement statement;
    public Read(Statement statement) {

        this.statement = statement;
    }

    public void read() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from Books");    /////////// read

        while(resultSet.next()){

            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }

        ResultSet resultSet1 = statement.executeQuery( "select name from Books where id = 1");

        while (resultSet1.next()){

            System.out.println(resultSet1.getString(1));
        }

    }
}
