package iutsd.scene;

import javax.media.j3d.DirectionalLight;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

public class SDLinfinie extends DirectionalLight{

	public SDLinfinie(){
		super(new Color3f(1f, 1f, 1f), new Vector3f(0, 0, 1));
	}
	
	public void rotationRelativeX(float x){
		Vector3f v = new Vector3f(0,0,0);
		this.getDirection(v);
		v.x += x;
	}
	
}
