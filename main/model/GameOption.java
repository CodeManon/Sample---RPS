package main.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public enum GameOption {
  
  ROCK("r", "rock"),
  PAPER("p", "paper"),
  SCISSORS("s", "scissors");
  
  private String name;
  private String description;
  
  private GameOption(String name, String description){
    this.name = name;
    this.description = description;
  }

  public String getName(){
    return this.name;
  }
  
  public String getDescription(){
    return this.description;
  }

  public GameOption getWinAgainst(){
    if(this.name.equalsIgnoreCase(GameOption.PAPER.getName())){
      return GameOption.ROCK;
    } 
    
    if(this.name.equalsIgnoreCase(GameOption.ROCK.getName())){
      return GameOption.SCISSORS;
    }
    
    if(this.name.equalsIgnoreCase(GameOption.SCISSORS.getName())){
      return GameOption.PAPER;
    }
    
    return null;
  }
  
  public GameOption getLoseAgainst(){
    if(this.name.equalsIgnoreCase(GameOption.PAPER.getName())){
      return GameOption.SCISSORS;
    } 
    
    if(this.name.equalsIgnoreCase(GameOption.ROCK.getName())){
      return GameOption.PAPER;
    }
    
    if(this.name.equalsIgnoreCase(GameOption.SCISSORS.getName())){
      return GameOption.ROCK;
    }
    
    return null;
  }
  

  public static Set<String> getNames(){
    Set<String> names = new HashSet<String>();
    for(GameOption gameOption :  GameOption.values()){
      names.add(gameOption.getName());
    }  
    return names;
  }
  
  public static String getNamesDescription(){
    String  namesDescription =null;
    for(GameOption gameOption :  GameOption.values()){
      if(namesDescription == null){
        namesDescription = gameOption.getDescription() + " (\""+gameOption.getName()+"\") ";
      } else {
        namesDescription = namesDescription + ", " + gameOption.getDescription() + " (\""+gameOption.getName()+"\") ";
      }
    }  
    return namesDescription ;
  }
    
  public static GameOption fromString(String name){
    for(GameOption gameOption : GameOption.values()){
      if(gameOption.getName().equalsIgnoreCase(name)){
        return gameOption;
      }
    }
    return null;
  }  
  
  public static String selectRandom(){
    Set<String> gameOptions = GameOption.getNames();
 
    // select a random number between 0 and 3
    Random random = new Random();
    int randomNum = random.nextInt(3);
     return (gameOptions.toArray(new String[3]))[randomNum];    
  } 
}
