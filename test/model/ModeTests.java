package test.model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import main.model.Mode;

public class ModeTests {
  
  @Test
  public void getIdsTest(){
    Set<Integer> ids = Mode.getIds();
    assertNotNull(ids);
    assertFalse(ids.isEmpty());
    assertEquals(ids.size(), 4);
  }
  
  @Test
  public void getDescriptionsTest(){
    String descriptions = Mode.getDescriptions();
    assertNotNull(descriptions);
    assertFalse(descriptions.isEmpty());
  }
}
