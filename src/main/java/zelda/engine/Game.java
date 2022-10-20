package zelda.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import zelda.Main;
import zelda.link.Link;
import zelda.menu.MainMenu;
import zelda.scene.ArmosScene;
import zelda.scene.BattleScene;
import zelda.scene.CastleBasementScene;
import zelda.scene.CastleScene;
import zelda.scene.DungeonScene;
import zelda.scene.ForrestScene;
import zelda.scene.HiddenScene;
import zelda.scene.HyruleScene;
import zelda.scene.HouseScene;

/**
 * This class represents the Game: Legend of Zelda: a Link to the Past!
 */
public class Game {

    private boolean running = true;
    private boolean paused = false;
    private final boolean debug = true;

    private final boolean fullscreen = false;

    private int gameSpeed = 10;
    private final int width = 500;
    private final int height = 400;

    private final Link link;
    private Scene scene;
    private Music music;
    private SoundFx fx;

    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;
    private boolean wPressed = false;
    private boolean jPressed = false;
    private boolean kPressed = false;
    private boolean lPressed = false;
    private boolean enterPressed = false;

    private final long lastHit = System.currentTimeMillis();
    private final long lastHit2 = System.currentTimeMillis();

    public Game() {
        link = new Link(this, 100, 100);
        scene = new MainMenu(this);
    }

    public void quit() {
        if (music != null) {
            music.stop();
        }

        save();

        try {
            Thread.sleep(1000); // give it some time to shutdown the music nicely.
        } catch (InterruptedException ex) {
        }

        System.exit(0);
    }

    /**
     * Make the game play music.
     *
     * @param mp3file
     * @param loop
     */
    public void playMusic(String mp3file, boolean loop) {
        URL mp3 = Main.class.getResource(mp3file);
        music = new Music(this, mp3, mp3file, loop);
        music.play();
    }

    public void stopMusic() {
        music.stop();
    }

    public String getSong() {
        if (music == null) {
            return "";
        }

        return music.getSong();
    }

    public void playFx(String mp3file) {
        URL mp3 = Main.class.getResource(mp3file);
        fx = new SoundFx(this, mp3);
        fx.play();
    }

    public void load() {
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream("Zelda.ser");
            in = new ObjectInputStream(fis);
            SaveData data = (SaveData) in.readObject();

            Scene scn = initScene(data.getSceneName());

            setScene(scn);

            link.setHealth(data.getHealth());
            link.setRupee(data.getRupee());

            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
    }

    public Scene initScene(String sceneName) {
        Scene scn = null;

        if (sceneName.equals("HouseScene")) {
            scn = new HouseScene(this, "GameStart");
        }

        if (sceneName.equals("HyruleScene")) {
            scn = new HyruleScene(this, "HouseScene");
        }

        if (sceneName.equals("HiddenScene")) {
            scn = new HiddenScene(this, "HyruleSceneHatch");
        }

        if (sceneName.equals("ForrestScene")) {
            scn = new ForrestScene(this, "HouseScene");
        }

        if (sceneName.equals("DungeonScene")) {
            scn = new DungeonScene(this, "GameStart");
        }

        if (sceneName.equals("CastleScene")) {
            scn = new CastleScene(this, "HyruleScene");
        }

        if (sceneName.equals("CastleBasementScene")) {
            scn = new CastleBasementScene(this, "CastleScene");
        }

        if (sceneName.equals("ArmosScene")) {
            scn = new ArmosScene(this, "CastleBasementScene");
        }

        if (sceneName.equals("BattleScene")) {
            scn = new BattleScene(this, "warp");
        }

        return scn;
    }

    public void save() {
        FileOutputStream fos;
        ObjectOutputStream out;

        File file = new File("Zelda.ser");

        try {
            file.delete();
        } catch (Exception e) {
        }

        file = new File("Zelda.ser");

        try {
            fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);

            SaveData data = new SaveData(link, scene);

            out.writeObject(data);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Link getLink() {
        return link;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public synchronized Scene getScene() {
        return scene;
    }

    public synchronized void setScene(Scene scene) {
        this.scene = scene;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setaPressed(boolean aPressed) {
        this.aPressed = aPressed;
    }

    public void setdPressed(boolean dPressed) {
        this.dPressed = dPressed;
    }

    public void setjPressed(boolean jPressed) {
        this.jPressed = jPressed;
    }

    public void setkPressed(boolean kPressed) {
        this.kPressed = kPressed;
    }

    public void setlPressed(boolean lPressed) {
        this.lPressed = lPressed;
    }

    public void setsPressed(boolean sPressed) {
        this.sPressed = sPressed;
    }

    public void setwPressed(boolean wPressed) {
        this.wPressed = wPressed;
    }

    public void setEnterPressed(boolean enterPressed) {
        this.enterPressed = enterPressed;
    }

    public boolean isaPressed() {
        return aPressed;
    }

    public boolean isdPressed() {
        return dPressed;
    }

    public boolean isjPressed() {
        return jPressed;
    }

    public boolean iskPressed() {
        return kPressed;
    }

    public boolean islPressed() {
        return lPressed;
    }

    public boolean issPressed() {
        return sPressed;
    }

    public boolean iswPressed() {
        return wPressed;
    }

    public boolean isEnterPressed() {
        return enterPressed;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }
}