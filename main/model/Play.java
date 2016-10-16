package main.model;

public class Play {

  private static int COMPUTER_WIN = 1;
  private static int COMPUTER_LOST = -1;
  private static int TIE= 0;
  
  private Integer playScore;
  private Player player;
  private Player computer;
  
  public Play(String playerName){
    this.player  =  new Player(playerName);
    this.computer =  new Player("computer");
  }
  
  public Play(Play previousPlay, String computerOption, String playerOption){
   this.computer= previousPlay.getComputer();
   this.computer.setGameOption(computerOption);
   System.out.println(this.computer.getName() +" plays " + this.computer.getGameOption().getDescription());
   this.player = previousPlay.getPlayer();
   this.player.setGameOption(playerOption);
   System.out.println(this.player.getName() +" plays " + this.player.getGameOption().getDescription());
   if(this.computer.getGameOption().getLoseAgainst().getName().equals(playerOption)){
     // computer lost
     this.playScore = COMPUTER_LOST;
     this.player.incrementScore();
     System.out.println(this.player.getName() + " won. Score is " + this.player.getName() + " : "+ this.player.getScore() +", " + this.computer.getName() + " : "+ this.computer.getScore()); 
   } else if(computerOption.equalsIgnoreCase(playerOption)){
     this.playScore = TIE;
     System.out.println("Tie!");
   } else { // computer won
     this.playScore = COMPUTER_WIN;
     this.computer.incrementScore();
     System.out.println(this.computer.getName() + " won.Score is " + this.player.getName() + " : "+ this.player.getScore() +", " + this.computer.getName() + " : "+ this.computer.getScore());
   }
  }  
  
  public Integer getPlayScore (){
    return this.playScore;
  }
  
  public Player getPlayer(){
    return this.player;
  }
  
  public void setPlayer(Player player){
    this.player = player;
  }
  
  public Player getComputer(){
    return this.computer ;
  } 
  
  public void setComputer(Player computer){
    this.computer = computer;
  }  
  
  public void zeroUpScore(){
    this.computer.zeroUpScore();
    this.player.zeroUpScore();
  }
}
