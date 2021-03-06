package battle.euipments;

/**
 * Headgear is a gear. Headgear is a concrete class of Gear that
 * used to generate Headgear objects.
 */
public class Headgear extends Gear {

  /**
   * A constructor for Headgear class that used to generate Headgear objects.
   *
   * @param name          The name of the Headgear object.
   * @param affectedAttrs An array that represents a player's four basic abilities separately.
   */
  public Headgear(String name, int[] affectedAttrs) {
    super(name, affectedAttrs);

    for (int i = 0; i < 4; i++) {
      if (i != 1 && affectedAttrs[i] != 0) {
        affectedAttrs[i] = 0;
      }
    }

    this.priority = 4;
  }

  @Override
  public int compareTo(Gear o) {
    return o.compareImpl(this);
  }

  @Override
  public int compareImpl(Headgear o) {
    if (this.name.compareTo(o.getName()) > 0) {
      return -1;
    } else if (this.name.compareTo(o.getName()) < 0) {
      return 1;
    } else {
      return 0;
    }
  }
}
