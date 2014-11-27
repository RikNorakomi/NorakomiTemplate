package com.norakomi.template;



import static com.norakomi.template.helpers.Variables.DEBUG;
import static com.norakomi.template.helpers.Variables.VIEWPORT_HEIGHT;
import static com.norakomi.template.helpers.Variables.VIEWPORT_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.norakomi.template.gui.DebugHud;
import com.norakomi.template.gui.GuiButtons;
import com.norakomi.template.helpers.InputHandler_keyboard;
import com.norakomi.template.helpers.InputHandler_touch;


public class GameScreen implements Screen {
	
	NorakomiGame game;
	
	private OrthographicCamera cam;
	
	private InputHandler_keyboard inputHandlerKeyboard;
	private InputHandler_touch inputHandlerTouch;
	
	private DebugHud debugHud;
	private SpriteBatch sb, sbGui;
	private ShapeRenderer sr;
	private BitmapFont font;
	private GuiButtons guiButtons;
	



	public GameScreen(NorakomiGame game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		// initialize level, setup camera & map
		initLevelVariables();
		// createMap();
		createCamera();
		
		// create fonts
		font = new BitmapFont();
		font.setScale(0.5f);
		font.setColor(Color.BLUE);
		
		// create render objects
		sr = new ShapeRenderer();
		sb = new SpriteBatch();
		sbGui = new SpriteBatch();
		
		
		guiButtons = new GuiButtons(sbGui, sr);
		debugHud = new DebugHud(font);
		
		
		sb.setProjectionMatrix(cam.combined);

		inputHandlerTouch = new InputHandler_touch(cam);
	//	inputHandlerKeyboard = new InputHandler_keyboard();
		
	}

	@Override
	public void render(float delta) {
		//  Clear pixel every frame update
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	
		handleTouchEvents();
		guiButtons.renderer(sbGui, sr);
		
		// set debug hud
		if (DEBUG) debugHud.render(sb);
		
		cam.update();
	}

	public void handleTouchEvents() {
		System.out.println("handletoucheventss");
	
		if (Gdx.input.isTouched()) {
			inputHandlerTouch.update();
			
		} else {
			inputHandlerTouch.touchRelease();
		}
	}
	public void createCamera() {
		cam = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		cam.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		cam.position.set((VIEWPORT_WIDTH / 2), (VIEWPORT_HEIGHT / 2), 0);
		

	}
	
	public void createMap() {
		// code for loading (tmx) tiledmaps go here
	}
	
	public void initLevelVariables() {
		// enter all level variables for level start here
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
