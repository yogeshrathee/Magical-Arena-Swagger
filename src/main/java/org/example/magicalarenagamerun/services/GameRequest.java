package org.example.magicalarenagamerun.services;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "GameRequest model containing player details")
public class GameRequest {

    @ApiModelProperty(value = "Name of Player A", required = true)
    private String nameA;

    @ApiModelProperty(value = "Health of Player A", required = true)
    private int healthA;

    @ApiModelProperty(value = "Strength of Player A", required = true)
    private int strengthA;

    @ApiModelProperty(value = "Attack of Player A", required = true)
    private int attackA;

    @ApiModelProperty(value = "Name of Player B", required = true)
    private String nameB;

    @ApiModelProperty(value = "Health of Player B", required = true)
    private int healthB;

    @ApiModelProperty(value = "Strength of Player B", required = true)
    private int strengthB;

    @ApiModelProperty(value = "Attack of Player B", required = true)
    private int attackB;

    // Getters and Setters
    public String getNameA() { return nameA; }
    public void setNameA(String nameA) { this.nameA = nameA; }
    public int getHealthA() { return healthA; }
    public void setHealthA(int healthA) { this.healthA = healthA; }
    public int getStrengthA() { return strengthA; }
    public void setStrengthA(int strengthA) { this.strengthA = strengthA; }
    public int getAttackA() { return attackA; }
    public void setAttackA(int attackA) { this.attackA = attackA; }
    public String getNameB() { return nameB; }
    public void setNameB(String nameB) { this.nameB = nameB; }
    public int getHealthB() { return healthB; }
    public void setHealthB(int healthB) { this.healthB = healthB; }
    public int getStrengthB() { return strengthB; }
    public void setStrengthB(int strengthB) { this.strengthB = strengthB; }
    public int getAttackB() { return attackB; }
    public void setAttackB(int attackB) { this.attackB = attackB; }
}
