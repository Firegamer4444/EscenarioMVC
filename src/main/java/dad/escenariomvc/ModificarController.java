package dad.escenariomvc;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModificarController implements Initializable {

    // model

    private IntegerProperty value = new SimpleIntegerProperty();
    private IntegerProperty tempValue = new SimpleIntegerProperty();

    // view

    @FXML
    private VBox root;

    @FXML
    private TextField valueText;

    public ModificarController(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModificarView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valueText.textProperty().bindBidirectional(tempValue , new NumberStringConverter());
    }

    public VBox getRoot(){
        return root;
    }

    @FXML
    private void onSetAction(ActionEvent event){
        System.out.println("set");
        setValue(tempValue.getValue());
    }

    @FXML
    private void onDecrementAction(ActionEvent event) {
        System.out.println("decrementar");
        setValue(getValue() - 1);
    }

    @FXML
    private void onIncrementAction(ActionEvent event) {
        System.out.println("incrementar");
        setValue(getValue() + 1);
    }

    public int getValue() {
        return value.get();
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public void setValue(int value) {
        this.value.set(value);
    }

}
