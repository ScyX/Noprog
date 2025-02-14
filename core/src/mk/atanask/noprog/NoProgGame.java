package mk.atanask.noprog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import mk.atanask.noprog.gameStates.GameStateManager;
import mk.atanask.noprog.gameStates.MenuState;

public class NoProgGame extends ApplicationAdapter {

    public static final int WIDTH = 540;
    public static final int HEIGHT = 860;

    private GameStateManager gsm;
    private SpriteBatch batch;

    private Music music;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gsm = new GameStateManager();

        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3")); //music
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        gsm.push(new MenuState(gsm));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
        music.dispose();
    }
}
