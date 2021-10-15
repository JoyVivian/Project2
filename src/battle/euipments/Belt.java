package battle.euipments;

import java.util.Arrays;

public class Belt extends Gear {
  private BeltSize beltSize;

  Belt(String name, int[] affectedAttrs, BeltSize beltSize) {
    super(name, affectedAttrs);
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
    }else if (this.name.compareTo(o.getName()) < 0) {
      return 1;
    }else {
      return 0;
    }
  }

  public BeltSize getBeltSize() {
    return beltSize;
  }

  @Override
  public String toString() {
    return "Belt{" +
            "beltSize=" + beltSize +
            ", name='" + name + '\'' +
            ", affectedAttrs=" + Arrays.toString(affectedAttrs) +
            '}';
  }
}
