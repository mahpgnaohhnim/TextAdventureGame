/**
 * Created by henry on 26.11.15.
 */

import java.util.*;
import java.io.IOException;

public class Adventure{
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        boolean[] chapter = new boolean[7];
        boolean game = false;
        boolean gameMenu = false;
        boolean forestFaint = false;
        boolean firstTimeCity = true;
        boolean lastChapter = false;

        int bossCounter = 0;

        String choice;

        Person protagonist = new Person();
        Weapon weapon = new Weapon("nothing", 0, 0, 0);
        Weapon longsword = new Weapon("Long Sword", 5, 3, 1);
        Weapon lance = new Weapon("Lance", 2, 4, 3);
        Weapon greatsword = new Weapon("Great Sword", 4, 1, 4);
        Weapon holySword = new Weapon("Holy Sword", 15, 10, 10);
        Weapon demonicSword = new Weapon("Demonic Blade", 30,18, 20);
        Weapon warpSpike = new Weapon("Warping Heartspike", 44,26, 35);
        Weapon lightSabre = new Weapon("Light Sabre", 60, 60, 60);



        clearConsole();
        printHeader();
        System.out.print("Do you want to play the game? ");
        String startGame = scan.next();
        startGame = startGame.toLowerCase();


        if(startGame.equals("yes")){
            System.out.println("Lets start the game");
            chapter[0] = true;
            game = true;
            protagonist.inventory[0] = "Hero License";
            clearConsole();
        }
        else{
            gameOver();
        }

        while(game){
            if(chapter[0]){
                protagonist.setName();
                clearConsole();
                System.out.println("Hello " + protagonist.name);
                Boolean chooseWeapon = true;
                while(chooseWeapon){
                    System.out.println("Here are 3 weapons. What is your choice?\nPut in the number of the Weapon you want to take:");
                    System.out.println("1. Long Sword(+5Atk|+3Def|+1HP)");
                    System.out.println("2. Lance(+2Atk|+4Def|+3HP)");
                    System.out.println("3. Great Sword(+4Atk||+1Def|+4HP)");
                    choice = scan.next();

                    switch(choice){
                        case "1":
                            weapon = longsword;
                            break;
                        case "2":
                            weapon = lance;
                            break;
                        case "3":
                            weapon = greatsword;
                            break;
                        default:
                            clearConsole();
                            break;
                    }
                    protagonist.changeWeapon(weapon);
                    protagonist.updateStats();
                    if(protagonist.weapon.name != "nothing"){
                        clearConsole();
                        System.out.println("You get a " + protagonist.weapon.name + "!!!\n");
                        protagonist.getEXP(3);
                        chooseWeapon = false;
                    }
                    else{
                        System.out.println("Please put in the correct number");
                        clearConsole();
                    }
                }
                System.out.println("Oh noooo! Your little sister has disappeared!!");
                System.out.println("You dont know where she is and you are going to search her..");
                System.out.println("There are maybe some clues in the city.");
                chapter[0] = false;
                chapter[1] = true;
                gameMenu = true;
                proceedBreak();
            }

            while(gameMenu){
                System.out.println("What do you want to do?");
                System.out.println("1. Show Stats");
                System.out.println("2. Show items");
                System.out.println("3. Continue");
                System.out.println("4. Quit");
                choice = scan.next();
                clearConsole();

                switch(choice){
                    case "1":
                        protagonist.showStats();
                        proceedBreak();
                        break;
                    case "2":
                        protagonist.showItem();
                        proceedBreak();
                        break;
                    case "3":
                        gameMenu = false;
                        clearConsole();
                        break;
                    case "4":
                        gameOver();
                        break;
                    default:
                        clearConsole();
                        break;
                }
            }

            if(chapter[1]){
                String[] inventory = new String[protagonist.inventory.length];
                inventory = protagonist.inventory;

                for (String item:inventory){
                    if(item != null){
                        if (item.equals("Rainbow Orb")) {
                            lastChapter = true;
                        }
                    }

                }
                if(lastChapter){
                    System.out.println("Where do you want to go?");
                    System.out.println("1. You go to the flaming mountain");
                    System.out.println("2. You go to the great deep sea");
                    System.out.println("3. You go to the mystery forest");
                    System.out.println("4. You go to the rainbow city");
                    System.out.println("5. Enter the sky castle");
                    choice = scan.next();

                    switch(choice){
                        case "1":
                            chapter[2] = true;
                            chapter[1] = false;
                            break;
                        case "2":
                            chapter[3] = true;
                            chapter[1] = false;
                            break;
                        case "3":
                            chapter[4] = true;
                            chapter[1] = false;
                            break;
                        case "4":
                            chapter[5] = true;
                            chapter[1] = false;
                            break;
                        case "5":
                            System.out.println("Are you sure? There is no way you can return after entering the Skye Castle?");
                            System.out.println("1. yes");
                            String finalAnswer = scan.next();
                            if(finalAnswer.equals("1")){
                                chapter[6] = true;
                                chapter[1] = false;
                            }
                            else{

                            }
                            break;
                        default:
                            break;
                    }
                }

                else{
                    System.out.println("Where do you want to go?");
                    System.out.println("1. You go to the flaming mountain");
                    System.out.println("2. You go to the great deep sea");
                    System.out.println("3. You go to the mystery forest");
                    System.out.println("4. You go to the rainbow city");
                    choice = scan.next();

                    switch(choice){
                        case "1":
                            chapter[2] = true;
                            chapter[1] = false;
                            break;
                        case "2":
                            chapter[3] = true;
                            chapter[1] = false;
                            break;
                        case "3":
                            chapter[4] = true;
                            chapter[1] = false;
                            break;
                        case "4":
                            chapter[5] = true;
                            chapter[1] = false;
                        default:
                            break;
                    }
                }
                gameMenu = true;
                clearConsole();
            }

            if(chapter[2]){
                String[] inventory = new String[protagonist.inventory.length];
                inventory = protagonist.inventory;
                System.out.println("You are now at the FireMountain");
                boolean entryKey = false;
                for (String item:inventory){
                    if(item != null){
                        if (item.equals("Fire Orb")) {
                            entryKey = true;
                        }
                    }

                }
                if (entryKey == false){
                    System.out.println("The heat is too high to withstand...");
                    System.out.println("Do you want to go back(1) or go further inside this Area(2)?");
                    String answer = scan.next();

                    boolean question = true;
                    while (question){
                        switch (answer){
                            case "1":
                                chapter[1] = true;
								chapter[2] = false;
                                question = false;
                                gameMenu = true;
                                clearConsole();
                                break;
                            case "2":
                                System.out.println("Because the Heat was too damn high, you got burned down to ashes");
                                System.out.println("You are DEAD!");
                                gameOver();
                                break;
                            default:
                                clearConsole();
                                break;
                        }
                    }
                }
                else if(protagonist.level > 19 && bossCounter==2){
                    bossCounter++;
                    Monster mountainBoss = new Monster("Giant Magma Worm", 200, 9, 8, 100, 100);
                    protagonist = fight(mountainBoss, protagonist);
                    System.out.print("Yeaaah!");
                    setTimeOut(500);
                    System.out.print(".");
                    setTimeOut(500);
                    System.out.print(".");
                    setTimeOut(500);
                    System.out.println(".");
                    setTimeOut(370);
                    System.out.println("You have collected all the legendary orbs");
                    System.out.println("They are reacting to each other and create a new orb!!!");
                    System.out.println("You obtained the \"Rainbow Orb\"");
                    protagonist.addItem("Rainbow Orb");
                }
                else{
                    boolean check = true;
                    System.out.println("The Fire Orb protected you from the fire and you managed to stay inside the mountain. Here are a lot of strong monsters!");
                    while(check){
                        Monster mountain1 = new Monster("Flaming Bear", 100, 4, 10, 100, 200);
                        Monster mountain2 = new Monster("Burning Ape", 90, 10, 10, 80, 240);
                        Monster mountain3 = new Monster("Lava Golem", 120, 10, 15, 60, 180);

                        Monster[] mountainMonster = new Monster[3];
                        mountainMonster[0] = mountain1;
                        mountainMonster[1] = mountain2;
                        mountainMonster[2] = mountain3;

                        System.out.println("What do you want to do?");
                        System.out.println("1. Fight");
                        System.out.println("2. Leave");
                        String answer = scan.next();
                        clearConsole();

                        switch(answer){
                            case "1":
                                int rnd = (int)(Math.random() * mountainMonster.length);
                                protagonist = fight(mountainMonster[rnd], protagonist);
                                break;
                            case "2":
                                check = false;
                                break;
                            default:
                                break;
                        }
                    }
                }

                chapter[2] = false;
                gameMenu = true;
                chapter[1] = true;
                proceedBreak();
            }

            if(chapter[3]){
                boolean entryKey = false;
                String[] inventory = new String[protagonist.inventory.length];
                inventory = protagonist.inventory;
                System.out.println("You are now at the beach.");

                for (String item:inventory){
                    if(item != null){
                        if (item.equals("Water Orb")) {
                            entryKey = true;
                        }
                    }

                }

                if(entryKey == false){
                    System.out.println("To go further you have to go inside the sea, but you can\'t swim...");
                    System.out.println("Do you want to go further(1) or go back(2)?");
                    String answer = scan.next();
                    boolean question = true;
                    while(question){
                        switch(answer){
                            case "1":
                                System.out.println("Because you can\'t swim, you have drowned inside the sea");
                                System.out.println("You are now DEAD");
                                gameOver();
                                break;
                            case "2":
                                chapter[3] = false;
                                chapter[1] = true;
                                question = false;
                                clearConsole();
                                break;
                            default:
                                break;
                        }

                    }
                }else if(protagonist.level >= 14 && bossCounter == 1){
                    Monster seaBoss = new Monster("Great Pinky Seastar", 50, 28, 19, 300, 300);
                    protagonist = fight(seaBoss, protagonist);
                    System.out.println("Congratulation! You found the Fire Orb inside the Boss");
                    protagonist.addItem("Fire Orb");
                    bossCounter++;
                    proceedBreak();
                }else{
                    System.out.println("With the power of the Water Orb you can swim deep in the sea! Here are a lot of Monsters!!!");
                    boolean check = true;
                    while(check){

                        Monster sea1 = new Monster("Iron Turtle", 40, 12, 20, 30, 100);
                        Monster sea2 = new Monster("Crab King", 20, 18, 15, 20, 80);
                        Monster sea3 = new Monster("Bloody Shark", 18, 25, 12, 25, 70);
                        Monster[] seaMonster = new Monster[3];
                        seaMonster[0] = sea1;
                        seaMonster[1] = sea2;
                        seaMonster[2] = sea3;

                        System.out.println("What do you want to do?");
                        System.out.println("1. Fight");
                        System.out.println("2. Leave");
                        String answer = scan.next();
                        clearConsole();

                        switch(answer){
                            case "1":
                                int rnd = (int)(Math.random() * seaMonster.length);
                                protagonist = fight(seaMonster[rnd], protagonist);
                                break;
                            case "2":
                                check = false;
                                break;
                            default:
                                break;
                        }

                    }
                    chapter[3] = false;
                    chapter[1] = true;
                    gameMenu = true;
                    proceedBreak();
                }


            }

            if(chapter[4]){
                boolean entryKey = false;
                String[] inventory = new String[protagonist.inventory.length];
                inventory = protagonist.inventory;
                System.out.println("You are now at the forest.");


                for (String item:inventory){
                    if(item != null){
                        if (item.equals("Life Orb")) {
                            entryKey = true;
                        }
                    }

                }
                if(entryKey == false){
                    System.out.println("There was a trap. You got damaged and lost 4HP, but you found a shiny green stone here.");
                    System.out.println("Because you lost too much blood, you have fainted.");
                    protagonist.addItem("Life Orb");
                    forestFaint = true;
					chapter[4] = false;
                    chapter[5] = true;
                }

                if(entryKey){
                    if(protagonist.level > 4 && bossCounter== 0){
                        Monster forestBoss = new Monster("King of Centaury", 13, 8, 7, 40, 40);
                        System.out.println("The demonic Monster of the mystery forest has appeared");
                        fight(forestBoss, protagonist);
                        System.out.println("You obtained the \"Water Orb\" from the Centaury King!");
                        protagonist.addItem("Water Orb");
                        bossCounter++;
                    }
                    else{
                        System.out.println("You entered the mystery Cage with the help of the Life Orb! Here are a lot of Monsters!!!");
                        boolean check = true;
                        while(check){
                            Monster forest1 = new Monster("Red Pork", 8, 4, 1, 1, 10);
                            Monster forest2 = new Monster("Green Rabbit", 6, 6, 1, 2, 6);
                            Monster forest3 = new Monster("Blue Deer", 7, 5, 1, 1, 8);

                            Monster[] forestMonster = new Monster[3];
                            forestMonster[0] = forest1;
                            forestMonster[1] = forest2;
                            forestMonster[2] = forest3;

                            System.out.println("What do you want to do?");
                            System.out.println("1. Fight");
                            System.out.println("2. Leave");
                            String answer = scan.next();
                            clearConsole();

                            switch(answer){
                                case "1":
                                    int rnd = (int)(Math.random() * forestMonster.length);
                                    protagonist = fight(forestMonster[rnd], protagonist);
                                    break;
                                case "2":
                                    check = false;
                                    break;
                                default:
                                    break;
                            }

                        }
                    }
                }
                chapter[4] = false;
                chapter[1] = true;
                gameMenu = true;
                proceedBreak();

            }

            if(chapter[5]){
                boolean shop = false;

                if(forestFaint){
                    firstTimeCity = false;
                    setTimeOut(500);
                    System.out.print(".");
                    setTimeOut(500);
                    System.out.print(".");
                    setTimeOut(500);
                    System.out.println(".");

                    protagonist.fullHeal();

                    setTimeOut(500);
                    System.out.print(".");
                    setTimeOut(500);
                    System.out.print(".");
                    setTimeOut(500);
                    System.out.println(".");
                    setTimeOut(500);
                    System.out.println("You woke up finding yourself on the bed in the hospital");
                    setTimeOut(1500);
                    System.out.println("Nurse: \"You are very lucky! The hunters noticed some strange sound and checked it out.\"");
                    setTimeOut(1500);
                    System.out.println("Nurse: \"They found you full with blood fainted out and brought you as fast as possible here.\"");
                    setTimeOut(1350);
                    System.out.println("Nurse: \"Now you are healed and you can leave.\"");
                    setTimeOut(2500);
                    System.out.println("You are leaving the hospital and you noticed that the strange stone is still in your pocket");
                    setTimeOut(1500);
                    System.out.println("Now looking clearly at the Stone, you can remember that this is the \"Life Orb\"!");
                    System.out.println("It is one of the three legendary magic orbs. With this orb you are protected from life sucking magic.\n");
                    setTimeOut(1500);
                    forestFaint=false;
                }
                if(firstTimeCity){
                    System.out.println("You are now in the City. You can see a hospital and a shop here.");
                    System.out.println("The market place is very crowded and you decided to go there to take a look.");
                    System.out.println("The people here tells you, that there is a curse all over the kingdom and a lot of monsters are kidnapping children for some reason..");
                    System.out.println("They said that in the mystery forest the monster are inside a cage, but the cage is protected by magic barrier sucking the energy out of human body.");
                    firstTimeCity=false;
                    System.out.println();
                    setTimeOut(200);
                }



                System.out.println("Rainbow City");
                System.out.println("What do you want to do?");
                System.out.println("1. Go to the hospital(heal)");
                System.out.println("2. Go to the shop");
                System.out.println("3. Leave Rainbow City");
                String destinationChoice = scan.next();
                clearConsole();
                switch(destinationChoice){
                    case "1":
                        protagonist.fullHeal();
                        proceedBreak();
                        break;
                    case "2":
                        shop = true;
                        break;
                    case "3":
                        chapter[5] = false;
                        chapter[1] = true;
                        gameMenu = true;
                        proceedBreak();
                        break;
                    default:
                        break;
                }

                while(shop){

                    System.out.println("What do you want to buy?");
                    System.out.println("1. Leave the shop");
                    System.out.println("2. Holy Sword (+15 Atk|+10 Def|+10 HP) 60 Zenny");
                    System.out.println("3. Demonic Blade (+30 Atk|+18 Def|+20 HP) 150 Zenny");
                    System.out.println("4. Warping Heartspike (+44 Atk|+26 Def|+35 HP) 280 Zenny");
                    System.out.println("5. Light Sabre (+60 Atk|+60 Def|+60 HP) 666 Zenny");

                    String shopAnswer = scan.next();
                    clearConsole();

                    switch(shopAnswer){
                        case "1":
                            shop = false;
                            break;
                        case "2":
                            if(protagonist.money >= 60){
                                protagonist.money = protagonist.money - 60;
                                protagonist.changeWeapon(holySword);
                                System.out.println("You have bought the Holy Sword.");
                            }
                            else{
                                System.out.println("You don\'t have enough money!");
                            }
                            break;
                        case "3":
                            if(protagonist.money >= 150){
                                protagonist.money = protagonist.money - 150;
                                protagonist.changeWeapon(demonicSword);
                                System.out.println("You have bought the Demonic Blade.");
                            }
                            else{
                                System.out.println("You don\'t have enough money!");
                            }
                            break;
                        case "4":
                            if(protagonist.money >= 280){
                                protagonist.money = protagonist.money - 280;
                                protagonist.changeWeapon(warpSpike);
                                System.out.println("You have bought the Warping Heartpike.");
                            }
                            else{
                                System.out.println("You don\'t have enough money!");
                            }
                            break;
                        case "5":
                            if(protagonist.money >= 666){
                                protagonist.money = protagonist.money - 666;
                                protagonist.changeWeapon(lightSabre);
                                System.out.println("You have bought the Light Sabre.");
                            }
                            else{
                                System.out.println("You don\'t have enough money!");
                            }
                            break;
                        default:
                            break;
                    }

                }
            }

            if(chapter[6]){
                Monster finalEndBoss = new Monster("Demonic King", 100, 60, 20, 1000, 5000);
                System.out.println("You are now in the Castle! All the orbs are shining now and the End Boss has appeared!");
                protagonist = fight(finalEndBoss, protagonist);
                System.out.println("You finally defeated " + finalEndBoss.name + " and all the missing childrens are free now!");
                gameOver();
            }
        }
    }



    private static void printHeader(){
        System.out.println(""+
                "                 .v~\n" +
                "               .(W\n" +
                "              /<M.\n" +
                "\\~b__________/$@|\\----------------------------------------------------------.\n" +
                " >@)$$$$$$$$($( )#H>====================================================----->\n" +
                "/_p~~~~~~~~~~\\$@|/----------------------------------------------------------'\n" +
                "              \\<M`\n" +
                "               `(B\n" +
                "                 `?_\n"+
                "  _____ _        _              _____            _   _             \n" +
                " / ____| |      | |            |  __ \\          | | (_)            \n" +
                "| (___ | |_ ___ | | ___ _ __   | |  | | ___  ___| |_ _ _ __  _   _ \n" +
                " \\___ \\| __/ _ \\| |/ _ \\ '_ \\  | |  | |/ _ \\/ __| __| | '_ \\| | | |\n" +
                " ____) | || (_) | |  __/ | | | | |__| |  __/\\__ \\ |_| | | | | |_| |\n" +
                "|_____/ \\__\\___/|_|\\___|_| |_| |_____/ \\___||___/\\__|_|_| |_|\\__, |\n" +
                "                                                              __/ |\n" +
                "                                                             |___/ \n"+
                "   )       )       )        )       )\n"+
                "  ) \\     ) \\     ) \\      ) \\     ) \\\n"+
                " / ) (   / ) (   / ) (    / ) (   / ) ( \n"+
                " \\(_)/   \\(_)/   \\(_)/    \\(_)/   \\(_)/\n");
    }

    private static void gameOver(){
        System.out.println("Game Over");
        System.exit(0);
    }

    private static Person fight(Monster monster, Person person){
        Monster enemy = monster;
        Person character = person;
        boolean isFight = true;

        while(isFight){
                System.out.println("There is a " + enemy.name +"(" + enemy.hp +")");
                System.out.println("1. Attack!");
                System.out.println("2. Flee..");
                String answer = scan.next();
                clearConsole();

                switch(answer){
                    case "1":
                        System.out.println("You attack " + enemy.name + "(" + enemy.hp + "HP)!");
                        enemy.damageMonster(character.totalAtk);
                        setTimeOut(1000);
                        if(enemy.hp > 0){
                            System.out.print("The monster(" + enemy.hp + "HP) is attacking you now!!!");
                            setTimeOut(500);
                            System.out.print(".");
                            setTimeOut(500);
                            System.out.print(".");
                            setTimeOut(500);
                            System.out.println(".");
                            character.getDamage(enemy.atk);
                            proceedBreak();
                        }
                        else {
                            System.out.println("You defeated " + enemy.name);
                            isFight = false;
                            character.getMoney(enemy.money);
                            System.out.println("You get " + enemy.money + " Zenny");
                            character.getEXP(enemy.exp);
                            proceedBreak();
                        }
                        break;
                    case "2":
                        if(enemy.name.equals("Giant Magma Worm") || enemy.name.equals("Great Pinky Seastar") || enemy.name.equals("King of Centaury") || enemy.name.equals("")){
                            System.out.println("You can\'t flee from a Bossfight!!");
                            proceedBreak();
                        }
                        else{
                            System.out.print("You try to flee");
                            setTimeOut(500);
                            System.out.print(".");
                            setTimeOut(500);
                            System.out.print(".");
                            setTimeOut(500);
                            System.out.println(".");
                            setTimeOut(1000);
                            int randomNum = (int)(Math.random() * 2);
                            if(randomNum == 1){
                                System.out.println("You have fleed successful");
                                proceedBreak();
                                isFight = false;
                            }else{
                                System.out.println("You failed to flee!");
                                setTimeOut(500);
                                System.out.print("The monster(" + enemy.hp + "HP) is attacking you now!!!");
                                setTimeOut(500);
                                System.out.print(".");
                                setTimeOut(500);
                                System.out.print(".");
                                setTimeOut(500);
                                System.out.println(".");
                                character.getDamage(enemy.atk);
                                proceedBreak();
                            }
                        }
                        break;
                    default:
                        break;
                }

            clearConsole();
        }

        return character;

    }

    private static void clearConsole(){
        System.out.print("\033[H\033[2J");
		//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private static void proceedBreak(){
        try{
            System.out.println("To proceed, please confirm with Enter");
            System.in.read();
            clearConsole();
        }catch(IOException e){
            System.out.println("Error reading from user");
        }
    }

    private static void setTimeOut(int time){
        try {
            Thread.sleep(time);
        }
        catch(InterruptedException ex) {

        }
    }
}


