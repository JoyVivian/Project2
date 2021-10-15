package battle.euipments;

import java.util.Arrays;
import java.util.Objects;

public abstract class Gear implements InterfaceGear {
  protected String name = "";
  protected int[] affectedAttrs = new int[4];
  protected int priority = 0;

  public Gear(String name, int[] affectedAttrs) {
    this.name = name;
    this.affectedAttrs = affectedAttrs.clone();
  }

  @Override
  public int[] getAffectedAttrs() {
    return this.affectedAttrs;
  }


  @Override
  public abstract int compareTo(Gear o);

  public int compareImpl(Headgear o) {
    return this.getPriority() > o.getPriority() ? 1 : -1;
  }

  public int compareImpl(Potion o) {
    return this.getPriority() > o.getPriority() ? 1 : -1;
  }

  public int compareImpl(Belt o) {
    return this.getPriority() > o.getPriority() ? 1 : -1;
  }

  public int compareImpl(Footwear o) {
    return this.getPriority() > o.getPriority() ? 1 : -1;
  }

  public int getPriority() {
    return priority;
  }

  @Override
  public String toString() {
    return "Gear{" +
            "name='" + name + '\'' +
            ", affectedAttrs=" + Arrays.toString(affectedAttrs) +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Gear gear = (Gear) o;
    return priority == gear.priority && name.equals(gear.name) && Arrays.equals(affectedAttrs, gear.affectedAttrs);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(name, priority);
    result = 31 * result + Arrays.hashCode(affectedAttrs);
    return result;
  }

  public String getName() {
    return name;
  }
}
