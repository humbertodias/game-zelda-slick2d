package zelda.scene;

import java.awt.Rectangle;
import zelda.engine.Game;

/**
 *
 *
 */
public class CreditScene extends ZeldaScene {

    public CreditScene(Game game) {

        super(game, "/images/aftitel.png", "CreditScene");

        if (!game.getSong().equals("/sounds/credits.mp3")) {
            game.stopMusic();
            game.playMusic("/sounds/credits.mp3", true);
        }
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {

    }

    @Override
    public void handleSwitchScene(String entrance) {

    }

}
