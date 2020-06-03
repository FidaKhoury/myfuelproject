package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class scrollbar extends StackPane 
{
	ScrollPane scrollPane = new ScrollPane();
    VBox vBox = new VBox();
    TextField aTextField = new TextField();
    Label aLabel = new Label("a Field");
    TextField aTextField2 = new TextField();
    Label aLabel2 = new Label("a Field2");
    TextField aTextField3 = new TextField();
    Label aLabel3 = new Label("a Field3");
    Button button = new Button("Press");

    public void start(Stage primaryStage) throws Exception 
    {
        setMaxSize(100, 50);
        vBox.setMaxSize(95, 45);
        vBox.getChildren().setAll(aLabel, aTextField, aLabel2, aTextField2, aLabel3, aTextField3, button);
        scrollPane.setContent(vBox);
        scrollPane.setPrefSize(95,45);
        getChildren().addAll(scrollPane);
    }
}