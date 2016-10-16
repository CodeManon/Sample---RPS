package test.strategy;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import main.model.*;
import main.strategy.*;

public class StrategyImplementationRandomTests {

  private StrategyService strategyService;
  private Set<String> gameOptions;
  
  @Before
  public void setup(){
    strategyService = new StrategyImplementationRandom();
    gameOptions = GameOption.getNames();
  }
  
  @Test
  public void strategyTestPreviousPlayNotNull(){
    strategyTest(new Play(" "));
  }
  
  @Test
  public void strategyTestPreviousPlayNull(){
   strategyTest(null);
  }
  
  private void strategyTest(Play play){
    String result = strategyService.strategy(play);
    assertNotNull(result);
    gameOptions.contains(result);
  }
}
