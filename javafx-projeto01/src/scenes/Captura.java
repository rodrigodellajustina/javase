package scenes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class Captura extends Application{

    public void start(Stage stage){

        stage.setTitle("Minha primeira aplicação usando JAVAFX");
        /*Declaração dos componentes da tua tela*/
        Label lbl1 = new Label("Informe seu nome");
        TextField tf1 = new TextField();
        HBox hbox1 = new HBox(tf1);
        Button btn1 = new Button("Confirmar");
        Alert alt1 = new Alert(Alert.AlertType.INFORMATION, "Clicou alertou ");

        /*Evento de Manipulação*/
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                alt1.setTitle("Teste");
                alt1.setContentText(tf1.getText());
                alt1.show();
            }
        };

        /*Defininando qual botão é responsável pela ação*/
        btn1.setOnAction(event);


        /*Atribuindo ao Pane quais são os compoentes exibidos*/
        TilePane tp1 = new TilePane();
        tp1.getChildren().add(lbl1);
        tp1.getChildren().add(hbox1);
        tp1.getChildren().add(btn1);

        /*Criando a Cena e definindo seu tamanho*/
        Scene sc1 = new Scene(tp1,800,600);
        stage.setScene(sc1);
        stage.show();

    }

    public void begin(){
        launch();
    }

}
