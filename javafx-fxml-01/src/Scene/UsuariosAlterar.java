package Scene;

import Controller.LoginController;
import Controller.UsuariosController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UsuariosAlterar extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loaderUsuario = new FXMLLoader(this.getClass().getResource("layoutUsuarioAlterar.fxml"));

        //LoginController loginController = new LoginController();
        //loaderUsuario.setController(loginController);

        UsuariosController usuariosController = new UsuariosController();
        loaderUsuario.setController(usuariosController);

        Parent root = loaderUsuario.load();

        stage.setTitle("Alterar/Listar Usuário");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
