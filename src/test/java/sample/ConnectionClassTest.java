package sample;

import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClassTest extends TestCase {



    @Test
    public void testGetConnection() throws SQLException {
        String sql = "INSERT INTO USER VALUES('" + "TEST" + "' , '" + "TEST" + "' , '" + "TEST" + "' , '" + "TEST" + "')";
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);

        ConnectionClass connectionx = new ConnectionClass();
        Connection connectiony = connectionx.getConnection();
        Statement myStatements = connectiony.createStatement();
        ResultSet myResult = myStatements.executeQuery("select * from user");
        boolean test = false;
        while(myResult.next())
        {
            System.out.println(myResult.getString("Name"));
            if(!test)
                test = myResult.getString("Name").equals("TEST");

        }
        assertTrue(test);
    }
}