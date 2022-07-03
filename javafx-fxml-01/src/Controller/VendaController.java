package Controller;

import db.SQLite;
import entities.Cliente;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;


public class VendaController {

    @FXML
    private TextField tfCliente;

    @FXML
    private Label lbClienteSelecionado;

    public void clickProcurarCliente(Event e) throws SQLException, ClassNotFoundException {
        Integer codigo = Integer.parseInt(tfCliente.getText());

        SQLite db = new SQLite();
        Cliente cliente = (Cliente) db.getClienteforCodigo(codigo);

        lbClienteSelecionado.setText(cliente.getNome());

    }



}
