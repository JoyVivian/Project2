package battle.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * This the concrete class for RandomValue that is used to generate
 * real random values or serials when playing the game.
 */
public class RealRandom implements RandomValue {
  private int lowerBound;
  private int upperBound;

  public RealRandom(int lowerBound, int upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  @Override
  public int getRandomValue() {
    Random rand = new Random();
    return this.lowerBound + rand.nextInt(this.upperBound - this.lowerBound + 1);
  }

  @Override
  public List<Integer> getRandomValues(int num) {
    ArrayList<Integer> randomValues = new ArrayList<>();

    //Generate num different random numbers.
    for (int i = 0; i < num; i++) {
      int randomValue = this.getRandomValue();
      while (randomValues.contains(randomValue)) {
        randomValue = this.getRandomValue();
      }
      randomValues.add(randomValue);
    }

    return randomValues;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RealRandom that = (RealRandom) o;
    return lowerBound == that.lowerBound && upperBound == that.upperBound;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lowerBound, upperBound);
  }
}
