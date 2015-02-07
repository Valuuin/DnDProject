package raceCollection.gnomeMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Gnome;

public class RockGnome extends Gnome {


	private JPanel jp;
	private JButton acceptRace;
	
	// Strings unique to rock gnomes
	String ASI = abilityScoreIncrease;
	String rockGnome_ASI = "Your constitution score increases by 1.";
	String artificersLore = "Whenever you make an Intelligence (History) check related to magic items, alchemical objects, or technological devices, you can add twice your proficiency bonus, instead of any proficiency bonus you normally apply.";
	
	// Info  {Strength,Dexterity,Constitution,Intelligence,Wisdom,Charisma }
	String[] atri = {"0","0","1","2","0","0"};
	
	public RockGnome() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Rock Gnome</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("<html>"+ASI+"<br><div align=\"left\">"+rockGnome_ASI+"</html>"), "cell 1 1,alignx left,aligny bottom");
										
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
		
		//Artificer's lore
		jp.add(new JLabel("<html><b>Artificer's Lore:</b></html>"), "cell 0 6,alignx right, aligny top");
		jp.add(new JLabel(artificersLore), "cell 1 6,alignx left, aligny top");
				
		
		acceptRace = new JButton("Accept Rock Gnome as Your Race");
		jp.add(acceptRace, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptRace;}
	public String[] getAttributes(){return atri;}
}
