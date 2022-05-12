package scenes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Agenda extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lbCompromisso = new Label("Compromisso");
        Label lbDataCompromisso = new Label("Data");
        TextField tfComprommisso = new TextField();
        DatePicker dtDataCompromisso = new DatePicker();
        Button btAgendar = new Button("Agendar");
        HBox hbAgendar = new HBox(btAgendar);

        Alert alertGeral = new Alert(Alert.AlertType.INFORMATION, "Informação");

        TilePane tpAgenda = new TilePane();
        tpAgenda.getChildren().add(lbCompromisso);
        tpAgenda.getChildren().add(tfComprommisso);
        tpAgenda.getChildren().add(lbDataCompromisso);
        tpAgenda.getChildren().add(dtDataCompromisso);
        tpAgenda.getChildren().add(hbAgendar);
        tpAgenda.getChildren().add(btAgendar);



        EventHandler<ActionEvent> eventoAgendar = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String sdtcompromisso = dtDataCompromisso.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                alertGeral.setContentText("Evento..: " + tfComprommisso.getText() + " Data..: " + sdtcompromisso);
                alertGeral.show();

            }
        };

        btAgendar.setOnAction(eventoAgendar);


        Scene scAgenda = new Scene(tpAgenda, 400, 400);
        primaryStage.setScene(scAgenda);
        primaryStage.setTitle("Agenda de Compromisso v1.0");
        primaryStage.show();


    }

    public void begin(){
        launch();
    }

}
