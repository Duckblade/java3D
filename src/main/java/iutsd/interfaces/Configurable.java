package iutsd.interfaces;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public abstract class Configurable implements KeyListener, MouseMotionListener, ActionListener{

	protected FeuilleDuConfigurable feuille;
	protected String nom;
	protected JPanel panneau;

	// Impl�mentation obligatoire
	
	protected abstract void construirePanneau();
	
	public abstract void mouseDragged(MouseEvent arg0);

	public abstract void keyPressed(KeyEvent e);
	
	// D�j� impl�ment�e
	
	public FeuilleDuConfigurable getLeaf(){
		return feuille;
	}
	
	public JPanel getPanneauConfiguration(){
		return panneau;
	}
	
	protected void construireFeuille() {
		feuille = new FeuilleDuConfigurable(this, nom);
	}

	// Pas oblig�e d'�tre impl�ment�e

	public void mouseMoved(MouseEvent arg0) {}

	public void keyReleased(KeyEvent e){}

	public void keyTyped(KeyEvent e){}
}
