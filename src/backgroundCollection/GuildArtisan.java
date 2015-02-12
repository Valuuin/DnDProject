package backgroundCollection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class GuildArtisan {
	private JPanel jp;
	private JButton acceptBackground;

	//Guild artisan strings
	String[] skillProf = {"Insight", "Persuasion"};
	String toolProf = "One type of artisan's tools";
	String languages = "One of your choice";
	String equipment = "A set of artisan's tools, a letter of introduction from your guild, a set of traveler's clothes, and a belt pouch containing 15 GP";
	
	
	public GuildArtisan() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Guild Artisan</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		
		//Proficiencies
		jp.add(new JLabel("<html><b>Proficiencies:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel(skillProf[0] +", "+skillProf[1]), "cell 1 1,alignx left,aligny bottom");
		
		//tools
		jp.add(new JLabel("<html><b>Tool Proficiencies:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(toolProf), "cell 1 2,alignx left,aligny bottom");		
		
		//equipment
		jp.add(new JLabel("<html><b>Equipment:</b></html>"), "cell 0 3,alignx right,aligny bottom");
		jp.add(new JLabel(equipment), "cell 1 3,alignx left,aligny bottom");
		
		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 4,alignx right,aligny bottom");
		jp.add(new JLabel(languages), "cell 1 4,alignx left,aligny bottom");
		
		acceptBackground = new JButton("Accept Guild Artisan as Your Background");
		jp.add(acceptBackground, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedBackground(){return acceptBackground;}
}


