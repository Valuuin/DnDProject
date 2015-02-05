package raceCollection.gnomeMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Gnome;

public class ForrestGnome extends Gnome{

	private JPanel jp;
	private JButton acceptRace;

	// unique strings for Forrest gnome
	String ASI = abilityScoreIncrease;
	String forrestGnome_ASI = "Your Dexterity score increases by 1.";
	String naturalIllusionist = "You know the minor illusion cantrip. Intelligence is your spellcasting ability for it.";
	String speakWithSmallBeasts = "Through sounds and gestures, you can communicate simple ideas with Small or smaller beasts. Forest gnomes love animals and often keep squirrels, badgers, rabbits, moles, woodpeckers, and other creatures as beloved pets.";
	
	
	public ForrestGnome() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Forrest Gnome</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("<html>"+ASI+"<br><div align=\"left\">"+forrestGnome_ASI+"</html>"), "cell 1 1,alignx left,aligny bottom");
								
		// alignment
		jp.add(new JLabel("<html><b>Alignment:</b></html>"), "cell 0 2,alignx right,aligny bottom");
		jp.add(new JLabel(alignment), "cell 1 2,alignx left,aligny bottom");
								
		//Size
		jp.add(new JLabel("<html><b>Size:</b></html>"), "cell 0 3,alignx right, aligny top");
		jp.add(new JLabel(size), "cell 1 3,alignx left, aligny top");
										
		//Speed
		jp.add(new JLabel("<html><b>Speed:</b></html>"), "cell 0 4,alignx right, aligny top");
		jp.add(new JLabel(speed), "cell 1 4,alignx left, aligny top");

		//languages
		jp.add(new JLabel("<html><b>Languages:</b></html>"), "cell 0 5,alignx right, aligny top");
		jp.add(new JLabel(languages), "cell 1 5,alignx left, aligny top");
		
		//Natural Illusionist
		jp.add(new JLabel("<html><b>Natural Illusionist:</b></html>"), "cell 0 6,alignx right, aligny top");
		jp.add(new JLabel(naturalIllusionist), "cell 1 6,alignx left, aligny top");
			
		//Speak With small beasts
		jp.add(new JLabel("<html><b>Speak With Small Beasts:</b></html>"), "cell 0 7,alignx right, aligny top");
		jp.add(new JLabel(speakWithSmallBeasts), "cell 1 7,alignx left, aligny top");
		
		
		acceptRace = new JButton("Accept Forrest Gnome as Your Race");
		jp.add(acceptRace, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptRace;}
}
