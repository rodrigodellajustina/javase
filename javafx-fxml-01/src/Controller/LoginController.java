package Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    Button btLogar;
    @FXML
    Button btCancelar;
    @FXML
    TextField tfUsuario = null;
    @FXML
    TextField tfSenha = null;
    

    @FXML
    public void clickLogar(Event e){
        String usuario = tfUsuario.getText();
        String senha = tfSenha.getText();
        Alert alertLogar = new Alert(Alert.AlertType.INFORMATION, "Clicou no botão logar " + usuario + " " + senha);
        alertLogar.show();
    }

    @FXML
    public void clickCancelar(Event e){
        tfUsuario.setText("");
        tfSenha.setText("");
        Alert alertCancelar = new Alert(Alert.AlertType.INFORMATION, "Clicou no botão cancelar");
        alertCancelar.show();
    }
}
