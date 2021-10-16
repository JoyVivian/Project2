package battle.weapons;

/**
 * An interface that implemented by Weapon class and shows
 * what functions that a weapon will have. A weapon can have
 * a name and cause some damage. We can get its name and damage
 * through this interface.
 */
public interface InterfaceWeapon {
  public String getName();

  public int getDamage(String type);
}
