package Controller;

import Scene.Clientes;
import db.SQLite;
import entities.Estado;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ClientesController {

    @FXML
    TextField tfNomeCliente;

    @FXML
    TextField tfCidadeCliente;

    @FXML
    ComboBox cbEstadoCliente;

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {
        SQLite db = new SQLite();
        for (Estado cadEstado : db.getEstados()){
            cbEstadoCliente.getItems().add(cadEstado.getUf());
        }
        //cbEstadoCliente.getItems().addAll("PR", "RJ", "SP");
    }

    @FXML
    public void clickCadastrarCliente(Event e) throws Exception {
        Clientes clientes = new Clientes();
        clientes.start(new Stage());
    }



}
