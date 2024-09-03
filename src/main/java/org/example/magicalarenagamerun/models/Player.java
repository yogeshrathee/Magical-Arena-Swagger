package org.example.magicalarenagamerun.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details of a player")
public class Player {
    @ApiModelProperty(value = "Name of the player")
    private String name;
    @ApiModelProperty(value = "Health of the player")
    private int health;
    @ApiModelProperty(value = "Strength of the player")
    private int strength;
    @ApiModelProperty(value = "Attack power of the player")
    private int attack;

    public Player() {
        // Default constructor for deserialization
    }

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        return this.name;
    }
    public void receiveDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }
}
