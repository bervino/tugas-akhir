package bervino;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLLoginController {

   
    @FXML
    private JFXButton daftar;
    @FXML
    private JFXButton login;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField username;


    @FXML
    private void masuk(ActionEvent event) throws IOException {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql;

        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = (Statement) DB.stm;
        if(username.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tulisan Username Anda");
        }
        else if(password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tulisan Password Anda");
        }
        else{
            try {
                sql = "SELECT * FROM `login` WHERE username='"+username.getText()+"' AND password='"+password.getText()+"'";
                rs = stat.executeQuery(sql);
                if(rs.next()){
                    if(username.getText().equals(rs.getString("username")) && password.getText().equals(rs.getString("password"))){
                        JOptionPane.showMessageDialog(null, "Berhasil Login");
                        // Hide this current window (if this is what you want)
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        
                        // Load the new fxml
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("FXMLHome.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        
                        // Create new stage (window), then set the new Scene
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("TomboLuwe");
                        stage.show();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Username Atau Password Salah");
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
  }
}