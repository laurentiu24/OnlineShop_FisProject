package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaschetController {
    public TextField nume;
    public TextField dataexpirare;
    public TextField pret;
    public TextField gramaj;

    public void ExitEvent(ActionEvent event)throws IOException{

        Parent login = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene baschetview = new Scene(login);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(baschetview);
        window.show();

    }


    public void AddProduct(ActionEvent event) throws SQLException {
        String Denumire;
        boolean sw= true;
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            Statement myStatement = connection.createStatement();
            ResultSet myResult = myStatement.executeQuery("select * from user");

            while (myResult.next()) {
                Denumire=myResult.getString("Name");
                if(Denumire.equals(nume.getText()))
                    sw=false;

            } }catch(Exception exe){exe.printStackTrace();}
    if(sw) {

        String sql = "INSERT INTO USER VALUES('" + nume.getText() + "' , '" + dataexpirare.getText() + "' , '" + pret.getText() + "' , '" + gramaj.getText() + "')";
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    }

}
