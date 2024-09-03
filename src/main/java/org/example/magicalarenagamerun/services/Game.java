package org.example.magicalarenagamerun.services;

import org.example.magicalarenagamerun.models.Player;

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
}
