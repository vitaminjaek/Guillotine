import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.util.Arrays;
import java.util.Random;
import java.lang.IndexOutOfBoundsException;

/**
 * @author Minjae Kim <p>
 * A class that represents a simplified version of the game Guillotine
 */
public class Guillotine extends Application {
  
  // Keeping track of player 1 and 2's scores
  private int player1Score = 0;
  private int player2Score = 0;
  
  // Keeping track of player 1 and 2's card types
  private int churchCards1 = 0;
  private int civicCards1 = 0;
  private int commonerCards1 = 0;
  private int palaceGuardCards1 = 0;
  private int churchCards2 = 0;
  private int civicCards2 = 0;
  private int commonerCards2 = 0;
  private int palaceGuardCards2 = 0;
  
  // Number of cards to start with
  private static int numOfCards = 20;
  
  /**
   * Method that randomly shuffles the elements in an array
   * @param array The array that gets shuffled
   */
  public static <T> void arrayShuffle(T[] array) {
    Random rd = new Random();
    for (int i = 0; i < array.length - 1; i++) {
      int index = rd.nextInt(i + 1);
      T t = array[index];
      array[index] = array[i];
      array[i] = t;
      }
  }
  
  /**
   * Helper method that clears a pane and adds all the buttons in a Linked List to the pane
   * @param pane The pane that gets cleared and filled
   * @param list The Linked List that contains the buttons
   */
  public static void listToPane(TilePane pane, LinkedList<Button> list) {
    pane.getChildren().clear();
    for (Button b : list)
      pane.getChildren().add(b);
  }
  
  /**
   * The takes a stage and acts as the entry point for the application
   * @param primaryStage The stage that will be displayed
   */
  public void start(Stage primaryStage) {

    // All the possible cards in the game
    Button p1 = new Button("King Louis XVI (5)");
    Button p2 = new Button("Marie Antoinette (5)");
    Button p3 = new Button("Regent (4)");
    Button p4 = new Button("Duke (3)");
    Button p5 = new Button("Baron (3)");
    Button p6 = new Button("Count (*)");
    Button p7 = new Button("Countess (*)");
    Button p8 = new Button("Lord (*)");
    Button p9 = new Button("Lady (*)");
    Button p10 = new Button("Cardinal (5)");
    Button p11 = new Button("Archbishop (4)");
    Button p12 = new Button("Nun (3)");
    Button p13 = new Button("Bishop (2)");
    Button p14 = new Button("Priest (1)");
    Button p15 = new Button("Priest (1)");
    Button p16 = new Button("Heretic (*)");
    Button p17 = new Button("Governor (4)");
    Button p18 = new Button("Mayor (3)");
    Button p19 = new Button("Councilman (3)");
    Button p20 = new Button("Judge (2)");
    Button p21 = new Button("Judge (2)");
    Button p22 = new Button("Tax Collector (*)");
    Button p23 = new Button("Sheriff (1)");
    Button p24 = new Button("Sheriff (1)");
    Button p25 = new Button("Palace Guard (*)");
    Button p26 = new Button("Palace Guard (*)");
    Button p27 = new Button("Palace Guard (*)");
    Button p28 = new Button("Palace Guard (*)");
    Button p29 = new Button("Palace Guard (*)");
    Button p30 = new Button("General (4)");
    Button p31 = new Button("Colonel (3)");
    Button p32 = new Button("Captain (2)");
    Button p33 = new Button("Lieutenant (1)");
    Button p34 = new Button("Lieutenant (1)");
    Button p35 = new Button("Tragic Figure (*)");
    Button p36 = new Button("Heroic Figure (-3)");
    Button p37 = new Button("Student (-1)");
    Button p38 = new Button("Student (-1)");
    Button p39 = new Button("Student (-1)");
    Button p40 = new Button("Student (-1)");
    
    // Putting each button into their respective types to add colors (also used for cards with special point values) 
    Button[] royal = {p1, p2, p3, p4, p5, p6, p7, p8, p9};
    for(int i = 8; i >= 0; i--)
      royal[i].setStyle("-fx-background-color: #B9A7DA; ");
    Button[] church = {p10, p11, p12, p13, p14, p15, p16};
    for(int i = 6; i >= 0; i--)
      church[i].setStyle("-fx-background-color: #A7CEDA; ");
    Button[] civic = {p17, p18, p19, p20, p21, p22, p23, p24};
    for(int i = 7; i >= 0; i--)
      civic[i].setStyle("-fx-background-color: #A7DAAB; ");
    Button[] military = {p25, p26, p27, p28, p29, p30, p31, p32, p33, p34};
    for(int i = 9; i >= 0; i--)
      military[i].setStyle("-fx-background-color: #DAA7A7; ");
    Button[] commoner = {p35, p36, p37, p38, p39, p40};
    for(int i = 5; i >= 0; i--)
      commoner[i].setStyle("-fx-background-color: DADADA; ");
    Button[] palaceGuard = {p25, p26, p27, p28, p29};
    
    // Adding a set number of cards on the TitlePane
    TilePane peoplePane = new TilePane();
    peoplePane.setPrefColumns(1);
    Button[] array = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40};
    arrayShuffle(array);
    LinkedList<Button> people = new LinkedList<Button>();
    // Adding a set number of buttons to the LinkedList from the shuffled array
    for(int i = 0; i < numOfCards; i++)
      people.addToFront(array[i]);
    listToPane(peoplePane, people);
    
    // Setting the point values for each card
    for(Button b : people) {
      if (b == p1 || b == p2 || b == p10)
        b.setUserData(5);
      else if (b == p3 || b == p11 || b == p17 || b == p30)
        b.setUserData(4);
      else if (b == p4 || b == p5 || b == p12 || b == p18 || b == p19 || b == p31)
        b.setUserData(3);
      else if (b == p13 || b == p20 || b == p21 || b == p32)
        b.setUserData(2);
      else if (b == p14 || b == p15 || b == p23 || b == p24 || b == p33 || b == p34)
        b.setUserData(1);
      else if (b == p36)
        b.setUserData(-3);
      else if (b == p37 || b == p38 || b == p39 || b == p40)
        b.setUserData(-1);
      else if (b == p6 || b == p7)
        b.setUserData(2);
      else if (b == p8 || b == p9)
        b.setUserData(2);
      else if (b == p16)
        b.setUserData(0);
      else if (b == p22)
        b.setUserData(0);
      else if (b == p25 || b == p26 || b == p27 || b == p28 || b == p29)
        b.setUserData(0);
      else
        b.setUserData(0);
    }
    
    // Moves for player 1
    Button mfb41 = new Button("Move Front Back 4");
    Button mfb31 = new Button("Move Front Back 3");
    Button mfb21 = new Button("Move Front Back 2");
    Button mfb11 = new Button("Move Front Back 1");
    Button mfe1 = new Button("Move Front to End");
    Button mlpf1 = new Button("Move Last Person to Front");
    Button rl1 = new Button("Reverse Line");
    Button rf51 = new Button("Reverse First 5");
    Button st1 = new Button("Skip Turn");
    Button tfp1 = new Button("Take Front Person");
    
    // Moves for player 2
    Button mfb42 = new Button("Move Front Back 4");
    Button mfb32 = new Button("Move Front Back 3");
    Button mfb22 = new Button("Move Front Back 2");
    Button mfb12 = new Button("Move Front Back 1");
    Button mfe2 = new Button("Move Front to End");
    Button mlpf2 = new Button("Move Last Person to Front");
    Button rl2 = new Button("Reverse Line");
    Button rf52 = new Button("Reverse First 5");
    Button st2 = new Button("Skip Turn");
    Button tfp2 = new Button("Take Front Person");
    
    // Adding everything about player 1 to the leftSide VBox
    Label label1 = new Label("Player 1\nScore: " + Integer.toString(player1Score));
    VBox player1Info = new VBox();
    player1Info.getChildren().add(label1);
    VBox player1Moves = new VBox();
    player1Moves.getChildren().addAll(mfb41, mfb31, mfb21, mfb11, mfe1, mlpf1, rl1, rf51, st1, tfp1);
    VBox player1Cards = new VBox();
    VBox leftSide = new VBox();
    leftSide.getChildren().addAll(player1Info, player1Moves, player1Cards);
    
    // Adding everything about player 2 to the rightSide VBox
    Label label2 = new Label("Player 2\nScore: " + Integer.toString(player2Score));
    VBox player2Info = new VBox();
    player2Info.getChildren().add(label2);
    VBox player2Moves = new VBox();
    player2Moves.getChildren().addAll(mfb42, mfb32, mfb22, mfb12, mfe2, mlpf2, rl2, rf52, st2, tfp2);
    VBox player2Cards = new VBox();
    VBox rightSide = new VBox();
    rightSide.getChildren().addAll(player2Info, player2Moves, player2Cards);
    
    // Event Handler for move front back 4
    EventHandler<ActionEvent> mfb4 = event -> {
      people.moveBack(4);
      listToPane(peoplePane, people);
      ((Button)event.getSource()).setDisable(true);
    };
    mfb41.setOnAction(mfb4);
    mfb42.setOnAction(mfb4);
    
    // Event Handler for move front back 3
    EventHandler<ActionEvent> mfb3 = event -> {
      people.moveBack(3);
      listToPane(peoplePane, people);
      ((Button)event.getSource()).setDisable(true);
    };
    mfb31.setOnAction(mfb3);
    mfb32.setOnAction(mfb3);
    
    // Event Handler for move front back 2
    EventHandler<ActionEvent> mfb2 = event -> {
      people.moveBack(2);
      listToPane(peoplePane, people);
      ((Button)event.getSource()).setDisable(true);
    };
    mfb21.setOnAction(mfb2);
    mfb22.setOnAction(mfb2);
    
    // Event Handler for move front back 1
    EventHandler<ActionEvent> mfb1 = event -> {
      people.moveBack(1);
      listToPane(peoplePane, people);
      ((Button)event.getSource()).setDisable(true);
    };
    mfb11.setOnAction(mfb1);
    mfb12.setOnAction(mfb1);
    
    // Event Handler for move front to end
    EventHandler<ActionEvent> mfe = event -> {
      people.moveFirstToLast();
      listToPane(peoplePane, people);
      ((Button)event.getSource()).setDisable(true);
    };
    mfe1.setOnAction(mfe);
    mfe2.setOnAction(mfe);
    
    // Event Handler for move last person to front
    EventHandler<ActionEvent> mlpf = event -> {
      people.moveLastToFirst();
      listToPane(peoplePane, people);
      ((Button)event.getSource()).setDisable(true);
    };
    mlpf1.setOnAction(mlpf);
    mlpf2.setOnAction(mlpf);
    
    // Event Handler for reverse list
    EventHandler<ActionEvent> rl = event -> {
      people.reverseList();
      listToPane(peoplePane, people);
      ((Button)event.getSource()).setDisable(true);
    };
    rl1.setOnAction(rl);
    rl2.setOnAction(rl);
    
    // Event Handler for reverse first 5
    EventHandler<ActionEvent> rf5 = event -> {
      people.reverseFirstK(5);
      listToPane(peoplePane, people);
      ((Button)event.getSource()).setDisable(true);
    };
    rf51.setOnAction(rf5);
    rf52.setOnAction(rf5);
    
    // Event Handler for skip turn
    EventHandler<ActionEvent> st = event -> {
      ((Button)event.getSource()).setDisable(true);
    };
    st1.setOnAction(st);
    st2.setOnAction(st);
    
    
    
    // Event Handler for take first person
    tfp1.setOnAction(event -> {
      // Adding the point value of the card player 1 takes to player1Score
      player1Score += (Integer)people.getFirstNode().getElement().getUserData();
      
      // Adding the point values of special cards
      if (Arrays.asList(church).contains(people.getFirstNode().getElement())) {
        churchCards1 += 1;
        if (player1Cards.getChildren().contains(p16))
          player1Score += 1;
        else if (people.getFirstNode().getElement() == p16)
          player1Score += churchCards1;
      }
      else if (Arrays.asList(civic).contains(people.getFirstNode().getElement())) {
        civicCards1 += 1;
        if (player1Cards.getChildren().contains(p22))
          player1Score += 1;
        else if (people.getFirstNode().getElement() == p22)
          player1Score += civicCards1;
      }
      else if (Arrays.asList(commoner).contains(people.getFirstNode().getElement())) {
        commonerCards1 += 1;
        if (player1Cards.getChildren().contains(p35))
          player1Score -= 1;
        else if (people.getFirstNode().getElement() == p35)
          player1Score -= commonerCards1;
      }
      else if ((people.getFirstNode().getElement() == p6 || people.getFirstNode().getElement() == p7) && (player1Cards.getChildren().contains(p6) || player1Cards.getChildren().contains(p7)))
        player1Score += 4;
      else if ((people.getFirstNode().getElement() == p8 || people.getFirstNode().getElement() == p9) && (player1Cards.getChildren().contains(p8) || player1Cards.getChildren().contains(p9)))
        player1Score += 4;
      else if (Arrays.asList(palaceGuard).contains(people.getFirstNode().getElement())) {
        player1Score -= (palaceGuardCards1 * palaceGuardCards1);
        palaceGuardCards1 += 1;
        player1Score += (palaceGuardCards1 * palaceGuardCards1);
      }
      
      // Giving the card to player 1
      player1Cards.getChildren().add(people.getFirstNode().getElement());
      label1.setText("Player 1\nScore: " + Integer.toString(player1Score));
      people.removeFromFront();
      listToPane(peoplePane, people);
      
      // Close the game and declare the winner if there are no more cards left
      if (people.length() == 0) {
        primaryStage.close();
        if (player1Score > player2Score)
          System.out.println("Player 1 Wins !!");
        else if (player2Score > player1Score)
          System.out.println("Player 2 Wins !!");
        else
          System.out.println("Tie !!");
      }
    });
    
    tfp2.setOnAction(event -> {
      // Adding the point value of the card player 1 takes to player1Score
      player2Score += (Integer)people.getFirstNode().getElement().getUserData();
      
     // Adding the point values of special cards
      if (Arrays.asList(church).contains(people.getFirstNode().getElement())) {
        churchCards2 += 1;
        if (player2Cards.getChildren().contains(p16))
          player2Score += 1;
        else if (people.getFirstNode().getElement() == p16)
          player2Score += churchCards2;
      }
      else if (Arrays.asList(civic).contains(people.getFirstNode().getElement())) {
        civicCards2 += 1;
        if (player2Cards.getChildren().contains(p22))
          player2Score += 1;
        else if (people.getFirstNode().getElement() == p22)
          player2Score += civicCards2;
      }
      else if (Arrays.asList(commoner).contains(people.getFirstNode().getElement())) {
        commonerCards2 += 1;
        if (player2Cards.getChildren().contains(p35))
          player2Score -= 1;
        else if (people.getFirstNode().getElement() == p35)
          player2Score -= commonerCards2;
      }
      else if ((people.getFirstNode().getElement() == p6 || people.getFirstNode().getElement() == p7) && (player2Cards.getChildren().contains(p6) || player2Cards.getChildren().contains(p7)))
        player1Score += 4;
      else if ((people.getFirstNode().getElement() == p8 || people.getFirstNode().getElement() == p9) && (player2Cards.getChildren().contains(p8) || player2Cards.getChildren().contains(p9)))
        player1Score += 4;
      else if (Arrays.asList(palaceGuard).contains(people.getFirstNode().getElement())) {
        player1Score -= (palaceGuardCards2 * palaceGuardCards2);
        palaceGuardCards2 += 1;
        player1Score += (palaceGuardCards2 * palaceGuardCards2);
      }
      
      // Giving the card to player 2
      player2Cards.getChildren().add(people.getFirstNode().getElement());
      label2.setText("Player 2\nScore: " + Integer.toString(player2Score));
      people.removeFromFront();
      listToPane(peoplePane, people);
      
      // Close the game and declare the winner if there are no more cards left
      if (people.length() == 0) {
        primaryStage.close();
        if (player1Score > player2Score)
          System.out.println("Player 1 Wins !!");
        else if (player2Score > player1Score)
          System.out.println("Player 2 Wins !!");
        else
          System.out.println("Tie !!");
      }
    });
    
    // Adding everything into the main pane
    BorderPane pane = new BorderPane(peoplePane, null, rightSide, null, leftSide);

    // Setting the scene
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.setTitle("CSDS 132 - Guillotine");
    primaryStage.setHeight(1000);
    primaryStage.show();
  }
  
  /**
   * The main method for launching the application
   * @param args The input that determins the number of cards in a game
   */
  public static void main(String[] args) {
    // If we input a value  when launching the application
    if (args.length == 1 && Integer.parseInt(args[0]) >= 2 && Integer.parseInt(args[0]) <= 40) {
      numOfCards = Integer.parseInt(args[0]);
      Application.launch(args);
    }
    // If we dont input a value when launching the application
    else if (args.length == 0)
      Application.launch(args);
    // If we input a value out or bounds (or too many values)
    else
      throw new IndexOutOfBoundsException();
  }
}