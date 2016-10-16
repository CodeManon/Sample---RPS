package test.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.model.*;
import main.strategy.*;

public class StrategyImplementationCustomTests {

  private StrategyService strategyService;
  
  @Before
  public void setup(){
    strategyService = new StrategyImplementationCustom();
  }
  
  @Test
  public void strategyTestTieRock(){
    strategyTestTie(GameOption.ROCK);
  }
  
  @Test
  public void strategyTestTiePaper(){
    strategyTestTie(GameOption.PAPER);
  }
  
  @Test
  public void strategyTestTieScissors(){
    strategyTestTie(GameOption.SCISSORS);
  }
  
  private void strategyTestTie(GameOption gameOption){
    Play previousPlay = new Play(new Play(""), gameOption.getName(), gameOption.getName());
    String result = strategyService.strategy(previousPlay);
    assertNotNull(result);
    assertFalse(result.equals(gameOption.getName()) );
    assertTrue(result.equals(gameOption.getLoseAgainst().getName()) || result.equals(gameOption.getWinAgainst().getName() ));
  }
  
  @Test
  public void strategyTestComputerWonRock(){
    strategyTestComputerWon(GameOption.ROCK);
  }
  
  @Test
  public void strategyTestComputerWonPaper(){
    strategyTestComputerWon(GameOption.PAPER);
  }
  
  @Test
  public void strategyTestComputerWonScissors(){
    strategyTestComputerWon(GameOption.SCISSORS);
  }
  
  private void strategyTestComputerWon(GameOption computerGameOption){
    Play previousPlay = new Play(new Play(""), computerGameOption.getName(), computerGameOption.getWinAgainst().getName());
    String result = strategyService.strategy(previousPlay);
    assertNotNull(result);
    assertTrue(result.equals(computerGameOption.getWinAgainst().getName()) );
  }
  
  @Test
  public void strategyTestComputerLostRock(){
    strategyTestComputerLost(GameOption.ROCK);
  }
  
  @Test
  public void strategyTestComputerLostPaper(){
    strategyTestComputerLost(GameOption.PAPER);
  }
  
  @Test
  public void strategyTestComputerLostScissors(){
    strategyTestComputerLost(GameOption.SCISSORS);
  }
  
  private void strategyTestComputerLost(GameOption computerGameOption){
    Play previousPlay = new Play(new Play(""), computerGameOption.getName(), computerGameOption.getLoseAgainst().getName());
    String result = strategyService.strategy(previousPlay);
    assertNotNull(result);
    assertTrue(result.equals(computerGameOption.getWinAgainst().getName()) );
  }
}
