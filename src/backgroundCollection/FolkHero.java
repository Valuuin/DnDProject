package backgroundCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dndProject.Character.Proficiencies;
import net.miginfocom.swing.MigLayout;

public class FolkHero {
	private JPanel jp;
	private JButton acceptBackground;

	//String unique to Folk Hero
	//String[] skillProf = {"Animal Handling", "Survival"};
	ArrayList<Proficiencies> skillProf = new ArrayList<Proficiencies>();
	//String[] toolProf = {"One type of artisan's tools", "Vehicles (land)"};
	ArrayList<String> toolProf = new ArrayList<String>();
	String equipment = "a set of artisan's tools, a  shovel, an iron pot, a set of common clothes, and a belt pouch containing 10 GP.";
			
	
	public FolkHero() {

		skillProf.add(Proficiencies.ANIMAL_HANDELING);
		skillProf.add(Proficiencies.SURVIVAL);
		toolProf.add("One type of Artisan's tools");
		toolProf.add("Vehicles (Land)");
		
		createJPanel();
	}
		
		public void createJPanel(){
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Folk Hero</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		//Proficiencies
		jp.add(new JLabel("<html><b>Proficiencies:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("Animal Handling, Surviavl"), "cell 1 1,alignx left,aligny bottom");
		
		//tools
		jp.add(new JLabel("<html><b>Tool Proficiencies:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel("One type of Artisan's tools, Vehicles (Land)"), "cell 1 2,alignx left,aligny bottom");		
		
		//equipment
		jp.add(new JLabel("<html><b>Equipment:</b></html>"), "cell 0 3,alignx right,aligny bottom");
		jp.add(new JLabel(equipment), "cell 1 3,alignx left,aligny bottom");
		
		
		acceptBackground = new JButton("Accept Folk Hero as Your Background");
		jp.add(acceptBackground, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedBackground(){return acceptBackground;}
	public ArrayList<Proficiencies> getProficiencies(){return skillProf;}
	public ArrayList<String> getTools(){return toolProf;}
}

