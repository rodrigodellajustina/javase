package scenes;
import db.SQLite;
import entitites.Cadastros;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


import java.sql.ClientInfoStatus;
import java.sql.SQLException;

public class Cadastro extends Application {

    public void start(Stage stage) {
        /*Definição das propriedades*/
        Label lbnome = new Label("Nome");
        TextField tfnome = new TextField();
        HBox hbnome = new HBox(tfnome);
        Label lbemail = new Label("E-mail");
        TextField tfemail = new TextField();
        HBox hbemail = new HBox(tfemail);
        Label lbsenha = new Label("Senha");
        PasswordField tfsenha = new PasswordField();
        HBox hbsenha = new HBox(tfsenha);
        Button btConfirmar = new Button("Confirmar");
        HBox hbconfirmar = new HBox(btConfirmar);
        Button btListarUsuario = new Button("Listar");
        HBox hbListar = new HBox(btListarUsuario);
        Alert alertConfirmar = new Alert(Alert.AlertType.INFORMATION, "Usuário Confirmado");



        TilePane tpCadastro = new TilePane();
        tpCadastro.getChildren().add(lbnome);
        tpCadastro.getChildren().add(hbnome);
        tpCadastro.getChildren().add(lbemail);
        tpCadastro.getChildren().add(hbemail);
        tpCadastro.getChildren().add(lbsenha);
        tpCadastro.getChildren().add(hbsenha);
        tpCadastro.getChildren().add(btConfirmar);
        tpCadastro.getChildren().add(btListarUsuario);

        EventHandler<ActionEvent> eventoConfirmar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Cadastros novocadastro = new Cadastros();
                novocadastro.setNome(tfnome.getText());
                novocadastro.setEmail(tfemail.getText());
                novocadastro.setSenha(tfsenha.getText());

                try{
                    SQLite dbUsuarios = new SQLite();
                    dbUsuarios.insertUsuario(novocadastro);
                }catch (SQLException | ClassNotFoundException e){
                    e.printStackTrace();
                }

                alertConfirmar.show();
                tfnome.clear();
                tfemail.clear();
                tfsenha.clear();



            }
        };

        EventHandler<ActionEvent> eventoListar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CadastroListar cadastroListar = new CadastroListar();
                try {
                    cadastroListar.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        btConfirmar.setOnAction(eventoConfirmar);
        btListarUsuario.setOnAction(eventoListar);


        Scene scCadastro = new Scene(tpCadastro, 400, 400);
        stage.setScene(scCadastro);
        stage.setTitle("Projeto 2");
        stage.show();


    }

    public void begin(){
        launch();
    }

}
