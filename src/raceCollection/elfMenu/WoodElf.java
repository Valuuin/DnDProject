package raceCollection.elfMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import raceCollection.Elf;

public class WoodElf extends Elf {
	private JPanel jp;
	private JButton acceptRace;
	String ASI = abilityScoreIncrease;
	String woodElf_ASI = "Your Wisdom score increases by 1.";
	String elfWeaponTraining = "You have proficiency with the longsword, shortsword, shortbow, and longbow.";
	String fleetOfFoot = "Your base walking speed increases to 35 feet.";
	String maskOfTheWild = "You can attempt to hide even when you are only lightly obscured by foliage, heavy rain, falling snow, mist and other natural phenomena.";
	
	// Info  {Strength,Dexterity,Constitution,Intelligence,Wisdom,Charisma }
	String[] atri = {"0","2","0","0","1","0"};
		
	
	public WoodElf() {

		jp = new JPanel();
		jp.setSize(640, 480);
		jp.setLayout(new MigLayout("", "[25%][75%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		jp.add(new JLabel("<html><font size=\"6\">Wood Elf</font></html>"), "cell 0 0 2 1,alignx center,aligny center");
		
		

		// Ability Score Increase
		jp.add(new JLabel("<html><b>Ability Score</b><br><div align=\"right\"><b>Increase:</b></html>"), "cell 0 1,alignx right,aligny bottom");
		jp.add(new JLabel("<html>"+ASI+"<br><div align=\"left\">"+woodElf_ASI+"</html>"), "cell 1 1,alignx left,aligny bottom");
						
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
		
		//Elf Weapon Training
		jp.add(new JLabel("<html><b>Elf Weapon Training:</b></html>"), "cell 0 6,alignx right, aligny top");
		jp.add(new JLabel(elfWeaponTraining), "cell 1 6,alignx left, aligny top");
		
		//Fleet of Foot
		jp.add(new JLabel("<html><b>Fleet of Foot:</b></html>"), "cell 0 7,alignx right, aligny top");
		jp.add(new JLabel(fleetOfFoot), "cell 1 7,alignx left, aligny top");
		
		//mask of the wild
		jp.add(new JLabel("<html><b>Mask of the Wild:</b></html>"), "cell 0 8,alignx right, aligny top");
		jp.add(new JLabel(maskOfTheWild), "cell 1 8,alignx left, aligny top");
		
		
		acceptRace = new JButton("Accept Wood Elf as Your Race");
		jp.add(acceptRace, "cell 0 9 2 1,alignx center,aligny center");
		
	}

	public JPanel getJPanel(){return jp;}
	public JButton getAcceptedRace(){return acceptRace;}
	public String[] getAttributes(){return atri;}
}

