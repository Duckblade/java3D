package iutsd.ig;
import iutsd.scene.Scene3D;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;



/**
 * Fen�tre principale de l'application
 * @author gryttix
 *
 */
public class GUIMasterFrame extends JFrame{
	
	// Configuration
	private int largeurMiniScrollPane = 100;
	private int largeurInitialeScrollPane = 200;
	private int hauteurMiniScrollPane = 100;

	// Ce qui va �tre partag� avec d'autres classes
	private Scene3D panneauScene;
	private PanneauConfiguration panneauConfiguration;
	private PanneauSelection panneauSelection;
	private GUIMenu barreDesMenus;
	
	public GUIMasterFrame(int largeurInitiale){
		super("Eclairage d'une sc�ne en 3 dimensions - version de d�veloppement");
		
		Dimension dimensionMinimum = new Dimension(largeurMiniScrollPane, 150);

		// La scene 3D
		panneauScene = new Scene3D();

		// le panneau de configuration
		panneauConfiguration = new PanneauConfiguration(panneauScene);
		panneauConfiguration.setMinimumSize(dimensionMinimum);

		// Le panneau de s�lection
		panneauSelection = new PanneauSelection(panneauScene, panneauConfiguration);
		
		// la barre de smenus
		barreDesMenus = new GUIMenu(this, panneauSelection);
		
		// La r�partition des panneaux
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panneauSelection.getTree(), panneauScene);
		splitPane1.setOneTouchExpandable(true);
		splitPane1.setDividerLocation(largeurInitialeScrollPane);
		
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane1, panneauConfiguration);
		splitPane2.setOneTouchExpandable(true);
		splitPane2.setDividerLocation(largeurInitiale-largeurInitialeScrollPane);
		this.add(splitPane2);
		
		this.setJMenuBar(barreDesMenus);
	}

}
