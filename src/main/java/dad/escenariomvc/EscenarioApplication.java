package dad.escenariomvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EscenarioApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ModificarController modificarController = new ModificarController();

        VerController verController = new VerController();

        Stage modificarStage = new Stage();
        modificarStage.setScene(new Scene(modificarController.getRoot()));
        modificarStage.setTitle("Modificar");
        modificarStage.show();

        Stage verStage = new Stage();
        verStage.setScene(new Scene(verController.getRoot()));
        verStage.setTitle("Ver");
        verStage.show();

        verController.valueProperty().bind(modificarController.valueProperty());
    }
}
