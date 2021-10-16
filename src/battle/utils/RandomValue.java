package battle.utils;

import java.util.ArrayList;

/**
 * An interface of RandomValue that shows what functions
 * will a RandomValue object will have. We can get random value
 * and random serials through this interface.
 */
public interface RandomValue {
  public int getRandomValue();

  public ArrayList<Integer> getRandomValues(int num);
}
