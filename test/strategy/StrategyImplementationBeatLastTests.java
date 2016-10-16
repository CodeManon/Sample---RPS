package test.strategy;

import static org.junit.Assert.*;

import org.junit.*;

import main.model.*;
import main.strategy.*;

public class StrategyImplementationBeatLastTests {

  private StrategyService strategyService;
  private Play previousPlay;
  private Player player;
  
  @Before
  public void setup(){
    strategyService = new StrategyImplementationBeatLast();
    previousPlay = new Play("player1");
    previousPlay.setComputer(new Player("computer"));
    player = new Player("player");
  }
  
  @Test
  public void strategyTestRock(){
    strategyTest(GameOption.ROCK);
  }
  
  @Test
  public void strategyTestPaper(){
    strategyTest(GameOption.PAPER);
  }
  
  @Test
  public void strategyTestScissors(){
    strategyTest(GameOption.SCISSORS);
  }
    
  private void strategyTest(GameOption gameOption){
    player.setGameOption(gameOption.getName());
    previousPlay.setPlayer(player);
    String result = strategyService.strategy(previousPlay);
    assertNotNull(result);
    assertEquals(result, gameOption.getLoseAgainst().getName());
  }  
}
