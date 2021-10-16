package battle.euipments;

import java.util.Arrays;
import java.util.Objects;

/**
 * This is the abstract class that implements InterfaceGear that contains
 * common fields and methods for four different gears.
 */
public abstract class Gear implements InterfaceGear {
  protected String name;
  protected int[] affectedAttrs;
  protected int priority;

  public Gear(String name, int[] affectedAttrs) throws IllegalArgumentException {
    if (name == null || affectedAttrs == null) {
      throw new IllegalArgumentException("name and affectedAttrs can not be null.");
    }

    this.name = name;
    this.affectedAttrs = affectedAttrs.clone();
    this.priority = 0;
  }

  @Override
  public int[] getAffectedAttrs() {
    return this.affectedAttrs.clone();
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
    return "Gear{" + "Type = " + this.getClass().toString() + ", "
            + "name='" + name + '\''
            + ", affectedAttrs=" + Arrays.toString(affectedAttrs)
            + '}' + "\n";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Gear gear = (Gear) o;
    return priority == gear.priority && name.equals(gear.name)
            && Arrays.equals(affectedAttrs, gear.affectedAttrs);
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
