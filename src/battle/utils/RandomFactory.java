package battle.utils;

public class RandomFactory {
  public RandomValue createRandomInstance(String type, int lowerBound, int upperBound) throws IllegalArgumentException {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    if ("RealRandom".equals(type)) {
      return new RealRandom(lowerBound, upperBound);
    }
    else if ("FalseRandom".equals(type)) {
      return new FalseRandom(lowerBound, upperBound);
    }
    return null;
  }
}
