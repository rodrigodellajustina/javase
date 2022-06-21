package Controller;

import db.SQLite;
import entities.Usuario;
import entities.Usuario2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Vector;

public class UsuariosAlterarController implements Initializable {

    @FXML
    private TableView<Usuario> twusuario;

    @FXML
    private TableColumn<Usuario, String> nomecol;

    @FXML
    private TextField tfnome;

    @FXML
    private TextField tfemail;

    @FXML
    private TableColumn<Usuario, String> emailcol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomecol.setCellValueFactory(
                new PropertyValueFactory<>("nome"));

        emailcol.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        try {
            twusuario.setItems(listaDeUsuarios());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private ObservableList<Usuario> listaDeUsuarios() throws SQLException, ClassNotFoundException {
        SQLite db = new SQLite();

        return FXCollections.observableArrayList();
    }

    public void teste(Event e){
        ObservableList selectedItems = twusuario.getSelectionModel().getSelectedItems();
        Usuario usuarioSelecionado = new Usuario();
        usuarioSelecionado.setNome(((Usuario) selectedItems.get(0)).getNome());
        usuarioSelecionado.setEmail(((Usuario) selectedItems.get(0)).getEmail());
        tfnome.setText(usuarioSelecionado.getNome());
        tfemail.setText(usuarioSelecionado.getEmail());
    }

}
