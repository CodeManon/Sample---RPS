package main.strategy;

import main.model.GameOption;
import main.model.Play;

public class StrategyImplementationRandom implements StrategyService{

  /**
   * {@inheritDoc}
   */
  @Override
  public String strategy(Play previousPlay){
    return GameOption.selectRandom();
  }  
}
