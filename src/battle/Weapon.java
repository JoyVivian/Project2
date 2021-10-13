package battle;

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
}
