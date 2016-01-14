public class Monster{
	String name;
	int hp;
	int atk;
	int def;
	int exp;
	int money;
	public Monster(String setName, int setHp, int setAtk, int setDef, int setMoney, int setExp ){
		this.name = setName;
		this.hp = setHp;
		this.atk = setAtk;
		this.def = setDef;
		this.money = setMoney;
		this.exp = setExp;
	}

	public void damageMonster(int dmg){
		int trueDmg = dmg - this.def;
		if(trueDmg > 0){
			this.hp = this.hp-trueDmg;
			System.out.println(this.name + " lost " + trueDmg + "HP!");
		}
		else{
			System.out.println("You did no damage!");

		}

	}
}