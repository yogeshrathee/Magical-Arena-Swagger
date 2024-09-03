package org.example.magicalarenagamerun.controller;

import org.example.magicalarenagamerun.Manual.ManualAttackRequest;
import org.example.magicalarenagamerun.models.Player;
import org.example.magicalarenagamerun.services.Game;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(tags = "Game Management")
public class GameController {

    private final Map<String, Player> players = new HashMap<>();
    private Game manualGame;
    private StringBuilder manualGameOutput;

    @ApiOperation(value = "Set Player 1", notes = "Sets the details for Player 1")
    @PostMapping("/player1")
    public String setPlayer1(
            @ApiParam(value = "Name of the player", required = true) @RequestParam String name,
            @ApiParam(value = "Health of the player", required = true) @RequestParam int health,
            @ApiParam(value = "Strength of the player", required = true) @RequestParam int strength,
            @ApiParam(value = "Attack of the player", required = true) @RequestParam int attack) {
        players.put("player1", new Player(name, health, strength, attack));
        return "Player 1 set successfully";
    }

    @ApiOperation(value = "Set Player 2", notes = "Sets the details for Player 2")
    @PostMapping("/player2")
    public String setPlayer2(
            @ApiParam(value = "Name of the player", required = true) @RequestParam String name,
            @ApiParam(value = "Health of the player", required = true) @RequestParam int health,
            @ApiParam(value = "Strength of the player", required = true) @RequestParam int strength,
            @ApiParam(value = "Attack of the player", required = true) @RequestParam int attack) {
        players.put("player2", new Player(name, health, strength, attack));
        return "Player 2 set successfully";
    }

    @ApiOperation(value = "Start a new game", notes = "Starts a new game with the provided player details")
    @PostMapping("/Automatic-Start")
    public String startGame() {
        Player playerA = players.get("player1");
        Player playerB = players.get("player2");

        if (playerA == null || playerB == null) {
            return "Player details are incomplete. Please set details for both players.";
        }

        Game game = new Game(playerA, playerB);
        game.start();

        return game.getResultMessage();
    }


    //manual

    @PostMapping("/Manual-Start")
    public String startManualGame() {
        Player playerA = players.get("player1");
        Player playerB = players.get("player2");

        if (playerA == null || playerB == null) {
            return "Player details are incomplete. Please set details for both players.";
        }

        manualGame = new Game(playerA, playerB);
        manualGameOutput = new StringBuilder();

        return "Manual game started. You can now start entering attack and defense values.";
    }

    @PostMapping("/Manual-Play")
    public String playManualGame(
            @ApiParam(value = "Attack roll for Player A", required = true) @RequestParam int attackRollA,
            @ApiParam(value = "Defense roll for Player B", required = true) @RequestParam int defenseRollB,
            @ApiParam(value = "Attack roll for Player B", required = true) @RequestParam int attackRollB,
            @ApiParam(value = "Defense roll for Player A", required = true) @RequestParam int defenseRollA) {

        if (manualGame == null) {
            return "No manual game in progress. Please start a new game.";
        }

        Player playerA = manualGame.getPlayerA();
        Player playerB = manualGame.getPlayerB();

        if (!playerA.isAlive() || !playerB.isAlive()) {
            return "The game has ended. Please start a new game.";
        }

        // Process Player A's attack on Player B
        int attackDamageA = playerA.getAttack() * attackRollA;
        int defenseStrengthB = playerB.getStrength() * defenseRollB;
        int damageToB = Math.max(0, attackDamageA - defenseStrengthB);

        playerB.receiveDamage(damageToB);

        manualGameOutput.append(playerA).append(" rolls ").append(attackRollA)
                .append(", ").append(playerB).append(" rolls ").append(defenseRollB).append("\n")
                .append("Attack damage: ").append(attackDamageA)
                .append(", Defense strength: ").append(defenseStrengthB).append("\n")
                .append(playerB).append(" health reduced by ").append(damageToB)
                .append(" to ").append(playerB.getHealth()).append("\n\n");

        if (!playerB.isAlive()) {
            manualGameOutput.append(playerA.getName()).append(" wins!\n");
            return manualGameOutput.toString(); // End the game
        }

        // Process Player B's attack on Player A
        int attackDamageB = playerB.getAttack() * attackRollB;
        int defenseStrengthA = playerA.getStrength() * defenseRollA;
        int damageToA = Math.max(0, attackDamageB - defenseStrengthA);

        playerA.reduceHealth(damageToA);

        manualGameOutput.append(playerB).append(" rolls ").append(attackRollB)
                .append(", ").append(playerA).append(" rolls ").append(defenseRollA).append("\n")
                .append("Attack damage: ").append(attackDamageB)
                .append(", Defense strength: ").append(defenseStrengthA).append("\n")
                .append(playerA).append(" health reduced by ").append(damageToA)
                .append(" to ").append(playerA.getHealth()).append("\n\n");

        if (!playerA.isAlive()) {
            manualGameOutput.append(playerB.getName()).append(" wins!\n");
            return manualGameOutput.toString(); // End the game
        }

        return manualGameOutput.toString();
    }

    @GetMapping("/Manual-Result")
    public String getManualGameResult() {
        if (manualGame == null) {
            return "No manual game in progress. Please start a new game.";
        }

        if (manualGame.getPlayerA().isAlive() && manualGame.getPlayerB().isAlive()) {
            return "The game is still in progress.";
        }

        return manualGameOutput.toString();
    }
}
