package dndProject;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import dndProject.Character.Proficiences;

public class ProficienciesSelection {

	private JPanel pS;
	private JRadioButton btnAcrobatics, btnAnimalHandeling, btnArcana, btnAthetics, btnDeception, 
	                     btnHistory, btnInsight, btnIntimidation, btnInvestigation, btnMedicine,
	                     btnNature, btnPerception, btnPerformance, btnPersuasion, btnReligion,
	                     btnSleightOfHand, btnStealth, btnSurvival;
	private JButton btnBack, btnSave;
	Character c;
	private JLabel backgroundLabel;
	private JLabel classLabel;
	
	public ProficienciesSelection(){
		createJPanel();
	}
	
	private void createJPanel(){
		pS = new JPanel();
		pS.setSize(620, 480);
		pS.setLayout(new MigLayout("", "[5%][18%][18%][18%][18%][18%][5%]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));
		
		JLabel title = new JLabel("Proficiencies Selection");
		pS.add(title, "cell 0 0 7 1,alignx center,aligny center");
		
		backgroundLabel = new JLabel();
		pS.add(backgroundLabel, "cell 1 1 5 1,alignx left,aligny top");
		
		classLabel = new JLabel("<html>Since your choise of INSERT_CLASS you get to chooise 2 Proficiencies from:<br> LIST OF PROFICIENCIES FROM CLASS HERE</html>");
		pS.add(classLabel, "cell 1 2 5 1,alignx left,aligny top");
		
		btnAcrobatics = new JRadioButton("Acrobatics");
		btnAcrobatics.setEnabled(false);
		pS.add(btnAcrobatics, "cell 1 3,alignx left,aligny center");
		
		btnAnimalHandeling = new JRadioButton("Animal Handeling");
		btnAnimalHandeling.setEnabled(false);
		pS.add(btnAnimalHandeling, "cell 2 3,alignx left,aligny center");
		
		btnArcana = new JRadioButton("Arcana");
		btnArcana.setEnabled(false);
		pS.add(btnArcana, "cell 3 3,alignx left,aligny center");
		
		btnAthetics = new JRadioButton("Athetics");
		btnAthetics.setEnabled(false);
		pS.add(btnAthetics, "cell 4 3,alignx left,aligny center");
		
		btnDeception = new JRadioButton("Deception");
		btnDeception.setEnabled(false);
		pS.add(btnDeception, "cell 5 3,alignx left,aligny center");
		
		btnHistory = new JRadioButton("History");
		btnHistory.setEnabled(false);
		pS.add(btnHistory, "cell 1 4,alignx left,aligny center");
		
		btnInsight = new JRadioButton("Insight");
		btnInsight.setEnabled(false);
		pS.add(btnInsight, "cell 2 4,alignx left,aligny center");
		
		btnIntimidation = new JRadioButton("Intimidation");
		btnIntimidation.setEnabled(false);
		pS.add(btnIntimidation, "cell 3 4,alignx left,aligny center");
		
		btnInvestigation = new JRadioButton("Investigation");
		btnInvestigation.setEnabled(false);
		pS.add(btnInvestigation, "cell 4 4,alignx left,aligny center");
		
		btnMedicine = new JRadioButton("Medicine");
		btnMedicine.setEnabled(false);
		pS.add(btnMedicine, "cell 5 4,alignx left,aligny center");
		
		btnNature = new JRadioButton("Nature");
		btnNature.setEnabled(false);
		pS.add(btnNature, "cell 1 5,alignx left,aligny center");
		
		btnPerception = new JRadioButton("Perception");
		btnPerception.setEnabled(false);
		pS.add(btnPerception, "cell 2 5,alignx left,aligny center");
		
		btnPerformance = new JRadioButton("Performance");
		btnPerformance.setEnabled(false);
		pS.add(btnPerformance, "cell 3 5,alignx left,aligny center");
		
		btnPersuasion = new JRadioButton("Persuasion");
		btnPersuasion.setEnabled(false);
		pS.add(btnPersuasion, "cell 4 5,alignx left,aligny center");
		
		btnReligion = new JRadioButton("Religion");
		btnReligion.setEnabled(false);
		pS.add(btnReligion, "cell 5 5,alignx left,aligny center");
		
		btnSleightOfHand = new JRadioButton("Sleight Of Hand");
		btnSleightOfHand.setEnabled(false);
		pS.add(btnSleightOfHand, "cell 2 6,alignx left,aligny center");
		
		btnStealth = new JRadioButton("Stealth");
		btnStealth.setEnabled(false);
		pS.add(btnStealth, "cell 3 6,alignx left,aligny center");
		
		btnSurvival = new JRadioButton("Survival");
		btnSurvival.setEnabled(false);
		pS.add(btnSurvival, "cell 4 6,alignx left,aligny center");
		
		btnBack = new JButton("Back ");
		pS.add(btnBack, "cell 2 8,alignx center,aligny center");
		
		btnSave = new JButton("Save");
		pS.add(btnSave, "cell 4 8,alignx center,aligny center");
		
	}
	
	public void updateEligibleProficiencies(Character c){
		
		ArrayList<Proficiences> backgroundList = c.getProficiencies();
		String bList = "";
			
		for(Proficiences s : backgroundList){
			switch(s){
			case ACROBATICS:
				bList = bList + ", Acrobatics";
				btnAcrobatics.setSelected(true);
				break;
			case ANIMAL_HANDELING:
				bList = bList +", Animal Handeling";
				btnAnimalHandeling.setSelected(true);
				break;
			case ARCANA:
				bList = bList +", Arcana";
				btnArcana.setSelected(true);
				break;
			case ATHETICS:
				bList = bList +",  Athetics";
				btnAthetics.setSelected(true);
				break;
			case DECEPTION:
				bList = bList +", Deception";
				btnDeception.setSelected(true);
				break;
			case HISTORY:
				bList = bList +", History";
				btnHistory.setSelected(true);
				break;
			case INSIGHT:
				bList = bList +", Insight";
				btnInsight.setSelected(true);
				break;
			case INTIMIDATION:
				bList = bList +", Intimidation";
				btnIntimidation.setSelected(true);
				break;
			case INVESTIGATION:
				bList = bList +", Investigation";
				btnInvestigation.setSelected(true);
				break;
			case MEDICINE:
				bList = bList +", Medicine";
				btnMedicine.setSelected(true);
				break;
			case NATURE:
				bList = bList +", Nature";
				btnNature.setSelected(true);
				break;
			case PERCEPTION:
				bList = bList +", Perception";
				btnPerception.setSelected(true);
				break;
			case PERFORMANCE:
				bList = bList +", Performance";
				btnPerformance.setSelected(true);
				break;
			case PERSUASION:
				bList = bList +", Persuasion";
				btnPersuasion.setSelected(true);
				break;
			case REGLIGION:
				bList = bList +", Religion";
				btnReligion.setSelected(true);
				break;
			case SLEIGHT_OF_HAND:
				bList = bList +", Sleight of Hand";
				btnSleightOfHand.setSelected(true);
				break;
			case STEALTH:
				bList = bList +", Stealth";
				btnStealth.setSelected(true);
				break;
			case SURVIVAL:
				bList = bList +", Survival";
				btnSurvival.setSelected(true);
				break;
			default:
				break;
			
			}
		}

		backgroundLabel.setText("<html>Since your choise of "+c.getBackgroundName()+" you automatically gained the proficiencies in:"+bList);
	}
	
	
	
	/*
	 *  Gitter Method called in DndHandbook.java
	 */
	public JButton getProfBack(){return btnBack;}
	public JButton getProfSave(){return btnSave;}
	public JPanel getProficienciesSelectionJPanel(){return pS;}
		
}
