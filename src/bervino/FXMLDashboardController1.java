/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bervino;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author AdityaHarisCandra
 */
public class FXMLDashboardController1 implements Initializable {
    
    
    @FXML
    private JFXTextField nb;

    @FXML
    private JFXTextField nl;

    @FXML
    private JFXTextField np;

    @FXML
    private JFXButton btnadd;

    @FXML
    private JFXButton btnclr;

    @FXML
    private JFXTextField admin;
    
    @FXML
    private JFXDatePicker tp;
    
    private ObservableList<TableData> data;
    
    @FXML
    private Label atas;
    @FXML
    private TableView<TableData> table;
    @FXML
    private TableColumn<TableData, String> namabarang;
    @FXML
    private TableColumn<TableData, String> kodebarang;
    @FXML
    private TableColumn<TableData, String> noloker;
    @FXML
    private TableColumn<TableData, String> tgl;
    @FXML
    private TableColumn<TableData, String> nama;
    @FXML
    private JFXButton clr1;
    
     Connection con;
    Statement stat;
    ResultSet rs;
    String sql;

    @FXML
    void add(ActionEvent event) {
        
        try {
            String sql = "INSERT INTO `login`(`username`, `password`, `nama`, `harga`, `kode`, `tanggal`, `waktu`) VALUES "
                    + "('"+nb.getText()+"','"+nl.getText()+"','"+tp.getValue().toString()+"','"+np.getText()+"')";
            
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm; 
    }

    @FXML
    private void clr2(ActionEvent event) {
        admin.setText("");
        nb.setText("");
        nl.setText("");
        tp.setValue(null);
        np.setText("");
        
    }
    
    @FXML
    void clr(ActionEvent event) {
        admin.setText("");
        nb.setText("");
        nl.setText("");
        tp.setValue(null);
        np.setText("");

    }
    
        @FXML
    void update(ActionEvent event) {
        
        try {
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM barang");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new TableData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        namabarang.setCellValueFactory(new PropertyValueFactory<>("nb"));
        kodebarang.setCellValueFactory(new PropertyValueFactory<>("kb"));
        noloker.setCellValueFactory(new PropertyValueFactory<>("nl"));
        tgl.setCellValueFactory(new PropertyValueFactory<>("tgl"));
        nama.setCellValueFactory(new PropertyValueFactory<>("np"));
        
        table.setItems(null);
        table.setItems(data);


    }
}
    

