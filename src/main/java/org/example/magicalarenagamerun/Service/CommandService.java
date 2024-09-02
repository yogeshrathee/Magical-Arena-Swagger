package org.example.magicalarenagamerun.Service;

import org.springframework.stereotype.Service;

@Service
public class CommandService {

    public void openCMDAndRunJar() {
        try {
            // Opens the Command Prompt, runs the JAR file, and waits for a key press before exiting
            String command = "cmd.exe /c start cmd /k \"java -jar MagicalArena.jar & cmd\"";
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
