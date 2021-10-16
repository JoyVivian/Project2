package battle.euipments;

/**
 * This is an interface for Gear objects. We can
 * get attributes that a gear can affect on players.
 */
public interface InterfaceGear extends Comparable<Gear> {
  public int[] getAffectedAttrs();
}
