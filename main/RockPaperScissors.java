package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.model.*;
import main.strategy.StrategyService;

public class RockPaperScissors {
  
  private static int numberOfPoint;
  
  public static void main(String[] args){
    
    try {
      numberOfPoint = 3; // 3 points per game
      System.out.println("Welcome at Rock-Paper-Scissors game.");
      System.out.println("First to "+ numberOfPoint + " points win the game");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    // get computer strategy
    System.out.println("Select computer's strategy : " + Mode.getDescriptions());
    StrategyService strategyService = Mode.selectStrategyFromString(reader);
    
    // get player name
    System.out.println("Enter player name:");
    String playerName = reader.readLine();
    Play play = new Play(playerName);
    PlayRPS(play, reader, strategyService);
    
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  

  private static void PlayRPS(Play previousPlay, BufferedReader reader, StrategyService strategyService) throws IOException{
    String computerGameOption;
    if(previousPlay.getPlayScore() == null){
      // selectRandom
      computerGameOption = GameOption.selectRandom();
    } else {
      // check if the set is completed
      if((previousPlay.getComputer().getScore() == numberOfPoint || previousPlay.getPlayer().getScore() == numberOfPoint )&& previousPlay.getPlayer().getScore()  != previousPlay.getComputer().getScore()){
        String winner = previousPlay.getComputer().getScore() > previousPlay.getPlayer().getScore()? previousPlay.getComputer().getName() : previousPlay.getPlayer().getName();
        System.out.println("---------------------");
        System.out.println(winner.toUpperCase() + " WON THE GAME!");
        System.out.println("Do you want to play another set of "+ numberOfPoint +" points? (\"Y\" or \"N\")");
        String continuePlay = reader.readLine().toLowerCase();
        if(continuePlay.contains("y")){

          //zero up scores
          previousPlay.zeroUpScore();
          
          System.out.println("Do you want to change computer's strategy? (\"Y\" or \"N\")");
          String changeStrategy = reader.readLine().toLowerCase();
          if(changeStrategy.contains("y")){
            System.out.println("Select computer's strategy : " + Mode.getDescriptions());
            strategyService = Mode.selectStrategyFromString(reader);
          }
          
          computerGameOption = strategyService.strategy(previousPlay);
        } else {
          System.out.println("A bientot.");
          reader.close();
          return;
        }
      } else {
        computerGameOption = previousPlay.getPlayer().getGameOption().getLoseAgainst().getName();
      }
    }
    
    String playerGameOption= getPlayerOption(reader, 0);
    if(playerGameOption == null){
      reader.close();
      return;
    } else {
        if(GameOption.getNames().contains(playerGameOption)){
          Play play = new Play(previousPlay, computerGameOption, playerGameOption);
          PlayRPS(play, reader, strategyService);
        }
    }
  }
  
  private static String getPlayerOption(BufferedReader reader, int retry) throws IOException{
    
    System.out.println("Please select " + GameOption.getNamesDescription());
    
    String playerGameOption= reader.readLine().toLowerCase();
    
    if(GameOption.getNames().contains(playerGameOption)){
      return playerGameOption;
    } else {
      if(retry == 4){ // 5 opportunities to understand the game
        System.out.println("I don't think you understand the game.");
        System.out.println("Ciao.");
        return null;
      } 
      
      System.out.println(playerGameOption + " is not a valid option.");
      return getPlayerOption(reader, retry + 1);
    }
  }
}