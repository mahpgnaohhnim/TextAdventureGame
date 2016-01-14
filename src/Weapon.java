/**
 * Created by henry on 01.12.15.
 */
public class Weapon {
    String name;
    int atkBonus = 0;
    int defBonus = 0;
    int hpBonus = 0;
    public Weapon(String name, int atk, int def, int hp){
        this.name = name;
        this.atkBonus = atk;
        this.defBonus = def;
        this.hpBonus = hp;
    }
}
