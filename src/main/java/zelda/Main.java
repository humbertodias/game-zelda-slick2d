package zelda;

import javax.swing.JFrame;
import zelda.engine.Game;

/**
 * https://github.com/MrHus/Zelda
 */
public class Main extends JFrame {

    private final Game game;

    private final View view;

    private final Controller ctl;

    public Main() {
        //setIgnoreRepaint(true);

        game = new Game();

        if (game.isDebug()) {
            setSize(game.getWidth(), game.getHeight());
            setLocationRelativeTo(null);
        }

        //setUndecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        view = new View(game, this);
        ctl = new Controller(game, view, this);
    }

    public static void main(String... args) {

        new Main();
    }
}
