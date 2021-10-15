package battle.euipments;

public class Headgear extends Gear {

  public Headgear(String name, int[] affectedAttrs) {
    //TODO: Add some constraints here to make sure that headgear will only affect constitution.
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
