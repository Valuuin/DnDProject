package raceCollection.elfMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Elf;

public class WoodElf extends Elf {
	private JPanel jp;
	private JButton acceptRace;

	public WoodElf() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Wood Elf</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		
		acceptRace = new JButton("Accept Wood Elf as Your Race");
		jp.add(acceptRace, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedClass(){return acceptRace;}
}

