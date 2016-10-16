package main.strategy;

import main.model.Play;

public class StrategyImplementationBeatLast implements StrategyService{

  /**
   * {@inheritDoc}
   */
  @Override
  public String strategy(Play previousPlay){
    return previousPlay.getPlayer().getGameOption().getLoseAgainst().getName();
  }  
}
