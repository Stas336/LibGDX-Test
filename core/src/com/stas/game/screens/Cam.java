package com.stas.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class Cam
{
   /* private PerspectiveCamera camera;
    private int lastx, lasty;

    public void init(){
        lastx = Gdx.input.getX();
        lasty = Gdx.input.getY();
        camera = new PerspectiveCamera(90, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.far = 300f;
        camera.near = 0.15f;
        camera.translate(8, 64, 8);
        camera.lookAt(0, 0, 0);
        camera.fieldOfView = 75;
        camera.
    }

    public void mouselook(float deltaX, float deltaY){
        Vector3 zxp = camera.position.cpy();
        Vector3 zxd = camera.direction.cpy();
        zxp.y = 0;
        zxd.y = 0;
        zxd.add(zxp);
        float len = Math.abs(zxp.cpy().sub(zxd).len());
        if (len<0.05){
            if (camera.direction.y>0 && deltaY<0){
                deltaY=0;
            }
            if (camera.direction.y<0 && deltaY>0){
                deltaY=0;
            }
        }

        Vector3 v90 = camera.direction.cpy();
        Quaternion q = new Quaternion(camera.up, 90);
        q.transform(v90);
        v90.y = 0;
        Quaternion qUpDown = new Quaternion(v90, deltaY);
        Quaternion qLeftRight = new Quaternion(camera.up, -deltaX);
        qUpDown.transform(camera.direction);
        qLeftRight.transform(camera.direction);
    }

    public void upd(){
        if (Gdx.input.isCursorCatched()||Gdx.input.isPeripheralAvailable(Input.Peripheral.MultitouchScreen)){
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            int cx = Gdx.graphics.getWidth()/2;
            int cy = Gdx.graphics.getHeight()/2;
            int deltaX = lastx-x;
            int deltaY = lasty-y;
            lastx = x;
            lasty = y;
            mouselook(-deltaX*2,-deltaY*2);
            int max = 100;
            if (x<cx-max||x>cx+max||y<cy-max||y>cy+max){
                Gdx.input.setCursorPosition(cx, cy);
                lastx = cx;
                lasty = cy;
            }
        }
        camera.update();
    }
    public PerspectiveCamera getCamera()
    {
        return camera;
    }*/
}
