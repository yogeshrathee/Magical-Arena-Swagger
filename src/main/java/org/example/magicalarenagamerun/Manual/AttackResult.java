package org.example.magicalarenagamerun.Manual;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details of an individual attack during the manual game")
public class AttackResult {

    @ApiModelProperty(value = "Name of the attacker")
    private String attackerName;

    @ApiModelProperty(value = "Attack roll value")
    private int attackRoll;

    @ApiModelProperty(value = "Calculated attack damage")
    private int attackDamage;

    @ApiModelProperty(value = "Name of the defender")
    private String defenderName;

    @ApiModelProperty(value = "Defense roll value")
    private int defenseRoll;

    @ApiModelProperty(value = "Calculated defense strength")
    private int defenseStrength;

    @ApiModelProperty(value = "Amount of damage taken by the defender")
    private int damageTaken;

    @ApiModelProperty(value = "Defender's health after the attack")
    private int defenderHealthAfterAttack;

    // Getters and Setters
    public String getAttackerName() {
        return attackerName;
    }

    public void setAttackerName(String attackerName) {
        this.attackerName = attackerName;
    }

    public int getAttackRoll() {
        return attackRoll;
    }

    public void setAttackRoll(int attackRoll) {
        this.attackRoll = attackRoll;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getDefenderName() {
        return defenderName;
    }

    public void setDefenderName(String defenderName) {
        this.defenderName = defenderName;
    }

    public int getDefenseRoll() {
        return defenseRoll;
    }

    public void setDefenseRoll(int defenseRoll) {
        this.defenseRoll = defenseRoll;
    }

    public int getDefenseStrength() {
        return defenseStrength;
    }

    public void setDefenseStrength(int defenseStrength) {
        this.defenseStrength = defenseStrength;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getDefenderHealthAfterAttack() {
        return defenderHealthAfterAttack;
    }

    public void setDefenderHealthAfterAttack(int defenderHealthAfterAttack) {
        this.defenderHealthAfterAttack = defenderHealthAfterAttack;
    }

    @Override
    public String toString() {
        return String.format("Attack by %s (Roll: %d, Damage: %d) against %s (Roll: %d, Defense: %d). Damage Taken: %d. Defender Health After Attack: %d.",
                attackerName, attackRoll, attackDamage, defenderName, defenseRoll, defenseStrength, damageTaken, defenderHealthAfterAttack);
    }
}
