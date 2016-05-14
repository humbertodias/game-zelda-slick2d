package zelda.enemy.armos;

import zelda.character.Direction;
import zelda.character.Character;
import zelda.character.CharacterState;

/**
 *
 *
 */
public class TransState extends CharacterState {

    private final String[] animationHit = {"hit 1", "hit 2", "hit 3", "hit 4", "hit 5", "hit 6", "hit 7", "hit 8", "hit 9", "hit 10"};

    private final Direction direction;

    public TransState(Character armosKnight, Direction direction) {
        super(armosKnight);
        name = "TransState";
        karacter.setAnimationInterval(10);

        this.direction = direction;
    }

    public void left() {
        karacter.setAnimation(animationHit);
        karacter.setX(karacter.getX() + 8);
    }

    public void right() {
        karacter.setAnimation(animationHit);
        karacter.setX(karacter.getX() - 8);
    }

    public void up() {
        karacter.setAnimation(animationHit);
        karacter.setY(karacter.getY() + 8);
    }

    public void down() {
        karacter.setAnimation(animationHit);
        karacter.setY(karacter.getY() - 8);
    }

    @Override
    public void handleAnimation() {
        int animationCounter = karacter.getAnimationCounter();

        if (animationCounter == karacter.getAnimation().length) {
            karacter.setAnimationInterval(90);
            karacter.setState(new AttackState(karacter));
        }

        switch (direction) {
            case UP:
                down();
                break;

            case DOWN:
                up();
                break;

            case LEFT:
                right();
                break;

            case RIGHT:
                left();
                break;
        }
    }
}
