package zelda.items;

import java.awt.Rectangle;
import zelda.engine.GObject;
import zelda.engine.Game;

/**
 *
 *
 */
public class GuiHeart extends GObject {

    private final static String[] fullAnimation = {
        "full"
    };

    private final static String[] emptyAnimation = {
        "empty"
    };

    public final static int HEART_LENGTH = 5;

    private static int i = 0;

    private static GuiHeart[] hearts = new GuiHeart[HEART_LENGTH];

    private boolean full = true;

    public GuiHeart(Game game, int x, int y) {

        super(game, x, y, 11, 10, "/images/guihearts2.png");
        spriteLoc.put("full", new Rectangle(0, 0, 11, 10));
        spriteLoc.put("empty", new Rectangle(11, 0, 11, 10));

        sprite.setSprite(spriteLoc.get("full"));
        setAnimation(fullAnimation);

        z = 2;

        screenAdjust = false;
        checkcollision = false;
        liquid = true;

        if (i < HEART_LENGTH) {
            hearts[i] = this;
            i++;
        }
    }

    @Override
    public void preAnimation() {

        int empty = HEART_LENGTH - game.getLink().getHealth();

        //System.out.println(empty);
        for (int j = 0; j < HEART_LENGTH; j++) {
            if (j >= (HEART_LENGTH - empty)) {
                hearts[j].setFull(false);
            } else {
                hearts[j].setFull(true);
            }
        }

        if (full) {
            setAnimation(fullAnimation);
        } else {
            setAnimation(emptyAnimation);
        }
    }

    public void setFull(boolean full) {

        this.full = full;
    }

    public static void clear() {

        i = 0;
    }
}
