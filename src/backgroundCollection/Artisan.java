package backgroundCollection;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import dndProject.Character.Proficiencies;
import net.miginfocom.swing.MigLayout;

public class Artisan {
	private JPanel jp;
	private JButton acceptBackground;

	//artisan strings
	ArrayList<Proficiencies> skillProf = new ArrayList<Proficiencies>();
	String language = "Two of your choice";
	String equipment = "A holy symbol, a prayer book or prayer wheel, 5 sticks of incense, vestments, a set of common clothes, and a belt pouch containing 15 GP";
	
			
	
	public Artisan() {
	
		skillProf.add(Proficiencies.INSIGHT);
		skillProf.add(Proficiencies.REGLIGION);
		createJPanel();
	}
	
	public void createJPanel(){
		
		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Artisan</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		//Proficiencies
		jp.add(new JLabel("<html><b>Proficiencies:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("Insight, Religion"), "cell 1 1,alignx left,aligny bottom");
		
		//tools
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(language), "cell 1 2,alignx left,aligny bottom");		
		
		//equipment
		jp.add(new JLabel("<html><b>Equipment:</b></html>"), "cell 0 3,alignx right,aligny bottom");
		jp.add(new JLabel(equipment), "cell 1 3,alignx left,aligny bottom");
		
		acceptBackground = new JButton("Accept Artisan as Your Background");
		jp.add(acceptBackground, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedBackground(){return acceptBackground;}
	public ArrayList<Proficiencies> getProficiencies(){return skillProf;}
}

