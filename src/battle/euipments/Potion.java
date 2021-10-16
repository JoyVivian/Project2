package battle.euipments;

/**
 * Potion is a gear. Potion is a concrete class of Gear.
 * Potion is used to temporarily change players' abilities.
 */
public class Potion extends Gear {

  /**
   * A constructor of Potion class that is used to generate Potion objects.
   *
   * @param name          The name of this Potion object.
   * @param affectedAttrs An array that represents a player's four basic abilities separately.
   */
  public Potion(String name, int[] affectedAttrs) {
    super(name, affectedAttrs);

    //Make sure it will only affect one of a player's ability.
    int num = 0;
    for (int i = 0; i < 4; i++) {
      if (affectedAttrs[i] != 0) {
        num ++;
      }
      if (num > 1) {
        affectedAttrs[i] = 0;
      }
    }
    this.priority = 3;
  }

  @Override
  public int compareTo(Gear o) {
    return o.compareImpl(this);
  }

  @Override
  public int compareImpl(Potion o) {
    if (this.name.compareTo(o.getName()) > 0) {
      return -1;
    } else if (this.name.compareTo(o.getName()) < 0) {
      return 1;
    } else {
      return 0;
    }
  }
}
