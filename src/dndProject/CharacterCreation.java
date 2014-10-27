package dndProject;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSplitPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CharacterCreation {

	private JPanel cC;
	private JButton openRaceMenu, openClassMenu, openBackgroundMenu;
	private JLabel selectedRace, selectedClass, backgroundSelected;
	
	/**
	 * Create the panel.
	 */
	public CharacterCreation() {
		
		cC = new JPanel();
		cC.setSize(620, 480);
		cC.setLayout(new MigLayout("", "[25%][25%][25%][25%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		
		JLabel title = new JLabel("Character Creation");
		cC.add(title, "cell 0 0 4 1,alignx center,aligny center");
		
		// button Labels
		JLabel raceMenuLabel = new JLabel("Race Menu:");
		cC.add(raceMenuLabel, "cell 0 2,alignx center,aligny center");
		JLabel classMenuLabel = new JLabel("Class Menu:");
		cC.add(classMenuLabel, "cell 0 3,alignx center,aligny center");
		JLabel backgroundMenuLabel = new JLabel("Background Menu:");
		cC.add(backgroundMenuLabel, "cell 0 4,alignx center,aligny center");

		openRaceMenu = new JButton("Open Race Menu");
		cC.add(openRaceMenu, "cell 1 2,alignx center,aligny center");
		
		openClassMenu = new JButton("Open Class Menu");
		cC.add(openClassMenu, "cell 1 3,alignx center,aligny center");

		openBackgroundMenu = new JButton("<html>Open Background<br><div align=\"center\">Menu</html>");
		cC.add(openBackgroundMenu, "cell 1 4,alignx center,aligny center");

		// Saved Results from X Menu
		selectedRace = new JLabel("None Selected");
		cC.add(selectedRace, "cell 2 2 2 1,alignx center,aligny center");
		
		selectedClass = new JLabel("None Selected");
		cC.add(selectedClass, "cell 2 3 2 1,alignx center,aligny center");
		
		backgroundSelected = new JLabel("None Selected");
		cC.add(backgroundSelected, "cell 2 4 2 1,alignx center,aligny center");
	}

	public JPanel getCharacterCreationPanel(){return cC;}
	public JButton getOpenRaceMenuButton(){return openRaceMenu;}
	public JButton getOpenClassMenun(){return openClassMenu;}
	public JButton getOpenBackgroundMenu(){return openBackgroundMenu;}
	
	public void setRace(String race){
		selectedRace.setText(race);
	}
}
