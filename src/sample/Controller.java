package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private ImageView glav_image_locations_forest;

    @FXML
    private ImageView glav_image_locations_mountains;

    @FXML
    private ImageView glav_image_locations_foothill;

    @FXML
    private ImageView glav_image_locations_darkforest;

    @FXML
    private ImageView glav_image_locations_glade;

    @FXML
    private Button glav_button_;

    @FXML
    private Button glav_button_hunting;

    @FXML
    private Button glav_button_inventar;

    @FXML
    private Label glav_label_lvl;

    @FXML
    private TextArea glav_textarea;

    @FXML
    private Label glav_label_bafs;

    @FXML
    private Label glav_label_parameters;

    @FXML
    private Button glav_button_location_one;

    @FXML
    private Button glav_button_location_two;

    @FXML
    private Button glav_button_location_three;

    TimeWindowController timeWindowController = new TimeWindowController();


    public void lock_forest(){  //Локация лес

        goingTimeout();

        System.out.println("forest");
        glav_textarea.appendText("Лес");
        glav_image_locations_forest.setVisible(true);

        glav_button_location_one.setVisible(true);
        glav_button_location_two.setVisible(true);
        glav_button_location_three.setVisible(true);

        glav_button_location_one.setText("Поляна");
        glav_button_location_two.setText("Предгорье");
        glav_button_location_three.setText("Тёмный лес");

        glav_button_location_one.setOnAction(new EventHandler<ActionEvent>() {  //Переход к поляне
            @Override
            public void handle(ActionEvent event) {
                glav_image_locations_forest.setVisible(false);
                lock_glade();
            }
        });

        glav_button_location_two.setOnAction(new EventHandler<ActionEvent>() {  //Переход к предгорью
            @Override
            public void handle(ActionEvent event) {
                glav_image_locations_forest.setVisible(false);
                lock_foothill();
            }
        });

        glav_button_location_three.setOnAction(new EventHandler<ActionEvent>() {    //Переход в тёмный лес
            @Override
            public void handle(ActionEvent event) {
                glav_image_locations_forest.setVisible(false);
                lock_darkforest();
            }
        });

    }

    public void lock_foothill(){    //Локация предгорье

        goingTimeout();

        System.out.println("foothill");
        glav_textarea.appendText("Предгорье");
        glav_image_locations_foothill.setVisible(true);

        glav_button_location_one.setVisible(true);
        glav_button_location_two.setVisible(true);
        glav_button_location_three.setVisible(false);

        glav_button_location_one.setText("Горы");
        glav_button_location_two.setText("Лес");

        glav_button_location_one.setOnAction(new EventHandler<ActionEvent>() {  //Переход в горы
            @Override
            public void handle(ActionEvent event) {
                glav_image_locations_foothill.setVisible(false);
                lock_mountains();
            }
        });

        glav_button_location_two.setOnAction(new EventHandler<ActionEvent>() {  //Переход в лес
            @Override
            public void handle(ActionEvent event) {
                glav_image_locations_foothill.setVisible(false);
                lock_forest();
            }
        });

    }

    public void lock_darkforest(){  //Локация Тёмный лес

        System.out.println("darkforest");
        glav_textarea.setText("Тёмный лес");
        glav_image_locations_darkforest.setVisible(true);

        glav_button_location_one.setText("Лес");

        glav_button_location_two.setVisible(false);
        glav_button_location_three.setVisible(false);

        glav_button_location_one.setOnAction(new EventHandler<ActionEvent>() {  //Переход в лес
            @Override
            public void handle(ActionEvent event) {
                glav_image_locations_darkforest.setVisible(false);
                lock_forest();
            }
        });

    }

    public void lock_glade(){   //Локация поляна

        System.out.println("glade");
        glav_textarea.setText("Поляна");
        glav_image_locations_glade.setVisible(true);

        glav_button_location_one.setText("Лес");

        glav_button_location_two.setVisible(false);
        glav_button_location_three.setVisible(false);

        glav_button_location_one.setOnAction(new EventHandler<ActionEvent>() {  //Переход в лес
            @Override
            public void handle(ActionEvent event) {
                glav_image_locations_glade.setVisible(false);
                lock_forest();
            }
        });

    }

    public void lock_mountains(){   //Локация горы

        System.out.println("mountains");
        glav_textarea.setText("Горы");
        glav_image_locations_mountains.setVisible(true);

        glav_button_location_one.setText("Предгорье");

        glav_button_location_two.setVisible(false);
        glav_button_location_three.setVisible(false);

        glav_button_location_one.setOnAction(new EventHandler<ActionEvent>() {  //Переход в лес
            @Override
            public void handle(ActionEvent event) {
                glav_image_locations_mountains.setVisible(false);
                lock_foothill();
            }
        });
    }

    public void goingTimeout(){

        disableButtons();

            for (int i = 5; i > 0; i--) {
                glav_textarea.appendText("До перехода на следующую локацию осталось: " + i + " секунд.");
            }

        activatedButtons();
    }

    public void disableButtons(){

        glav_button_location_one.setDisable(true);
        glav_button_location_two.setDisable(true);
        glav_button_location_three.setDisable(true);
        glav_button_hunting.setDisable(true);
        glav_button_inventar.setDisable(true);
        glav_button_.setDisable(true);

    }

    public void activatedButtons(){
        glav_button_location_one.setDisable(false);
        glav_button_location_two.setDisable(false);
        glav_button_location_three.setDisable(false);
        glav_button_hunting.setDisable(false);
        glav_button_inventar.setDisable(false);
        glav_button_.setDisable(false);
    }

    public void timeOneSec() {



    }

}
