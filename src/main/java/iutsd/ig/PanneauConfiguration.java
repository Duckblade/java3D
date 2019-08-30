package iutsd.ig;


import iutsd.interfaces.Configurable;
import iutsd.scene.Scene3D;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PanneauConfiguration extends JPanel{

	private Scene3D scene;
	private JComponent j;
	private Configurable configurable;
	private JLabel rienAConfigurer;

	public PanneauConfiguration(Scene3D scene){
		this.scene = scene;
		rienAConfigurer = new JLabel("S�lectionnez un �l�ment � configurer.");
		j = rienAConfigurer;
		this.add(j);
		configurable = null;
	}
	
	public void setConfigurable(Configurable c){
		this.remove(j);
		if(configurable != null)
			scene.removeKeyListener(configurable);
		configurable = c;
		j = c.getPanneauConfiguration();
		this.add(j);
		scene.addKeyListener(configurable);
	}
	
}
