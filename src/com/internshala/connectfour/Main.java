package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
     private Controller controller ;
    @Override
    public void start(Stage primaryStage) throws Exception{
       FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=loader.load();
        controller= loader.getController();
        controller.createPlayground(); // for calling from controller createplayground..as we launch app  start and  this will be executed

           MenuBar menuBar=createMenu();   // this menubar will added to pane as child    down

        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());// whatever with of primary stage will width of menu bar

        Pane menuPane=(Pane) rootGridPane.getChildren().get(0);// to get menupane and add as child of gridpane
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);
         primaryStage.setScene(scene);
         primaryStage.setTitle("Connect Four");
         primaryStage.setResizable(false);
          primaryStage.show();
    }
    private MenuBar createMenu(){

        // getting file menu
        Menu fileMenu=new Menu("File");

        MenuItem newGame=new MenuItem("New Game");

        // to perform action on new game
        //private void resetGame() {   // creating a method
        newGame.setOnAction(event ->  controller.resetGame());
        MenuItem resetGame=new MenuItem("Reset Game");


        // for reset game
        resetGame.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem exitGame=new MenuItem("Exit Game");

        // seton action using lambda
        exitGame.setOnAction(event -> exitGame());

         fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);
         // help menu


        Menu helpMenu  =new Menu("Help");

        MenuItem aboutGame =new MenuItem("About Game");
        aboutGame.setOnAction(event -> AboutConnect4());
        SeparatorMenuItem separator=new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);   // without this it will not pop


        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu) ;  // for adding file menu and help me nu
      return menuBar;
    }

    private void aboutMe() {


         Alert alert =new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("About Developer");
        alert.setHeaderText("Satyam Choudhary");
        alert.setContentText("Connect 4 is Created keeping in Mind that from" +
                "Child to Adult Everyone Can enjoy this and Play and spend"+
                "Time with their nears and dears.");
        alert.show();

    }

    private void AboutConnect4() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);  // about game info
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play");
        alert.setContentText("Connect Four is a two-player connection game in which the"+
                "player first  choose a color and then take turn dropping colored Discs"+
                "from the top into a seven column,six row vertically suspended grid,"+
                "The pieces fall straight down,occupying the next available space within the column."+
                "the objective of the game is to be the first till form a horizontal,vertical,"+
                "or diagonal line of four of ones own discs.Connect Four is a solved game."+
                "The First player can always win by playing the right Moves.");
        alert.show();


    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);  // to exit the game when clicked
    }

    private void resetGame() {
    }

    public static void main(String[] args) {
        launch(args);
    }
}
