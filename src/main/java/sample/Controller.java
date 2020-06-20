package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.item.Items;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller implements Initializable{



    public TableView tableView;
    public TableColumn<Items,Integer> table_nrcrt;
    public TableColumn<Items,String> table_name;
    public TableColumn<Items,String> table_date;
    public TableColumn<Items,String> table_gramaj;
    public TableColumn<Items,String> table_pret;


    public int nrcrt;
    public ObservableList<Items> data = FXCollections.observableArrayList();



    public void onLogInAction(ActionEvent event) throws IOException
    {

        Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene baschetview = new Scene(login);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(baschetview);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try{
            Connection con = DBConector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from user");
            while(rs.next()){
                data.add(new Items(nrcrt++,rs.getString("Name"),rs.getString("Data Expirare"),rs.getString("Pret"),rs.getString("Gramaj")));

            }}catch(SQLException ex) {

            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }


        table_nrcrt.setCellValueFactory( new PropertyValueFactory<Items,Integer>("nr_crt"));
        table_name.setCellValueFactory(new PropertyValueFactory<Items,String>("name"));
        table_date.setCellValueFactory(new PropertyValueFactory<Items,String>("data_exp"));
        table_gramaj.setCellValueFactory(new PropertyValueFactory<Items,String>("pret"));
        table_pret.setCellValueFactory(new PropertyValueFactory<Items,String>("gramaj"));

        tableView.setItems(data);
    }
}