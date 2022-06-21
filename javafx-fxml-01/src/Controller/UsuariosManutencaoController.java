package Controller;

import db.SQLite;
import entities.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;

public class UsuariosManutencaoController implements Initializable {

    @FXML
    private TableView<Usuario> twusuario;

    @FXML
    private TableColumn<Usuario, String> nomecol;

    @FXML
    private TableColumn<Usuario, String> emailcol;

    @FXML
    private TextField tfnome;

    @FXML
    private TextField tfemail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomecol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));

        try {
            twusuario.setItems(listTodosUsuarios());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ObservableList<Usuario> listTodosUsuarios() throws SQLException, ClassNotFoundException {

        SQLite dbusuarios = new SQLite();

        return FXCollections.observableArrayList(dbusuarios.getAllUsuarios());
    }


}
