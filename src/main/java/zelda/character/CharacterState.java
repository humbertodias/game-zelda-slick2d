package zelda.character;

/**
 * This is the superclass for states.
 */
public abstract class CharacterState {

    protected Character karacter;
    protected String name;

    public CharacterState(Character karacter) {
        this.karacter = karacter;
        karacter.resetAnimationCounter();
    }

    public void handleInput() {
    }

    public void handleAnimation() {
    }

    @Override
    public String toString() {
        return name;
    }
}
