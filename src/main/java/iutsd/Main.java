import iutsd.ig.GUIMasterFrame;

import javax.swing.*;
import java.awt.*;


public class Main {

	public static void main(String[] str){
		
		GUIMasterFrame gui = new GUIMasterFrame(1280);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(new Dimension(1280, 720));
		gui.setVisible(true);
	}

}
