package main.strategy;

import java.util.*;

import main.model.*;

public class StrategyImplementationBeatFavorite implements StrategyService {

  private Map<GameOption, Integer> gameOptionCount;
  
  public StrategyImplementationBeatFavorite (){
    gameOptionCount = new HashMap<GameOption, Integer>();
    gameOptionCount.put(GameOption.PAPER, 0);
    gameOptionCount.put(GameOption.ROCK, 0);
    gameOptionCount.put(GameOption.SCISSORS, 0);
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String strategy(Play previousPlay){
    if(previousPlay.getPlayer() != null){
      // increment option
      Integer selected = gameOptionCount.get(previousPlay.getPlayer().getGameOption());
      gameOptionCount.replace(previousPlay.getPlayer().getGameOption(), selected +1);
    }
    
    // select beat favorite
    int max = Math.max(gameOptionCount.get(GameOption.ROCK), gameOptionCount.get(GameOption.PAPER));
    max = Math.max(max, gameOptionCount.get(GameOption.SCISSORS));
    
    List<GameOption> favorites = new ArrayList<GameOption>();
    for(Map.Entry<GameOption, Integer> count : gameOptionCount.entrySet()){
      if(count.getValue() == max){
        favorites.add(count.getKey());
      }
    }
    
    GameOption favorite;
    if(favorites.size() == 1){
      favorite = favorites.get(0);
    } else {
      Random random = new Random();
      int randomInt = random.nextInt(favorites.size());
      favorite = favorites.get(randomInt);
    } 
    
    return favorite.getLoseAgainst().getName();
  }
}