package battle.utils;

import java.util.List;

/**
 * An interface of RandomValue that shows what functions
 * will a RandomValue object will have. We can get random value
 * and random serials through this interface.
 */
public interface RandomValue {
  public int getRandomValue();

  public List<Integer> getRandomValues(int num);
}
