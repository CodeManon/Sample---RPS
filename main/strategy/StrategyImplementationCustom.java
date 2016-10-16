package main.strategy;

import main.model.Play;

public class StrategyImplementationCustom implements StrategyService {
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String strategy(Play previousPlay){
    if(previousPlay.getPlayScore() == 0){ // tie
      // generate random between 0 and 1 number to decide the strategy
      double random = Math.random();
      
      if(random < 0.5){
        //  play the option that would beat the option that would have beat what computer played previously
        return previousPlay.getComputer().getGameOption().getLoseAgainst().getName();
      }else {
        // OR       
        //  play the option that would win the option that would have beat what computer played previously (in case player thinks like computer... )
        return previousPlay.getComputer().getGameOption().getWinAgainst().getName();
      }
    } 
    
    if(previousPlay.getPlayScore() == -1){ // computer lost
      // play the option that beat what one play previously
      return previousPlay.getPlayer().getGameOption().getLoseAgainst().getName();
    }
    
    if(previousPlay.getPlayScore() == 1){
      // play the game option that would beat the option that would have beat what computer played previously 
      // a.k.a. what player played previously
      return previousPlay.getPlayer().getGameOption().getName();
    }
    
    return null;
  }
}