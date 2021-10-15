package battle.weapons;

import java.util.Objects;

public class Weapon implements InterfaceWeapon{
  protected String name = "";
  protected int damage = 0;

  public Weapon(String name) throws IllegalArgumentException{
    if (name == null) {
      throw new IllegalArgumentException("The name of a weapon can not be null.");
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getDamage() {
    return this.damage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Weapon weapon = (Weapon) o;
    return damage == weapon.damage && name.equals(weapon.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, damage);
  }

  @Override
  public String toString() {
    return "Weapon{" +
            "name='" + name + '\'' +
            ", damage=" + damage +
            '}';
  }
}
