package Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    Button btLogar;
    Button btCancelar;

    @FXML
    public void clickLogar(Event e){
        Alert alertLogar = new Alert(Alert.AlertType.INFORMATION, "Clicou no botão logar");
        alertLogar.show();
    }

    @FXML
    public void clickCancelar(Event e){
        Alert alertCancelar = new Alert(Alert.AlertType.INFORMATION, "Clicou no botão cancelar");
        alertCancelar.show();
    }
}
