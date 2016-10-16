package main.model;

public class Player {

  private String name;
  private int score;
  private GameOption gameOption;
  
  public Player(String name){
    this.name = name;
    this.score = 0;
  }
  
  public String getName(){
    return this.name;
  }
  
  public void incrementScore(){
    this.score = this.score +1;
  }
  
  public int getScore(){
    return this.score ;
  }
  
  public void setGameOption(String option){
    this.gameOption = GameOption.fromString(option);
  }
  
  public GameOption getGameOption(){
    return this.gameOption ;
  }  
  
  public void zeroUpScore(){
    this.score =0;
  }
}
