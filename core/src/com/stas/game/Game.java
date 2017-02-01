package com.stas.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class Game extends com.badlogic.gdx.Game {
	public Model model;
	public ModelInstance instance;
	public ModelBatch modelBatch;
	public PerspectiveCamera cam;
	public Environment environment;
	public CameraInputController camController;

	@Override
	public void create () {
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(4f,4f,4f);
		cam.lookAt(0,0,0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();
		ModelBuilder modelBuilder = new ModelBuilder();
		model = modelBuilder.createBox(5f, 5f, 5f,
				new Material(ColorAttribute.createDiffuse(Color.GREEN)),
				VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		instance = new ModelInstance(model);
		modelBatch = new ModelBatch();
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		camController = new CameraInputController(cam);
		Gdx.input.setInputProcessor(camController);
	}

	@Override
	public void render () {
		System.out.printf("Cam coordinates X:%f Y:%f Z:%f\n",cam.position.x, cam.position.y, cam.position.z);
		camController.update();
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		modelBatch.begin(cam);
		modelBatch.render(instance, environment);
		modelBatch.end();
		/*if (Gdx.input.isKeyJustPressed(Input.Keys.W))
		{
			System.out.printf("Cam coordinates X:%f Y:%f Z:%f\n",camCoordinates.x, camCoordinates.y, camCoordinates.z);
			camCoordinates.y++;
			cam.lookAt(camCoordinates);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.A))
		{
			System.out.printf("Cam coordinates X:%f Y:%f Z:%f\n",camCoordinates.x, camCoordinates.y, camCoordinates.z);
			camCoordinates.x--;
			cam.lookAt(camCoordinates);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.S))
		{
			System.out.printf("Cam coordinates X:%f Y:%f Z:%f\n",camCoordinates.x, camCoordinates.y, camCoordinates.z);
			camCoordinates.y--;
			cam.lookAt(camCoordinates);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.D))
		{
			System.out.printf("Cam coordinates X:%f Y:%f Z:%f\n",camCoordinates.x, camCoordinates.y, camCoordinates.z);
			camCoordinates.x++;
			cam.lookAt(camCoordinates);
		}*/
		cam.update();
	}
	
	@Override
	public void dispose () {
		model.dispose();
		modelBatch.dispose();
	}
}
