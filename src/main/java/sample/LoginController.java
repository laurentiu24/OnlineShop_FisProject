package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField nume;
    public PasswordField parola;


    public void ExitAction(ActionEvent event) throws IOException
    {
        Parent login = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene baschetview = new Scene(login);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(baschetview);
        window.show();

    }
    public void LogInAction(ActionEvent event) throws IOException
    {
        if(nume.getText().equals("admin") && parola.getText().equals("admin"));
        {
        Parent login = FXMLLoader.load(getClass().getResource("Baschet.fxml"));
            Scene baschetview = new Scene(login);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(baschetview);
            window.show();

        }

    }

}
