package battle.utils;

import java.util.ArrayList;
import java.util.Objects;

/**
 * FalseRandom is used to return some specific value
 * and value serials that mock random values when doing tests.
 * However, this numbers are not really random. Instead, they are
 * fixed every time which makes the process predictable when testing.
 */
public class FalseRandom implements RandomValue {
  private int lowerBound;
  private int upperBound;

  public FalseRandom(int lowerBound, int upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  @Override
  public int getRandomValue() {
    return this.upperBound;
  }

  @Override
  public ArrayList<Integer> getRandomValues(int num) {
    ArrayList<Integer> playerRandom = new ArrayList<>();

    int i = 0;
    int index = 0;
    while (index < num) {
      playerRandom.add(i);
      i += 2;
      index++;
    }

    return playerRandom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FalseRandom that = (FalseRandom) o;
    return lowerBound == that.lowerBound && upperBound == that.upperBound;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lowerBound, upperBound);
  }
}
