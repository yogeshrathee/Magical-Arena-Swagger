package org.example.magicalarenagamerun.services;

import org.example.magicalarenagamerun.models.Player;

import java.util.Scanner;

public class Game {
    protected Player playerA;
    protected Player playerB;
    protected Dice dice;
    private String resultMessage;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
        this.resultMessage = "";
    }

    public void start() {
        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() < playerB.getHealth()) {
                attack(playerA, playerB);
                if (playerB.isAlive()) {
                    attack(playerB, playerA);
                }
            } else {
                attack(playerB, playerA);
                if (playerA.isAlive()) {
                    attack(playerA, playerB);
                }
            }
        }
        displayResult();
    }

    public void attack(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defenseRoll = dice.roll();
        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;
        int damageTaken = Math.max(0, attackDamage - defenseStrength);
        defender.reduceHealth(damageTaken);

        resultMessage += attacker.getName() + " rolls " + attackRoll + ", " + defender.getName() + " rolls " + defenseRoll + "\n";
        resultMessage += "Attack damage: " + attackDamage + ", Defense strength: " + defenseStrength + "\n";
        resultMessage += defender.getName() + " health reduced by " + damageTaken + " to " + defender.getHealth() + "\n\n";
    }

    //manual
    public void manualStart() {
        Scanner scanner = new Scanner(System.in);

        while (playerA.isAlive() && playerB.isAlive()) {
            System.out.println(playerA.getName() + " vs " + playerB.getName());
            System.out.println(playerA.getName() + "'s health: " + playerA.getHealth());
            System.out.println(playerB.getName() + "'s health: " + playerB.getHealth());

            // Player A attacks first
            System.out.println("Enter attack roll for " + playerA.getName() + ": ");
            int attackRollA = scanner.nextInt();

            System.out.println("Enter defense roll for " + playerB.getName() + ": ");
            int defenseRollB = scanner.nextInt();

            attack(playerA, playerB, attackRollA, defenseRollB);

            if (playerB.isAlive()) {
                // Player B counterattacks
                System.out.println("Enter attack roll for " + playerB.getName() + ": ");
                int attackRollB = scanner.nextInt();

                System.out.println("Enter defense roll for " + playerA.getName() + ": ");
                int defenseRollA = scanner.nextInt();

                attack(playerB, playerA, attackRollB, defenseRollA);
            }
        }

        displayResult();
    }

    public void attack(Player attacker, Player defender, int attackRoll, int defenseRoll) {
        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;
        int damage = Math.max(0, attackDamage - defenseStrength);

        defender.receiveDamage(damage);
        System.out.println(attacker.getName() + " rolls " + attackRoll + ", " + defender.getName() + " rolls " + defenseRoll);
        System.out.println("Attack damage: " + attackDamage + ", Defense strength: " + defenseStrength);
        System.out.println(defender.getName() + " health reduced by " + damage + " to " + defender.getHealth() + "\n");
    }

    protected void displayResult() {
        if (playerA.isAlive()) {
            resultMessage += playerA.getName() + " wins!";
        } else {
            resultMessage += playerB.getName() + " wins!";
        }
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }
}
