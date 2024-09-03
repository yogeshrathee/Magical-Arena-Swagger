package org.example.magicalarenagamerun.controller;

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
    @PostMapping("/startGame")
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
}
