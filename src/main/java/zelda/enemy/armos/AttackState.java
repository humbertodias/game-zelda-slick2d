package zelda.enemy.armos;

import zelda.character.Character;
import zelda.character.CharacterState;

/**
 *
 * 
 */
public class AttackState extends CharacterState {

    private final String[] animation = {
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };

    private static final int WALK_SPEED = 5;

    private final int oldX, oldY;

    private final long oldAnimationInterval;

    public AttackState(Character armosKnight) {

        super(armosKnight);
        name = "AttackState";

        armosKnight.setAnimationInterval(90);

        oldAnimationInterval = armosKnight.getAnimationInterval();

        oldX = armosKnight.getX();
        oldY = armosKnight.getY();
    }

    public void handleInput() {

        switch (karacter.getDirection()) {
            case UP:
                animation();
                break;

            case DOWN:
                animation();
                break;

            case LEFT:
                animation();
                break;

            case RIGHT:
                animation();
                break;
        }
    }

    public void animation() {

        karacter.setAnimation(animation);

    }
}
