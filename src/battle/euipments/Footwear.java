package battle.euipments;

public class Footwear extends Gear {
  public Footwear(String name, int[] affectedAttrs) {
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
    }else if (this.name.compareTo(o.getName()) < 0) {
      return 1;
    }else {
      return 0;
    }
  }
}
