package scenes;


import db.SQLite;
import entitites.Cadastros;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class CadastroListar extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        /*Declaração da Table View*/
        TableView tableUsuario = new TableView();
        Alert alertEliminar = new Alert(Alert.AlertType.INFORMATION, "Eliminação de Usuário");
        Label lbFiltro = new Label("Pesquisa");
        TextField tfFiltro = new TextField();
        Button btFiltrar = new Button("Pesquisa");
        Button btMostrarTodos = new Button("Exibir Todos");

        /*Declaração das Colunas da minha TableView*/
        TableColumn<Cadastros, String> tcNome = new TableColumn<>("Nome");
        TableColumn<Cadastros, String> tcEmail = new TableColumn<>("E-mail");


        /*Nome das Celulas de Controle ADICIONANDO*/
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        Button btEliminar = new Button("Eliminar");

        /*Vinculo entre TableView e a TableColumn*/
        tableUsuario.getColumns().add(tcNome);
        tableUsuario.getColumns().add(tcEmail);


        /*Add os valores na celulas*/
        SQLite dbUsuario = new SQLite();
        for (Cadastros cad1 : dbUsuario.getUsuarios()){
            tableUsuario.getItems().add(cad1);
        }

        EventHandler<ActionEvent> eventoEliminar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tableUsuario.getSelectionModel().getSelectedItems().size() == 0){
                    // não é possível eliminar favor selecionar uma linha...
                    alertEliminar.setContentText("Não foi possível eliminar, selecione um usuário");
                }else {
                    Object usuarioEliminar = tableUsuario.getSelectionModel().getSelectedItems().get(0);
                    Cadastros eliminarCadastro = new Cadastros();
                    String email = ((Cadastros) usuarioEliminar).getEmail();
                    eliminarCadastro.setEmail(email);

                    try {
                        SQLite dbUsuarios = new SQLite();
                        dbUsuarios.eliminarUsuario(eliminarCadastro);
                        /*Table View*/
                        tableUsuario.getItems().clear();

                        for (Cadastros cad1 : dbUsuario.getUsuarios()){
                            tableUsuario.getItems().add(cad1);
                        }
                    }catch (SQLException | ClassNotFoundException e){
                        e.printStackTrace();
                    }

                    alertEliminar.setContentText("Usuário eliminado");
                }
                alertEliminar.show();
            }
        };

        EventHandler<ActionEvent> eventoFiltrar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    SQLite dbUsuarios = new SQLite();
                    /*Table View*/
                    tableUsuario.getItems().clear();

                    for (Cadastros cad1 : dbUsuario.getUsuariosFiltro(tfFiltro.getText())){
                        tableUsuario.getItems().add(cad1);
                    }
                }catch (SQLException | ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        };

        EventHandler<ActionEvent> eventoMostrarTodos = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(tfFiltro.getText());
                try {
                    SQLite dbUsuarios = new SQLite();
                    /*Table View*/
                    tableUsuario.getItems().clear();

                    for (Cadastros cad1 : dbUsuario.getUsuarios()){
                        tableUsuario.getItems().add(cad1);
                    }
                }catch (SQLException | ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        };


        btEliminar.setOnAction(eventoEliminar);
        btFiltrar.setOnAction(eventoFiltrar);
        btMostrarTodos.setOnAction(eventoMostrarTodos);

        TilePane tpCadastroListar = new TilePane();
        VBox vbox = new VBox(tableUsuario);
        tpCadastroListar.getChildren().add(vbox);
        tpCadastroListar.getChildren().add(lbFiltro);
        tpCadastroListar.getChildren().add(tfFiltro);
        tpCadastroListar.getChildren().add(btFiltrar);
        tpCadastroListar.getChildren().add(btEliminar);
        tpCadastroListar.getChildren().add(btMostrarTodos);

        Scene scene = new Scene(tpCadastroListar);
        stage.setScene(scene);
        stage.show();
    }

    public static void begin(){
        launch();
    }
}
