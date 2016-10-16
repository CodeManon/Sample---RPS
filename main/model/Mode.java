package main.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import main.strategy.*;

public enum Mode {
  BEAT_LAST(1, "Beat last move"),
  
  BEAT_FAVORITE(2, "Beat favorite"),
  
  MAGICAL(3, "Magical"),
  
  RANDOM(4, "Random");
  
  private Integer id;
  private String description;
  
  private Mode(int id, String description){
    this.id = id;
    this.description = description;
  }
  
  public Integer getId(){
    return this.id;
  }
  
  public String getDescription(){
    return this.description;
  }
  
  public static Set<Integer> getIds(){
    Set<Integer> ids = new HashSet<Integer>();
    for(Mode mode : Mode.values()){
      ids.add(mode.getId());
    }
    return ids;
  }
  
  public static String getDescriptions(){
    String descriptions = null;
    for(Mode mode : Mode.values()){
      if(descriptions == null){
        descriptions = mode.getDescription() +"(\""+mode.getId()+"\")";
      } else {
        descriptions = descriptions  +", " + mode.getDescription() +"(\""+mode.getId()+"\")";
      }
    }
    return descriptions;
  }
  
  public static StrategyService selectStrategyFromString( BufferedReader reader) throws IOException{
      
    String strategy = reader.readLine();
      
      if(strategy.equals(Mode.BEAT_LAST.getId().toString())){
        return new StrategyImplementationBeatLast();
      } else if(strategy.equals(Mode.BEAT_FAVORITE.getId().toString())){
        return  new StrategyImplementationBeatFavorite();
      } else if(strategy.equals(Mode.RANDOM.getId().toString())){
        return  new StrategyImplementationRandom();
      } else {
        if(!strategy.equals(Mode.MAGICAL.getId().toString())){
          System.out.println(strategy + " is not a valid option, Magical strategy is selected by default.");
        }
        return  new StrategyImplementationCustom();
      }
  }
}
