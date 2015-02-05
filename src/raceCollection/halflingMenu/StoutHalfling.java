package raceCollection.halflingMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Halfling;

public class StoutHalfling extends Halfling {

	private JPanel jp;
	private JButton acceptRace;

	public StoutHalfling() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Stout Halfling</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		
		acceptRace = new JButton("Accept Stout Halfling as Your Race");
		jp.add(acceptRace, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedClass(){return acceptRace;}
}
