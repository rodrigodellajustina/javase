package scenes;


import db.SQLite;
import entitites.Cadastros;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

public class CadastroListar extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        /*Declaração da Table View*/
        TableView tableUsuario = new TableView();

        /*Declaração das Colunas da minha TableView*/
        TableColumn<Cadastros, String> tcNome = new TableColumn<>("Nome");
        TableColumn<Cadastros, String> tcEmail = new TableColumn<>("E-mail");

        /*Nome das Celulas de Controle ADICIONANDO*/
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        /*Vinculo entre TableView e a TableColumn*/
        tableUsuario.getColumns().add(tcNome);
        tableUsuario.getColumns().add(tcEmail);

        /*Add os valores na celulas*/
        SQLite dbUsuario = new SQLite();
        for (Cadastros cad1 : dbUsuario.getUsuarios()){
            tableUsuario.getItems().add(cad1);
        }

        VBox vbox = new VBox(tableUsuario);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public static void begin(){
        launch();
    }
}
