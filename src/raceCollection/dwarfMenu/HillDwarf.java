package raceCollection.dwarfMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Dwarf;

public class HillDwarf extends Dwarf {
	// Create 2 global variables one JPanel one JButton
	private JPanel jp;
	private JButton acceptHillDwarf;
	
	// Create the Strings unique to HillDwarf
	String ASI = abilityScoreIncrease;
	String hillDwarf_ASI = "Your Wisdom score increases by 1.";
	String dwarvenToughness = "Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.";
	/**
	 * Create the panel.
	 */
	public HillDwarf() {
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Hill Dwarf</font></html>"), "cell 0 0 2 1,alignx center,aligny center");

		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("<html>"+ASI+"<br><div align=\"left\">"+hillDwarf_ASI+"</html>"), "cell 1 1,alignx left,aligny bottom");
		
		// alignment
		jp.add(new JLabel("<html><b>Alignment:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(alignment), "cell 1 2,alignx left,aligny bottom");
		
	}

	// Create one method to return the JPanel created up top
	public JPanel getJPanel(){return jp;}
	// Create one method to return the JButton created up top
	public JButton getAcceptedRace(){return acceptHillDwarf;}
}
