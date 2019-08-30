package iutsd.ig;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import iutsd.interfaces.Configurable;
import iutsd.interfaces.FeuilleDuConfigurable;
import iutsd.scene.Scene3D;


public class PanneauSelection implements TreeSelectionListener{

	private Scene3D scene;
	private ArrayList<GModele3D> listeModeles3D;
	private ArrayList<GSDLPonctuelle> listeSDLponctuelle;
	private ArrayList<GSDLProjecteur> listeSDLprojecteur;
	private ArrayList<GSDLInfinie> listeSDLinfine;
	private ArrayList<GSDLAmbiante> listeSDLambiante;
	private DefaultMutableTreeNode noeudModeles, noeudSDLinfinie;
	private JTree tree;
	private DefaultTreeModel treeModel;
	private DefaultMutableTreeNode racine;
	private PanneauConfiguration panneauConfiguration;
	
	public PanneauSelection(Scene3D scene, PanneauConfiguration pc){
		panneauConfiguration = pc;
		this.scene = scene;
		/*
		 * G�n�ration des listes de lumi�re + mod�le
		 */
		listeModeles3D = new ArrayList<GModele3D>();
		listeSDLponctuelle = new ArrayList<GSDLPonctuelle>();
		listeSDLprojecteur = new ArrayList<GSDLProjecteur>();
		listeSDLinfine = new ArrayList<GSDLInfinie>();
		listeSDLambiante = new ArrayList<GSDLAmbiante>();
		
		/*
		 * Initialisation de l'arbre
		 */
		racine = new DefaultMutableTreeNode("Scene 3D");
		noeudModeles = new DefaultMutableTreeNode("modeles 3D");
		noeudSDLinfinie = new DefaultMutableTreeNode("lumi�re infinie");
		
		// Ajout de la racine de l'arbre
		treeModel = new DefaultTreeModel(racine);
		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(this);
		JScrollPane treeView = new JScrollPane(tree);

		// Ajout de la branche modele3d
		noeudModeles = new DefaultMutableTreeNode("modele 3d");
		
		treeModel.insertNodeInto(noeudModeles, racine, 0);
		treeModel.insertNodeInto(noeudSDLinfinie, racine, 0);
	}
	
	public JTree getTree(){
		return tree;
	}
	
	public void ajouterModele3D(GModele3D gmodele){
		listeModeles3D.add(gmodele);
		noeudModeles.add(gmodele.getLeaf());
		treeModel.insertNodeInto(gmodele.getLeaf(), noeudModeles, noeudModeles.getLeafCount()-1);
		scene.setModele3D(gmodele.getModele3D());
	}
	
	public void ajouterLumiereInfinie(GSDLInfinie source){
		listeSDLinfine.add(source);
		noeudSDLinfinie.add(source.getLeaf());
		treeModel.insertNodeInto(source.getLeaf(), noeudModeles, noeudModeles.getLeafCount()-1);
		scene.addLight(source.getLumiere());
	}

	public void valueChanged(TreeSelectionEvent selection) {
		TreePath p = selection.getPath();
		Object[] temp = p.getPath();
		if(temp.length == 0)
			return;
		Object o = temp[temp.length-1];
		
		if(o instanceof FeuilleDuConfigurable){
			Configurable c = ((FeuilleDuConfigurable)o).getConfigurable();
			panneauConfiguration.setConfigurable(c);
			
			if(c instanceof GModele3D){
				scene.setModele3D(((GModele3D)c).getModele3D());
			}
		}
	}

}
