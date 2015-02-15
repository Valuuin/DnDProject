package dndProject;

import java.util.ArrayList;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

public class CharacterCreation {

	private JPanel cC;
	private JButton openRaceMenu, openClassMenu, openBackgroundMenu;
	private JLabel selectedClass, selectedBackground, selectedRace;
	private JLabel selectionResults;
	private JButton openAttributes;
	private JLabel attributesResults;
	private JButton openProficiencies;
	private JLabel proficienciesResults;
	private JButton btnToPDF;
	
	/**
	 * Create the panel.
	 */
	public CharacterCreation() {
	
		cC = new JPanel();
		cC.setSize(620, 480);
		cC.setLayout(new MigLayout("", "[25%,grow][25%][25%][25%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%,grow][10%]"));
		
		JLabel title = new JLabel("Character Creation");
		cC.add(title, "cell 0 0 4 1,alignx center,aligny center");
		

		// button Labels
		JLabel raceMenuLabel = new JLabel("Race Menu:");
		cC.add(raceMenuLabel, "cell 0 2,alignx center,aligny center");
		JLabel classMenuLabel = new JLabel("Class Menu:");
		cC.add(classMenuLabel, "cell 0 3,alignx center,aligny center");
		JLabel backgroundMenuLabel = new JLabel("Background Menu:");
		cC.add(backgroundMenuLabel, "cell 0 4,alignx center,aligny center");

		// REsults lable and button that starts off hidden
		selectionResults = new JLabel("New label");
		selectionResults.setVisible(false);
		cC.add(selectionResults, "cell 0 6 4 1,alignx center,aligny center");
		openAttributes = new JButton("Open Attributes");
		openAttributes.setVisible(false);
		cC.add(openAttributes, "cell 0 7 2 1,alignx center,aligny center");
		openProficiencies = new JButton("Open Proficiencies");
		openProficiencies.setVisible(false);
		cC.add(openProficiencies, "cell 0 8 2 1,alignx center,aligny center");
		attributesResults = new JLabel();
		cC.add(attributesResults, "cell 2 7 2 1");
		proficienciesResults = new JLabel("");
		cC.add(proficienciesResults, "cell 2 8 2 1,alignx left,aligny center");
		btnToPDF = new JButton("Export To PDF");
		btnToPDF.setVisible(false);
		cC.add(btnToPDF, "cell 1 10 2 1,alignx center");


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
		
		selectedBackground = new JLabel("None Selected");
		cC.add(selectedBackground, "cell 2 4 2 1,alignx center,aligny center");
		
		
				
	}
			
	public void setRace(String race){
		selectedRace.setText(race);
		displaySelectionResults();
	}
	
	public void setClass(String className){
		selectedClass.setText(className);
		displaySelectionResults();
	}
	
	public void setBackground(String backgroundName){
		selectedBackground.setText(backgroundName);
		displaySelectionResults();
	}
	
	public void setAttributesResults(ArrayList<String> s){
		attributesResults.setText("Str: "+s.get(0)+", Dex: "+s.get(1)+", Con: "+s.get(2)+", Int: "+s.get(3)+", Wis: "+s.get(4)+", Chr: "+s.get(5));
		attributesResults.setVisible(true);
		displayPDFButton();
	}
	
	public void resetAttributesResults(){
		attributesResults.setVisible(false);
		btnToPDF.setVisible(false);
	}
	
	public void setProficienciesResults(ArrayList<String> s){
		String prof = "";
		for (String p : s){
			prof = prof  +", "+ p;
		}
		proficienciesResults.setText("<html>Selected Proficiencies:<br>"+prof.substring(1));
		proficienciesResults.setVisible(true);
		displayPDFButton();
	}
	
	public void resetProficienciesResults(){
		proficienciesResults.setVisible(false);
		btnToPDF.setVisible(false);
	}
	
	private void displayPDFButton(){
		if(proficienciesResults.isVisible() && attributesResults.isVisible())
			btnToPDF.setVisible(true);
	}
	private void displaySelectionResults(){
		if ( !selectedRace.getText().equalsIgnoreCase("None Selected") &&
		     !selectedClass.getText().equalsIgnoreCase("None Selected") &&	
			 !selectedBackground.getText().equalsIgnoreCase("None Selected")){
			
				selectionResults.setText("Are you Sure you want to be a "+selectedRace.getText()+" "+selectedClass.getText()+" "+"with a background in "+selectedBackground.getText());
				selectionResults.setVisible(true);
				openAttributes.setVisible(true);
				openProficiencies.setVisible(true);
			}
	}
	
	public JPanel getCharacterCreationPanel(){return cC;}
	public JButton getOpenRaceMenuButton(){return openRaceMenu;}
	public JButton getOpenClassMenu(){return openClassMenu;}
	public JButton getOpenBackgroundMenu(){return openBackgroundMenu;}
	public JButton getOpenAttributes(){return openAttributes;}
	public JButton getOpenProficiencies(){return openProficiencies;}
	public JButton getSaveToPDF(){return btnToPDF;}
}
