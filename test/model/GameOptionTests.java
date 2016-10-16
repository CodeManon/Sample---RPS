package test.model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import main.model.GameOption;

public class GameOptionTests {

  @Test
  public void   getNamesTest(){
    Set<String> names = GameOption.getNames();
    assertNotNull(names);
    assertEquals(names.size(), 3);
    assertTrue(names.contains("p"));
    assertTrue(names.contains("s"));
    assertTrue(names.contains("r"));
    assertFalse(names.contains("t"));
  }
  
  @Test
  public void   getNamesDescriptionTest(){
    String namesDescription = GameOption.getNamesDescription();
    assertNotNull(namesDescription);
    assertFalse(namesDescription.isEmpty());
  }
  
  @Test
  public void getWinAgainstTestRock(){
    GameOption result = GameOption.ROCK.getWinAgainst();
    assertNotNull(result);
    assertEquals(result, GameOption.SCISSORS);
  }
  
  @Test
  public void getWinAgainstTestScissors(){
    GameOption result = GameOption.SCISSORS.getWinAgainst();
    assertNotNull(result);
    assertEquals(result, GameOption.PAPER);
  }
  
  @Test
  public void getWinAgainstTestPaper(){
    GameOption result = GameOption.PAPER.getWinAgainst();
    assertNotNull(result);
    assertEquals(result, GameOption.ROCK);
  }
  
  @Test
  public void getLoseAgainstTestRock(){
    GameOption result = GameOption.ROCK.getLoseAgainst();
    assertNotNull(result);
    assertEquals(result, GameOption.PAPER);
  }
  
  @Test
  public void getLoseAgainstTestScissors(){
    GameOption result = GameOption.SCISSORS.getLoseAgainst();
    assertNotNull(result);
    assertEquals(result, GameOption.ROCK);
  }
  
  @Test
  public void getLoseAgainstTestPaper(){
    GameOption result = GameOption.PAPER.getLoseAgainst();
    assertNotNull(result);
    assertEquals(result, GameOption.SCISSORS);
  }
  
  @Test
  public void selectRandomTest(){
    String result = GameOption.selectRandom();
    Set<String> gameOptions = GameOption.getNames();
    assertNotNull(result);
    assertFalse(result.isEmpty());
    assertTrue(gameOptions.contains(result));
  }
}