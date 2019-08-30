package iutsd.scene;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingBox;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;

public class Modele3D extends BranchGroup{
	
	BranchGroup modeleBlender;
	TransformGroup tg;
	Transform3D transformation,rotation,translation;
	private AmbientLight lumiereAmbiance;
	private Vector3f vecteur;
	
	public Modele3D(){
		super();
		modeleBlender = null;
		tg = new TransformGroup();
		tg.setCapability(ALLOW_CHILDREN_WRITE);
		tg.setCapability(ALLOW_CHILDREN_EXTEND);
		
		/*lumiereAmbiance = new AmbientLight(new Color3f(0f, 0f, 0f));
		lumiereAmbiance.setCapability(AmbientLight.ALLOW_COLOR_WRITE);
		lumiereAmbiance.setInfluencingBounds(new BoundingSphere());*/

		transformation = new Transform3D();
		vecteur=new Vector3f(0,0,0);
		this.rotationAbsolueY(3);
		tg.setTransform(transformation);
		//tg.setTransform(vecteur);
		
		this.setCapability(BranchGroup.ALLOW_DETACH);
		this.addChild(tg);
		this.addChild(lumiereAmbiance);
		this.addChild(new TransformGroup(transformation));
		//Scene3D.getMainBranchGroup().addChild(this);
	}

	public void rotationAbsolueX(double x){
		transformation.rotX(x);
	}
	public void rotationAbsolueY(double y){
		transformation.rotY(y);
	}
	public void rotationAbsolueZ(double z){
		transformation.rotZ(z);
	}	
	
	// Les translations 

	public void translationRelativeX(float x){
		this.vecteur.x=(this.vecteur.x)+x;
	}
	public void translationRelativeY(float y){
		this.vecteur.y=(this.vecteur.y)+y;
	}
	public void translationRelativeZ(float z){
		this.vecteur.z=(this.vecteur.z)+z;
	}
	
	public void translationAbsolueX(float x){
		transformation.setTranslation(new Vector3f(x,0,0));
	}
	public void translationAbsolueY(float y){
		transformation.setTranslation(new Vector3f(0,y,0));
	}
	public void translationAbsolueZ(float z){
		transformation.setTranslation(new Vector3f(0,0,z));
	}
	
	public void chargerObjet3D(File f) throws FileNotFoundException{
		if(modeleBlender == null){
			
			modeleBlender = new ObjectFile(ObjectFile.RESIZE).load(f.getPath()).getSceneGroup();
			modeleBlender.setCapability(ALLOW_DETACH);
			tg.addChild(modeleBlender);
		}
		else{
			tg.removeChild(modeleBlender);
			modeleBlender = new ObjectFile(ObjectFile.RESIZE).load(f.getPath()).getSceneGroup();
			tg.addChild(modeleBlender);
		}
	}

}
