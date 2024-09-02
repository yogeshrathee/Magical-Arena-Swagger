package org.example.magicalarenagamerun.Controller;

import org.example.magicalarenagamerun.Service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {

    @Autowired
    private CommandService commandService;

    @GetMapping("/run-magical-arena")
    public String runMagicalArena() {
        commandService.openCMDAndRunJar();
        return "CMD opened and MagicalArena.jar is running!";
    }
}
