package battle.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class FalseRandom implements RandomValue{
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
  public HashSet<Integer> getRandomValues(int num) {
    HashSet<Integer> playerRandom = new HashSet<>();

    int i = 0;
    while (i < num * 2) {
      playerRandom.add(i);
      i += 2;
    }

    return playerRandom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FalseRandom that = (FalseRandom) o;
    return lowerBound == that.lowerBound && upperBound == that.upperBound;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lowerBound, upperBound);
  }
}
