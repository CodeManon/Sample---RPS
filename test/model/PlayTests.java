package test.model;

import static org.junit.Assert.*;

import org.junit.Test;

import main.model.*;

public class PlayTests {
  
  @Test 
  public void PlayInitializeTest(){
    Play play = new Play("player1");
    assertNotNull(play);
    assertNull(play.getPlayScore());
    assertNotNull(play.getPlayer());
    assertEquals(play.getPlayer().getScore(), 0);
    assertNull(play.getPlayer().getGameOption());
    
    assertNotNull(play.getComputer());
    assertEquals(play.getComputer().getScore(), 0);
    assertNull(play.getComputer().getGameOption());
    
    assertNotEquals(play.getComputer().getName(), play.getPlayer().getName());
  }
  
  
  @Test 
  public void PlayPreviousTestComputerWon(){
    Play previousPlay = new Play("player1");
    String computerOption = GameOption.PAPER.getName();
    String playerOption = GameOption.ROCK.getName();
    Play play = new Play(previousPlay, computerOption, playerOption);
    
    assertNotNull(play);
    assertNotNull(play.getPlayScore());
    assertEquals(play.getPlayScore().intValue(), 1);
    
    assertNotNull(play.getPlayer());
    assertEquals(play.getPlayer().getScore(), 0);
    assertNotNull(play.getPlayer().getGameOption());
    assertEquals(play.getPlayer().getGameOption(), GameOption.fromString(playerOption));
    
    assertNotNull(play.getComputer());
    assertEquals(play.getComputer().getScore(), 1);
    assertNotNull(play.getComputer().getGameOption());
    assertEquals(play.getComputer().getGameOption(), GameOption.fromString(computerOption));
    
    assertNotEquals(play.getComputer().getName(), play.getPlayer().getName());
  }
  
  
  @Test 
  public void PlayPreviousTestComputerLost(){
    Play previousPlay = new Play("player1");
    String computerOption = GameOption.PAPER.getName();
    String playerOption = GameOption.SCISSORS.getName();
    Play play = new Play(previousPlay, computerOption, playerOption);
    
    assertNotNull(play);
    assertNotNull(play.getPlayScore());
    assertEquals(play.getPlayScore().intValue(), -1);
    
    assertNotNull(play.getPlayer());
    assertEquals(play.getPlayer().getScore(), 1);
    assertNotNull(play.getPlayer().getGameOption());
    assertEquals(play.getPlayer().getGameOption(), GameOption.fromString(playerOption));
    
    assertNotNull(play.getComputer());
    assertEquals(play.getComputer().getScore(), 0);
    assertNotNull(play.getComputer().getGameOption());
    assertEquals(play.getComputer().getGameOption(), GameOption.fromString(computerOption));
    
    assertNotEquals(play.getComputer().getName(), play.getPlayer().getName());
  }

  @Test 
  public void PlayPreviousTestTie(){
    Play previousPlay = new Play("player1");
    String computerOption = GameOption.PAPER.getName();
    String playerOption = GameOption.PAPER.getName();
    Play play = new Play(previousPlay, computerOption, playerOption);
    
    assertNotNull(play);
    assertNotNull(play.getPlayScore());
    assertEquals(play.getPlayScore().intValue(), 0);
    
    assertNotNull(play.getPlayer());
    assertEquals(play.getPlayer().getScore(), 0);
    assertNotNull(play.getPlayer().getGameOption());
    assertEquals(play.getPlayer().getGameOption(), GameOption.fromString(playerOption));
    
    assertNotNull(play.getComputer());
    assertEquals(play.getComputer().getScore(), 0);
    assertNotNull(play.getComputer().getGameOption());
    assertEquals(play.getComputer().getGameOption(), GameOption.fromString(computerOption));
    
    assertNotEquals(play.getComputer().getName(), play.getPlayer().getName());
  }
}
