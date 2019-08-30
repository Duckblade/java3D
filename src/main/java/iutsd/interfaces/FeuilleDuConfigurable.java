package iutsd.interfaces;

import javax.swing.tree.DefaultMutableTreeNode;

public class FeuilleDuConfigurable extends DefaultMutableTreeNode{

	private Configurable c;

	public FeuilleDuConfigurable(Configurable c, String nom){
		super(nom);
		this.c = c;
	}
	
	public Configurable getConfigurable(){
		return c;
	}
}