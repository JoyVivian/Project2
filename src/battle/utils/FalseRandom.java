package battle.utils;

import java.util.HashSet;

public class FalseRandom implements RandomValue{
  private int lowerBound;
  private int upperBound;

  FalseRandom(int lowerBound, int upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  @Override
  public int getRandomValue() {
    return this.upperBound;
  }

  @Override
  public HashSet<Integer> getRandomValues(int num) {
    HashSet<Integer> playerRandom = new HashSet<>();

    for (int i = 0; i < 40; i += 2) {
      playerRandom.add(i);
    }

    return playerRandom;
  }
}
