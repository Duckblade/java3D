package iutsd.ig;

import iutsd.scene.Modele3D;
import iutsd.scene.SDLinfinie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class GUIMenu extends JMenuBar implements ActionListener{

	private PanneauSelection panneauSelection;
	private JMenu fichier, inserer;
	private JMenuItem quitter, ajoutSDLponctuelle, ajoutSDLinfinie, ajoutSDLprojecteur, ajoutModele3d;
	private JFileChooser fc;
	private JFrame frame;
	
	public GUIMenu(JFrame frame, PanneauSelection ps){
		super();
		panneauSelection = ps;
		fc = new JFileChooser();
		this.frame = frame;
		
		// Cr�ation des �l�ments des menus
		quitter = new JMenuItem("Quitter");
		quitter.setMnemonic('q');
		quitter.addActionListener(this);
		
		ajoutSDLinfinie = new JMenuItem("lumi�re infinie");
		ajoutSDLinfinie.setMnemonic('i');
		ajoutSDLinfinie.addActionListener(this);
		
		ajoutSDLponctuelle = new JMenuItem("lumi�re ponctuelle");
		ajoutSDLponctuelle.setMnemonic('p');
		ajoutSDLponctuelle.addActionListener(this);

		ajoutSDLprojecteur = new JMenuItem("lumi�re projecteur");
		ajoutSDLprojecteur.setMnemonic('r');
		ajoutSDLprojecteur.addActionListener(this);
		
		ajoutModele3d = new JMenuItem("un mod�le 3d");
		ajoutModele3d.setMnemonic('m');
		ajoutModele3d.addActionListener(this);

		// Cr�ation et remplissage des menus
		fichier = new JMenu("Fichier");
		fichier.add(quitter);
		ajoutSDLprojecteur.addActionListener(this);
		
		inserer = new JMenu("Ins�rer");
		inserer.add(ajoutModele3d);
		inserer.addSeparator();
		inserer.add(ajoutSDLinfinie);
		inserer.add(ajoutSDLponctuelle);
		inserer.add(ajoutSDLprojecteur);
		
		// Ajout des menus dans la barre des menus
		this.add(fichier);
		this.add(inserer);
	}

	public void actionPerformed(ActionEvent args) {
		Object source = args.getSource();
		
		if(source == ajoutModele3d){
			fc.showOpenDialog(frame);
			File f;
			if((f = fc.getSelectedFile()) != null){
				try{
					Modele3D modele = new Modele3D();
					modele.chargerObjet3D(f);
					GModele3D gmodele = new GModele3D(modele);
					panneauSelection.ajouterModele3D(gmodele);
				}
				catch(FileNotFoundException e){
					JOptionPane.showMessageDialog(frame, "Le fichier � charger n'a pas �t� trouv�", "erreur", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(frame, "Une erreur inconnue est survenue\n"+e.toString(), "erreur", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}
		else if(source == ajoutSDLinfinie){
			GSDLInfinie gs = new GSDLInfinie(new SDLinfinie());
			panneauSelection.ajouterLumiereInfinie(gs);
		}
	}
}
