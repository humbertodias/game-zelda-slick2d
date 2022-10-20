package zelda.scene;

import java.awt.Polygon;
import java.awt.Rectangle;
import zelda.enemy.armos.ArmosKnight;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.items.Warp;
import zelda.character.Direction;

/**
 *
 *
 */
public class ArmosScene extends ZeldaScene {

    private final Polygon leftTreeline, RightTreeline, deadTree;

    private final Rectangle warpExit = new Rectangle(232, 270, 16, 16);

    private final Warp warp = new Warp(game, 232, 270);

    private boolean warpVisible = false;

    public ArmosScene(Game game, String entrance) {

        super(game, "/images/battle-scene.png", "ArmosScene");

        exits.add(warpExit);

        int[] axpos = {
            239, 4, 3, 4, 240, 224, 205, 199, 197, 179, 175, 171, 146, 107, 104, 87, 77, 74, 54, 70, 87, 101, 109, 119,
            136, 170, 190, 239, 3, 4, 239, 223, 207, 197, 200, 184, 173, 173, 153, 126, 109, 102, 99, 81, 81, 73, 57,
            55, 71, 80, 93, 101, 126, 130, 165, 197, 211, 226, 241, 237
        };
        int[] aypos = {
            4, 5, 399, 509, 510, 501, 484, 474, 447, 434, 420, 396, 386, 387, 372, 346, 326, 299, 281, 262, 186, 166,
            142, 124, 99, 116, 111, 4, 5, 508, 510, 499, 486, 475, 452, 434, 424, 401, 386, 391, 389, 377, 349, 338,
            323, 298, 291, 267, 243, 216, 177, 162, 123, 100, 110, 74, 71, 71, 77, 4
        };

        leftTreeline = new Polygon(axpos, aypos, aypos.length);

        int[] bxpos = {
            237, 508, 507, 241, 258, 273, 283, 282, 304, 327, 352, 389, 402, 402, 420, 427, 427, 442, 449, 454, 469,
            476, 473, 453, 435, 411, 406, 399, 386, 359, 322, 294, 283, 276, 260, 241, 235
        };
        int[] bypos = {
            2, 4, 507, 510, 503, 485, 475, 449, 434, 435, 435, 438, 427, 401, 385, 376, 354, 338, 325, 300, 290, 283,
            264, 245, 213, 165, 149, 120, 120, 119, 114, 96, 76, 68, 67, 73, 3
        };

        RightTreeline = new Polygon(bxpos, bypos, bypos.length);

        int[] cxpos = {
            223, 228, 241, 255, 257, 255, 240, 226, 222, 226
        };
        int[] cypos = {
            494, 484, 479, 482, 492, 505, 509, 507, 496, 484
        };

        deadTree = new Polygon(cxpos, cypos, cypos.length);

        solids.add(leftTreeline);
        solids.add(RightTreeline);
        solids.add(deadTree);

        warp.setActive();

        gameObjects.add(warp);

        // add Link
        gameObjects.add(game.getLink());

        gameObjects.add(new ArmosKnight(game, 231, 90, Direction.DOWN));
        gameObjects.add(new ArmosKnight(game, 83, 236, Direction.LEFT));
        gameObjects.add(new ArmosKnight(game, 422, 251, Direction.RIGHT));

        if (!game.getSong().equals("/sounds/boss-bgm.mp3")) {
            game.stopMusic();
            game.playMusic("/sounds/boss-bgm.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    @Override
    public void inputHook() {

        boolean dead = true;

        for (GObject obj : gameObjects) {
            if (obj instanceof ArmosKnight) {
                dead = false;
                break;
            }
        }

        if (dead && !warpVisible) {
            game.stopMusic();
            game.playMusic("/sounds/fanfare.mp3", false);

            warp.setActive();
            warpVisible = true;
        }
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {

        if (exit == warpExit && warpVisible) {
            game.setScene(new DungeonScene(game, "ArmosScene"));
        }
    }

    @Override
    public void handleSwitchScene(String entrance) {

        if (entrance.equals("CastleBasementScene")) {
            //moveScene(1,19);

            game.getLink().setXHardCore(251);
            game.getLink().setYHardCore(298);
        }
    }
}
