package test.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.model.*;
import main.strategy.*;

public class StrategyImplementationBeatFavoriteTests {

  private StrategyService strategyService;
  private Play previousPlay;
  private Player player;
  
  @Before
  public void setup(){
    strategyService = new StrategyImplementationBeatFavorite();
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
    
  private void strategyTest(GameOption favoriteGameOption){
    incrementFavorite(favoriteGameOption);
    for(GameOption playedGameOption : GameOption.values()){
      player.setGameOption(playedGameOption.getName());
      previousPlay.setPlayer(player);
      String result = strategyService.strategy(previousPlay);
      assertNotNull(result);
      assertEquals(result, favoriteGameOption.getLoseAgainst().getName());
    }
  } 
  
  private void incrementFavorite(GameOption gameOption){
    player.setGameOption(gameOption.getName());
    previousPlay.setPlayer(player);
    for(int i= 0; i< 3; i++){
      strategyService.strategy(previousPlay);
    }
  }
  
  @Test
  public void strategyTestTwoFavoritesRockPaper(){
    strategyTestTwoFavorites(GameOption.ROCK, GameOption.PAPER);
  }
 
  @Test
  public void strategyTestTwoFavoritesPaperScissors(){
    strategyTestTwoFavorites(GameOption.PAPER, GameOption.SCISSORS);
  }
  
  @Test
  public void strategyTestTwoFavoritesScissorsRock(){
    strategyTestTwoFavorites(GameOption.ROCK, GameOption.SCISSORS);
  }
    
  private void strategyTestTwoFavorites(GameOption favoriteGameOption1, GameOption favoriteGameOption2){
    incrementFavorite(favoriteGameOption1);
    incrementFavorite(favoriteGameOption2);
    GameOption playedGameOption = favoriteGameOption1.getLoseAgainst() == favoriteGameOption2? favoriteGameOption1.getWinAgainst() : favoriteGameOption1.getLoseAgainst();
      player.setGameOption(playedGameOption.getName());
      previousPlay.setPlayer(player);
      String result = strategyService.strategy(previousPlay);
      assertNotNull(result);
      assertTrue(result.equals(favoriteGameOption1.getLoseAgainst().getName()) || result.equals(favoriteGameOption2.getLoseAgainst().getName()));
  } 
  
  @Test
  public void strategyTestThreeFavoritesRock(){
    strategyTestThreeFavorites(GameOption.ROCK);
  }
  
  @Test
  public void strategyTestThreeFavoritesPaper(){
    strategyTestThreeFavorites(GameOption.SCISSORS);
  }
  
  @Test
  public void strategyTestThreeFavoritesScissor(){
    strategyTestThreeFavorites(GameOption.SCISSORS);
  }
  
  private void strategyTestThreeFavorites(GameOption gameOption){
    player.setGameOption(gameOption.getWinAgainst().getName());
    previousPlay.setPlayer(player);
    strategyService.strategy(previousPlay);
    player.setGameOption(gameOption.getLoseAgainst().getName());
    previousPlay.setPlayer(player);
    strategyService.strategy(previousPlay);
    
    player.setGameOption(gameOption.getName());
    previousPlay.setPlayer(player);
    
    String result = strategyService.strategy(previousPlay);
    assertNotNull(result);
  } 
}
