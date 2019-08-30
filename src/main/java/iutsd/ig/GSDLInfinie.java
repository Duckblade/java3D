package iutsd.ig;

import iutsd.interfaces.Configurable;
import iutsd.scene.SDLinfinie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GSDLInfinie extends Configurable {

	private static int index = 1;
	private SDLinfinie source;
	
	public GSDLInfinie(SDLinfinie s){
		source = s;
		this.nom = "lumi�re infinie - "+(index++);
		this.construireFeuille();
		this.construirePanneau();
	}
	
	public SDLinfinie getLumiere(){
		return source;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
	protected void construirePanneau() {
		// TODO Auto-generated method stub
		panneau = new JPanel();
		panneau.add(new JLabel("Je suis"+nom));
	}

}
