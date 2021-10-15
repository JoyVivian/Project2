package battle.utils;

import java.util.HashSet;
import java.util.Random;

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
  public HashSet<Integer> getRandomValues(int num) {
    HashSet<Integer> randomValues = new HashSet<>();

    //Generate 10 different random numbers.
    for (int i = 0; i < num; i++) {
      int randomValue = this.getRandomValue();
      while (randomValues.contains(randomValue)) {
        randomValue = this.getRandomValue();
      }
      randomValues.add(randomValue);
    }

    return randomValues;
  }
}
