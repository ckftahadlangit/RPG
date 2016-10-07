package cute;

import java.util.*;

public class Main {

    private Random rand = new Random();

    Main() {
        rand = new Random();
    }

    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean duel(Character isko, Character trial) {
        sleep(2000);
        int damage = isko.attack();
        System.out.println("-+=====> " + isko.getName() + " ATTACKS " + trial.getName() + " <=====+-");
        int remainingHp = trial.takeDamage(damage, randInt(0, 20));
        if (remainingHp <= 0) {
            System.out.printf("\t\t%s killed %s!\n", isko.getName(), trial.getName());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("   _   _____   _____ _  _ _____ _   _ ___ ___    ___  ___   ___ ___ _  _____  ");
        System.out.println("  /_\\ |   \\ \\ / / __| \\| |_   _| | | | _ \\ __|  / _ \\| __| |_ _/ __| |/ / _ \\ ");
        System.out.println(" / _ \\| |) \\ V /| _|| .` | | | | |_| |   / _|  | (_) | _|   | |\\__ \\ ' < (_) |");
        System.out.println("/_/ \\_\\___/ \\_/ |___|_|\\_| |_|  \\___/|_|_\\___|  \\___/|_|   |___|___/_|\\_\\___/ \n\n");

        Main user = new Main();
        Character isko1 = new Scions("SCIONS", 1);
        Character isko2 = new Stallions("STALLIONS", 1);
        Character isko3 = new Tycoons("TYCOONS", 1);
        Character isko4 = new Bullets("BULLETS", 1);

        Character trial1 = new Quizzes("QUIZZES", 1);
        Character trial2 = new Exams("EXAMS", 2);
        Character trial3 = new Projects("PROJECTS", 3);
        Character trial4 = new Theses("THESES", 4);

        Character[] isko = {isko1, isko2, isko3, isko4};
        Character[] trial = {trial1, trial2, trial3, trial4};
        Character player = isko[user.randInt(0, 3)];

        System.out.println("\t\t==== ISKOLARS ====");
        System.out.printf("%s\tAttack: %d\n", isko1, isko1.attack());
        System.out.printf("%s\tAttack: %d\n", isko2, isko2.attack());
        System.out.printf("%s\tAttack: %d\n", isko3, isko3.attack());
        System.out.printf("%s\tAttack: %d\n\n", isko4, isko4.attack());

        System.out.println("\t\t==== MONSTERS ====");
        System.out.printf("Level 1 : %s\tAttack: %d\n", trial1, trial1.attack());
        System.out.printf("Level 2 : %s\tAttack: %d\n", trial2, trial2.attack());
        System.out.printf("Level 3 : %s\tAttack: %d\n", trial3, trial3.attack());
        System.out.printf("Level 4 : %s\tAttack: %d\n\n", trial4, trial4.attack());
        user.sleep(4000);
        System.out.println("Picking a random Iskolar...");
        user.sleep(500);
        Game(player,trial,user);
    }

    public static void Game(Character player, Character[] trial, Main user) {

        int count = 0, i = 0;
        user.sleep(2000);
        System.out.printf("Challengers:\n \t%s\tAttack: %d\n\t%s\tAttack: %d\n", player, player.attack(), trial[i], trial[i].attack());
        user.sleep(2000);
        boolean iskoVsTrial = false;
        boolean trialVsIsko = false;
        while (!iskoVsTrial) {
            System.out.println("Round " + ++count);
            iskoVsTrial = user.duel(player, trial[i]);
            System.out.printf("Status:\n \t%s\n\t%s\n", player, trial[i]);
            if (iskoVsTrial) {
                user.sleep(4000);
                System.out.printf("\n\n\t\tLevel %d cleared!\n", (i + 1));
                System.out.println("\t\tIsko leveled up!\n");
                player.setHp(30);
                player.setLevel(1);
                i++;
                if (i == 4) {
                    break;
                }
                user.sleep(2000);
                System.out.printf("Challengers:\n \t%s\tAttack: %d\n\t%s\tAttack: %d\n", player, player.attack(), trial[i], trial[i].attack());
                user.sleep(2000);
                iskoVsTrial = !true;
            }
            trialVsIsko = user.duel(trial[i], player);
            System.out.printf("Status:\n \t%s\n\t%s\n", player, trial[i]);
            if (trialVsIsko) {
                break;
            }
            System.out.println("------------------------------------------");
        }
        System.out.println("================= Game Over!================");
        if (trialVsIsko) {
            System.out.printf("Winner: %s\nLoser: %s", trial[i].getName(), player.getName());
        } else {
            System.out.printf("Winner: %s\nLoser: %s", player.getName(), trial[i-1].getName());
        }
    }
}