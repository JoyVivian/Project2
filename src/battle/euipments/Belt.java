package battle.euipments;

/**
 * Belt is a gear. Belt class is used to create belt objects.
 * belt has a field separate from other gears which is beltsize.
 */
public class Belt extends Gear {
  private BeltSize beltSize;

  /**
   * Constructor of Belt class and is used to construct Belt objects.
   *
   * @param name          The name of this belt gear.
   * @param affectedAttrs An array that represents a player's four basic abilities separately.
   * @param beltSize      BeltSize Enum to represent the size of the belt object.
   */
  public Belt(String name, int[] affectedAttrs, BeltSize beltSize) throws IllegalArgumentException {
    super(name, affectedAttrs);

    if (beltSize == null) {
      throw new IllegalArgumentException("BeltSize can not be null.");
    }
    //Make sure it only affects two attributes.
    int num = 0;
    for (int i = 0; i < 4; i++) {
      if (affectedAttrs[i] != 0) {
        num++;
      }
      if (num > 2) {
        affectedAttrs[i] = 0;
      }
    }

    this.priority = 2;
    this.beltSize = beltSize;
  }

  @Override
  public int compareTo(Gear o) {
    return o.compareImpl(this);
  }

  @Override
  public int compareImpl(Belt o) {
    if (this.name.compareTo(o.getName()) > 0) {
      return -1;
    } else if (this.name.compareTo(o.getName()) < 0) {
      return 1;
    } else {
      return 0;
    }
  }

  public BeltSize getBeltSize() {
    return beltSize;
  }


  @Override
  public String toString() {
    return super.toString() + String.format("BeltSize = %s", this.beltSize) + "\n";
  }
}
