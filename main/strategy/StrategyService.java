package main.strategy;

import main.model.Play;

public interface StrategyService{

  /**
   * define the computer strategy to play against player
   * @param previousPlay Play - previousPlay
   */
  public String strategy(Play previousPlay);
}
