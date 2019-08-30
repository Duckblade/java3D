package iutsd.scene;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Enumeration;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingBox;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Light;
import javax.media.j3d.Node;
import javax.media.j3d.PointLight;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;
import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Scene3D extends JPanel{
	
	private SimpleUniverse su;
	private Canvas3D c3d;
	private Modele3D modeleBlender;
	private Background bg;
	private BranchGroup c;

	public Scene3D(){
		c3d = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
		su = new SimpleUniverse(c3d);
		su.getViewingPlatform().setNominalViewingTransform();

		c = new BranchGroup();
		c.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
		c.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
		c.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
		bg = new Background();
		bg.setApplicationBounds(new BoundingBox());
		bg.setCapability(Background.ALLOW_COLOR_WRITE);
		c.addChild(bg);
		
// MANUEL		
		Light lumiere = new DirectionalLight(new Color3f(Color.white), new Vector3f(1,0,0));
		lumiere.setInfluencingBounds(new BoundingSphere());
		lumiere.setCapability(DirectionalLight.ALLOW_COLOR_WRITE);
		lumiere.setCapability(DirectionalLight.ALLOW_DIRECTION_WRITE);
		c.addChild(lumiere);
// /MANUEL

		su.addBranchGraph(c);
		//positionneCamera(su);
		this.setPreferredSize(new Dimension(640, 480));
		this.setLayout(new BorderLayout(0,0));
		this.add(c3d, BorderLayout.CENTER);
	}

	private void positionneCamera(SimpleUniverse su) {
	    // Recuperation du groupe de transformation a partir de l'objet
	    // SimpleUniverse afin de positionner la camera 
	    TransformGroup tg = su.getViewingPlatform().getViewPlatformTransform();
	    // Translation + rotation
	    Transform3D translation = new Transform3D();
	    translation.setTranslation(new Vector3f(0, 0, 10));
	    Transform3D rotationX = new Transform3D();
	    Transform3D trans = new Transform3D();
	    trans.mul(rotationX, translation);

	    // On applique la transformation
	    tg.setTransform(trans);
	  }
	
	
	public void setModele3D(Modele3D newModeleBlender){
		if (modeleBlender==null){ 
			modeleBlender=newModeleBlender;
			c.addChild(modeleBlender);
		}
		else{
			c.removeChild(modeleBlender);
			modeleBlender=newModeleBlender;
			c.addChild(modeleBlender);
		}
	}

	
// REVOIR ICI
	public void addLight(Light lumiere){
		BranchGroup bg = new BranchGroup();
		bg.addChild(lumiere);
		c.addChild(bg);
		System.out.println("ok");
		/*
		lumiere.setInfluencingBounds(new BoundingSphere());
		lumiere.setCapability(DirectionalLight.ALLOW_COLOR_WRITE);
		lumiere.setCapability(DirectionalLight.ALLOW_DIRECTION_WRITE);
		c.addChild(lumiere);
		//*/
	}
	
	public void removeLight(Light lumiere){
		c.removeChild(lumiere);
	}
	
}
