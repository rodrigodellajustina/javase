package scenes;

import db.SQLite;
import entitites.Cadastros;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.sql.SQLException;


public class Login extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Alert alertSenhaIncorreta = new Alert(Alert.AlertType.ERROR, "Senha ou usuário incorretos");
        Label lbUsuario = new Label("Usuário ");
        Label lbSenha   = new Label("Senha ");
        TextField tfUsuario = new TextField();
        PasswordField tfSenha = new PasswordField();
        Button btlogar = new Button("Logar");

        /*Evento Logar*/
        EventHandler<ActionEvent> eventoLogar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Cadastros usuarioLogin = new Cadastros();
                /*Capturar o Usuário*/
                usuarioLogin.setEmail(tfUsuario.getText());

                /*Captuar a Senha*/
                usuarioLogin.setSenha(tfSenha.getText());

                /*Verificar usuário login e senha no banco de dados*/
                try{
                    SQLite dbUsuario = new SQLite();
                    if (dbUsuario.usuarioLogin(usuarioLogin)){

                        CadastroListar cadastroListar = new CadastroListar();
                        try {
                            cadastroListar.start(new Stage());
                            stage.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        alertSenhaIncorreta.show();
                    }
                }catch (SQLException | ClassNotFoundException e){
                    e.printStackTrace();
                }


            }
        };


        btlogar.setOnAction(eventoLogar);

        TilePane tpLogin = new TilePane();
        tpLogin.getChildren().add(lbUsuario);
        tpLogin.getChildren().add(tfUsuario);
        tpLogin.getChildren().add(lbSenha);
        tpLogin.getChildren().add(tfSenha);
        tpLogin.getChildren().add(btlogar);


        Scene sceneLogin = new Scene(tpLogin, 300, 200);
        stage.setScene(sceneLogin);
        stage.setTitle("Login");
        stage.show();

    }

    public static void begin(){
        launch();
    }
}
