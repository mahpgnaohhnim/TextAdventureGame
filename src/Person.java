import java.util.*;


/**
 * Created by henry on 28.11.15.
 */
public class Person{

    Scanner scan = new Scanner(System.in);
    String name;
    Weapon weapon = new Weapon("nothing", 0, 0, 0);
    Weapon armor = new Weapon("nothing", 0, 0, 0);
    int inventorySlot = 5;
    String[] inventory = new String[inventorySlot];
    int baseHP = 5;
    int baseDef = 1;
    int baseAtk = 1;
    int level = 1;
    int currentExp = 0;
    int expTillLvlUp = 8;   //default
    int nextLvlExp = 8;     //default
    int totalHP = 1;
    int currentHP = totalHP;
    int damage = 0;
    int money = 0;


    int totalDef;
    int totalAtk;

    public void setName(){
        System.out.println("What is your name?");
        this.name = scan.next();
    }

    public void changeWeapon(Weapon newWeapon){
        weapon = newWeapon;
    }

    public void updateStats(){
        totalHP = baseHP + weapon.hpBonus + armor.hpBonus;
        currentHP = totalHP - damage;
        totalDef = baseDef + weapon.defBonus + armor.defBonus;
        totalAtk = baseAtk + weapon.atkBonus + armor.atkBonus;
        if(currentExp >= nextLvlExp){
            levelUp();
        }
        if(currentHP <= 0){
            System.out.println("Your Health Points are now at 0. You are Dead!");
            System.exit(0);
        }

    }

    public void showStats(){
        updateStats();
        System.out.println("This is Your Stats right now: ");
        System.out.println("Name:\t\t\t" + name);
        System.out.println("Level:\t\t\t" + level);
        System.out.println("EXP:\t\t\t" + currentExp);
        System.out.println("Until next Level:\t" + (nextLvlExp-currentExp));
        System.out.println("HP:\t\t\t" + currentHP + "/" + totalHP);
        System.out.println("Attack:\t\t\t" + totalAtk);
        System.out.println("Defense:\t\t" + totalDef);
        System.out.println("Money:\t\t\t" + money);
    }

    public void showItem(){
        System.out.print("Your Items:\n" + weapon.name + " ");
        for(String item : inventory){
            if(item != null)
                System.out.print(", " + item);
        }
        System.out.println(".");
    }

    public void getEXP(int i){
        System.out.println("You earned "+i+" EXP!");
        currentExp = currentExp + i;
        updateStats();
    }

    public void levelUp(){
        level++;
        baseHP = baseHP+4;
        baseAtk = baseAtk + 3;
        baseDef++;
        expTillLvlUp = (int)(expTillLvlUp * 1.3);
        nextLvlExp = nextLvlExp + expTillLvlUp;
        damage = 0;
        updateStats();
        System.out.println("Congratulation!!! You have leveled up! Now your level is "+this.level);
        showStats();
    }

    public void addItem(String newItem){
        for(int i = 0; i<inventorySlot;i++){
            if(inventory[i]==null){
                inventory[i] = newItem;
                break;
            }
        }
    }

    public void getDamage(int dmg){
		int trueDamage = dmg -this.totalDef;
        if(trueDamage > 0){
            damage = damage + trueDamage;
            System.out.println("You lost " + trueDamage + "HP!" );
        }
        else{
            System.out.println("Nothing happened..." );
        }

        updateStats();
    }

    public void getMoney(int addMoney){
        this.money = this.money + addMoney;
    }
	
	public void fullHeal(){
        this.currentHP = this.totalHP;
        this.damage = 0;
        System.out.println("Your Health has been fully restored!");
	}

}
