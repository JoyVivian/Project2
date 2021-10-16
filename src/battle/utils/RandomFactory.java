package battle.utils;

/**
 * RandomFactory is a class that use the factory method
 * to generate RandomValue objects. When type is "RealRandom",
 * it returns a RealRandom object. When type is "FalseRandom"
 * it returns a FalseRandom object.
 */
public class RandomFactory {
  /**
   * Used to generate RandomValue instances according the type parameter.
   *
   * @param type       Represents which RandomValue object to generate.
   * @param lowerBound The lowerBound of a range that random values will come from.
   * @param upperBound The upperBound of a range that random values will come from.
   * @return A RandomValue instance.
   * @throws IllegalArgumentException If the type parameters is null, an IAE will be thrown.
   */
  public RandomValue createRandomInstance(String type, int lowerBound, int upperBound)
          throws IllegalArgumentException {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    if ("RealRandom".equals(type)) {
      return new RealRandom(lowerBound, upperBound);
    } else if ("FalseRandom".equals(type)) {
      return new FalseRandom(lowerBound, upperBound);
    }
    return null;
  }
}
