package battle.euipments;

/**
 * FootWear is one type of Gear and Footwear class is used to
 * create Footwear objects. FootWear affected one player's dexterity.
 */
public class Footwear extends Gear {
  /**
   * A constructor for Footwear class to build Footwear instances.
   *
   * @param name          The name of this Footwear object.
   * @param affectedAttrs An array that represents a player's four basic abilities separately.
   */
  public Footwear(String name, int[] affectedAttrs) {
    //TODO: Add some constraints here to make sure footwear can only affect dexterity.
    super(name, affectedAttrs);
    this.priority = 1;
  }

  @Override
  public int compareTo(Gear o) {
    return o.compareImpl(this);
  }

  @Override
  public int compareImpl(Footwear o) {
    if (this.name.compareTo(o.getName()) > 0) {
      return -1;
    } else if (this.name.compareTo(o.getName()) < 0) {
      return 1;
    } else {
      return 0;
    }
  }
}
