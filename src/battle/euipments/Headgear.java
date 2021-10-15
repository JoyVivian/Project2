package battle.euipments;

public class Headgear extends Gear {

  public Headgear(String name, int[] affectedAttrs) {
    super(name, affectedAttrs);
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
    }else if (this.name.compareTo(o.getName()) < 0) {
      return 1;
    }else {
      return 0;
    }
  }
}
