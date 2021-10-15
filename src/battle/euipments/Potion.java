package battle.euipments;

public class Potion extends Gear {

  public Potion(String name, int[] affectedAttrs) {
    super(name, affectedAttrs);
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
    }else if (this.name.compareTo(o.getName()) < 0) {
      return 1;
    }else {
      return 0;
    }
  }
}
