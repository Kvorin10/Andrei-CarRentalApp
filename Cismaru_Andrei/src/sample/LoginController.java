package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {


    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button resetButton;
    @FXML
    private Label statusLabel;

    public void Login(ActionEvent event) throws IOException {

        if(userTextField.getText().equals("user") && passTextField.getText().equals("pass")){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("marketplace.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        }else{
            statusLabel.setText("Error");
        }

    }

    public void Clear(ActionEvent event){
        if (event.getSource()==resetButton){
            userTextField.setText("");
            passTextField.setText("");
            statusLabel.setText("");
        }
    }

}
