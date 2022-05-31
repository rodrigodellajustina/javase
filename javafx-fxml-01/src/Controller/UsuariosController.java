package Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class UsuariosController {

    @FXML
    TextField tfNomeCompleto;

    @FXML
    TextField tfEmail;

    @FXML
    TextField tfSenha;

    @FXML
    TextField tfConfirmarSenha;

    public void clickSalvarUsuario(Event e){
        Alert alertSalvarUsuario = new Alert(Alert.AlertType.INFORMATION, "Clicou no salvar do usuário");
        alertSalvarUsuario.show();
    }



}
