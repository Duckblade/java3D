package iutsd.ig;

import iutsd.interfaces.Configurable;
import iutsd.scene.Modele3D;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class GModele3D extends Configurable {

	private static int index = 1;

	// Les attributs d�finissant le GModele
	private Modele3D modele;
	
	// Concernant le panneau du GModele
	private JTextField jtfX, jtfY, jtfZ;

	public GModele3D(Modele3D m){
		modele = m;
		this.nom = "modele 3d - "+index;;
		index++;
		this.construireFeuille();
		this.construirePanneau();
	}
	
	protected void construirePanneau(){

// TODO		
		panneau = new JPanel();

		
	}
	
	public Modele3D getModele3D(){
		return modele;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
