package dndProject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckbox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDRadioCollection;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFA;

import classCollection.Barbarian;
import classCollection.Bard;
import classCollection.Cleric;
import classCollection.Druid;
import classCollection.Fighter;
import classCollection.Monk;
import classCollection.Paladin;
import classCollection.Ranger;
import classCollection.Rogue;
import classCollection.Sorcerer;
import classCollection.Warlock;
import classCollection.Wizzard;
import backgroundCollection.Artisan;
import backgroundCollection.Charlatan;
import backgroundCollection.Criminal;
import backgroundCollection.Entertainer;
import backgroundCollection.FolkHero;
import backgroundCollection.GuildArtisan;
import backgroundCollection.Hermit;
import backgroundCollection.Noble;
import backgroundCollection.Outlander;
import backgroundCollection.Sage;
import backgroundCollection.Sailor;
import backgroundCollection.Soldier;
import backgroundCollection.Urchin;
import raceCollection.DragonBorn;
import raceCollection.HalfElf;
import raceCollection.HalfOrc;
import raceCollection.Human;
import raceCollection.Tiefling;
import raceCollection.dwarfMenu.HillDwarf;
import raceCollection.dwarfMenu.MountainDwarf;
import raceCollection.elfMenu.Drow;
import raceCollection.elfMenu.HighElf;
import raceCollection.elfMenu.WoodElf;
import raceCollection.gnomeMenu.ForrestGnome;
import raceCollection.gnomeMenu.RockGnome;
import raceCollection.halflingMenu.LightfootHalfling;
import raceCollection.halflingMenu.StoutHalfling;


public class Character {

	public enum Race{HUMAN, DROW, HIGH_ELF, WOOD_ELF, DRAGONBORN, TIEFLING, HALF_ELF, HALF_ORC, ROCK_GNOME, FORREST_GNOME, HILL_DWARF, MOUNTAIN_DWARF, LIGHTFOOT_HALFLING, STOUT_HALFLING}
	public enum cClass{BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK, WIZZARD}
	public enum bGround{ARTISAN, CHARLATAN, CRIMINAL, ENTERTAINER, FOLKHERO, GUILDARTISAN, HERMIT, NOBLE, OUTLANDER, SAGE, SAILOR, SOLDIER, URCHIN}
	public enum Proficiencies{ACROBATICS, ANIMAL_HANDELING, ARCANA, ATHETICS, DECEPTION, HISTORY, INSIGHT, INTIMIDATION, INVESTIGATION, MEDICINE, NATURE, PERCEPTION, PERFORMANCE, PERSUASION, REGLIGION, SLEIGHT_OF_HAND, STEALTH, SURVIVAL}
	public enum Attributes{STR, DEX, CON, INT, WIS, CHA}
	
	private static PDDocument pdfTemplate;
	static PDAcroForm acroForm;
	static PDDocumentCatalog docCatalog;
	
	Race rName;
	cClass cName;
	bGround bName;
	
	Object selectedRace;
	Object selectedClass;
	Object selectedBackground;
	
	String newRace;
	String newClass;
	String newBackground;
	
	String profBonus = "2";
	
	ArrayList<String> proficienciesSelected = new ArrayList<String>();
	ArrayList<String> attributesSelected = new ArrayList<String>();
	
	ArrayList<String>        errorString = new ArrayList<String>();
	ArrayList<Proficiencies> errorProficiences= new ArrayList<Proficiencies>();
	ArrayList<Attributes>    savingThrows = new ArrayList<Attributes>();
	
	String[] savingThrowsResults = new String[] {"0","0","0","0","0","0"};
	String[] attributesModifiers = new String[6];
	String[] skillProficiences   = new String[18];
	
	public Character(){
		selectedRace = null;
		selectedClass = null;
		selectedBackground = null;
		errorString.add("0");
		errorString.add("0");
		errorString.add("0");
		errorString.add("0");
		errorString.add("0");
		errorString.add("0");
		
		// Load the pdfTemplate
	    try {
			pdfTemplate = PDDocument.load(new File("characterFourm.pdf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    docCatalog = pdfTemplate.getDocumentCatalog();
	    acroForm = docCatalog.getAcroForm();
	    acroForm.getDictionary().setItem(COSName.getPDFName("NeedAppearances"), COSBoolean.TRUE);
		
	}
	
	public Character ( Object rc, Object cs, Object bg){
		this.selectedRace = rc;
		this.selectedClass = cs;
		this.selectedBackground = bg;
	}
	
	
	/***********************************************************************************************************/
	/*                                   Setters For Character Class                                          */
	/***********************************************************************************************************/	
	public void setRace(Object r, String name, Race re){
		this.selectedRace = r;
		this.newRace = name;
		this.rName = re;
	}
	
	public void setClass(Object c, String name, cClass cC){
		this.selectedClass = c;
		this.newClass = name;
		this.cName = cC;
	}
	
	public void setBackground(Object b, String name, bGround bG){
		this.selectedBackground = b;
		this.newBackground = name;
		this.bName = bG;
	}
	
	public void setSavedProficiences(ArrayList<String> prof){
		this.proficienciesSelected = prof;
	}
	
	public void setSavedAttributes(ArrayList<String> attri){
		this.attributesSelected = attri;
	}

	/***********************************************************************************************************/
	/*                                   GITTERS For Character Class                                          */
	/***********************************************************************************************************/
	 public String getRaceName(){return newRace;}
	 public String getClassName(){return newClass;}
	 public String getBackgroundName(){return newBackground;}
	 
	 public Race get_Race(){return rName;}
	 public cClass get_Class(){return cName;}
	 public bGround get_Background(){return bName;}
	 
	/***********************************************************************************************************/
	/*                                   GITTERS From Race Classes                                             */
	/***********************************************************************************************************/
	
	/*
	 * Get the Atributes from the class file.
	 */
	public ArrayList<String> getAtributes(){
		if (selectedRace != null){
			switch(rName){
			case DRAGONBORN:         return (ArrayList<String>)((DragonBorn)        selectedRace).getAttributes();
			case HUMAN:              return (ArrayList<String>)((Human)             selectedRace).getAttributes();
			case DROW:               return (ArrayList<String>)((Drow)              selectedRace).getAttributes();
			case HIGH_ELF:           return (ArrayList<String>)((HighElf)           selectedRace).getAttributes();
			case WOOD_ELF:           return (ArrayList<String>)((WoodElf)           selectedRace).getAttributes();
			case TIEFLING:           return (ArrayList<String>)((Tiefling)          selectedRace).getAttributes();
			case HALF_ELF:           return (ArrayList<String>)((HalfElf)           selectedRace).getAttributes();
			case HALF_ORC:           return (ArrayList<String>)((HalfOrc)           selectedRace).getAttributes();
			case ROCK_GNOME:         return (ArrayList<String>)((RockGnome)         selectedRace).getAttributes();
			case FORREST_GNOME:      return (ArrayList<String>)((ForrestGnome)      selectedRace).getAttributes();
			case HILL_DWARF:         return (ArrayList<String>)((HillDwarf)         selectedRace).getAttributes();
			case MOUNTAIN_DWARF:     return (ArrayList<String>)((MountainDwarf)     selectedRace).getAttributes();
			case LIGHTFOOT_HALFLING: return (ArrayList<String>)((LightfootHalfling) selectedRace).getAttributes();
			case STOUT_HALFLING:     return (ArrayList<String>)((StoutHalfling)     selectedRace).getAttributes();
			default: return errorString;
			}
		}
		return errorString;
	}
	
	public ArrayList<Proficiencies> getBackgroundProficiencies(){
		if (selectedBackground != null){
			switch(bName){
			case ARTISAN:      return (ArrayList<Proficiencies>)((Artisan)      selectedBackground).getProficiencies();
			case CHARLATAN:    return (ArrayList<Proficiencies>)((Charlatan)    selectedBackground).getProficiencies();
			case CRIMINAL:     return (ArrayList<Proficiencies>)((Criminal)	    selectedBackground).getProficiencies();
			case ENTERTAINER:  return (ArrayList<Proficiencies>)((Entertainer)  selectedBackground).getProficiencies();
			case FOLKHERO:     return (ArrayList<Proficiencies>)((FolkHero)     selectedBackground).getProficiencies();
			case GUILDARTISAN: return (ArrayList<Proficiencies>)((GuildArtisan) selectedBackground).getProficiencies();
			case HERMIT:	   return (ArrayList<Proficiencies>)((Hermit)       selectedBackground).getProficiencies();
			case NOBLE:		   return (ArrayList<Proficiencies>)((Noble)        selectedBackground).getProficiencies();
			case OUTLANDER:	   return (ArrayList<Proficiencies>)((Outlander)    selectedBackground).getProficiencies();
			case SAGE:		   return (ArrayList<Proficiencies>)((Sage)         selectedBackground).getProficiencies();
			case SAILOR:	   return (ArrayList<Proficiencies>)((Sailor)       selectedBackground).getProficiencies();
			case SOLDIER:      return (ArrayList<Proficiencies>)((Soldier)      selectedBackground).getProficiencies();
			case URCHIN:	   return (ArrayList<Proficiencies>)((Urchin)       selectedBackground).getProficiencies();
			default: return errorProficiences;
			}
		}
		return errorProficiences;
	}
	
	public ArrayList<Proficiencies> getClassProficiencies(){
		if (selectedClass != null){
			switch(cName){
			case BARBARIAN: return (ArrayList<Proficiencies>)((Barbarian)     selectedClass).getProficiencies();
			case BARD:      return (ArrayList<Proficiencies>)((Bard)          selectedClass).getProficiencies();
			case CLERIC:	return (ArrayList<Proficiencies>)((Cleric)        selectedClass).getProficiencies();
			case DRUID:		return (ArrayList<Proficiencies>)((Druid)         selectedClass).getProficiencies();
			case FIGHTER:	return (ArrayList<Proficiencies>)((Fighter)       selectedClass).getProficiencies();
			case MONK:		return (ArrayList<Proficiencies>)((Monk)          selectedClass).getProficiencies();
			case PALADIN:	return (ArrayList<Proficiencies>)((Paladin)       selectedClass).getProficiencies();
			case RANGER:	return (ArrayList<Proficiencies>)((Ranger)        selectedClass).getProficiencies();
			case ROGUE:		return (ArrayList<Proficiencies>)((Rogue)         selectedClass).getProficiencies();
			case SORCERER:	return (ArrayList<Proficiencies>)((Sorcerer)      selectedClass).getProficiencies();
			case WARLOCK:	return (ArrayList<Proficiencies>)((Warlock)       selectedClass).getProficiencies();
			case WIZZARD:	return (ArrayList<Proficiencies>)((Wizzard)       selectedClass).getProficiencies();
			default: return errorProficiences;
			}
		}
		return errorProficiences;
	}
	
	public String getClassSkillString(){
		if (selectedClass != null){
			switch(cName){
			case BARBARIAN: return "Barbarian: " + (String)((Barbarian) selectedClass).getSkillString();
			case BARD:      return "Bard: " +      (String)((Bard)      selectedClass).getSkillString();
			case CLERIC:	return "Cleric: " +    (String)((Cleric)    selectedClass).getSkillString();
			case DRUID:		return "Druid:  " +    (String)((Druid)     selectedClass).getSkillString();
			case FIGHTER:	return "Fighter: " +   (String)((Fighter)   selectedClass).getSkillString();
			case MONK:		return "Monk:  " +     (String)((Monk)      selectedClass).getSkillString();
			case PALADIN:	return "Paladin:  " +  (String)((Paladin)   selectedClass).getSkillString();
			case RANGER:	return "Ranger:  " +   (String)((Ranger)    selectedClass).getSkillString();
			case ROGUE:		return "Rogue:  " +    (String)((Rogue)     selectedClass).getSkillString();
			case SORCERER:	return "Sorcerer:  " + (String)((Sorcerer)  selectedClass).getSkillString();
			case WARLOCK:	return "Warlock:  " +  (String)((Warlock)   selectedClass).getSkillString();
			case WIZZARD:	return "Wizzard:  " +   (String)((Wizzard)  selectedClass).getSkillString();
			default: return "";
			}
		}
		return "";
	}
	
	public String setSavingThrows(){
		if (selectedClass != null){
			switch(cName){
			case BARBARIAN: savingThrows = (ArrayList<Attributes>)((Barbarian) selectedClass).getSavingThrows(); break;
			case BARD:      savingThrows = (ArrayList<Attributes>)((Bard)      selectedClass).getSavingThrows(); break;
			case CLERIC:	savingThrows = (ArrayList<Attributes>)((Cleric)    selectedClass).getSavingThrows(); break;
			case DRUID:		savingThrows = (ArrayList<Attributes>)((Druid)     selectedClass).getSavingThrows(); break;
			case FIGHTER:	savingThrows = (ArrayList<Attributes>)((Fighter)   selectedClass).getSavingThrows(); break;
			case MONK:		savingThrows = (ArrayList<Attributes>)((Monk)      selectedClass).getSavingThrows(); break;
			case PALADIN:	savingThrows = (ArrayList<Attributes>)((Paladin)   selectedClass).getSavingThrows(); break;
			case RANGER:	savingThrows = (ArrayList<Attributes>)((Ranger)    selectedClass).getSavingThrows(); break;
			case ROGUE:		savingThrows = (ArrayList<Attributes>)((Rogue)     selectedClass).getSavingThrows(); break;
			case SORCERER:	savingThrows = (ArrayList<Attributes>)((Sorcerer)  selectedClass).getSavingThrows(); break;
			case WARLOCK:	savingThrows = (ArrayList<Attributes>)((Warlock)   selectedClass).getSavingThrows(); break;
			case WIZZARD:	savingThrows = (ArrayList<Attributes>)((Wizzard)   selectedClass).getSavingThrows(); break;
			default: return "";
			}
		}
		return "";
	}

	public PDDocument savePDF() throws IOException, COSVisitorException{
		setModifiers();

		setField("Class&Level", newClass + " LvL: 1");
		setField("Race",        newRace);
		setField("Background",  newBackground);
		setField("ProfBonus" ,  profBonus );
		
		// Attributes
		setField("STR01", attributesSelected.get(0));
		setField("STR02", attributesModifiers[0]);
		setField("DEX01", attributesSelected.get(1));
		setField("DEX02", attributesModifiers[1]);
		setField("CON01", attributesSelected.get(2));
		setField("CON02", attributesModifiers[2]);
		setField("INT01", attributesSelected.get(3));
		setField("INT02", attributesModifiers[3]);
		setField("WIS01", attributesSelected.get(4));
		setField("WIS02", attributesModifiers[4]);
		setField("CHA01", attributesSelected.get(5));
		setField("CHA02", attributesModifiers[5]);
	
		// Saving Throws
		setSavingThrowMod();
		
		// Skills
		setSkillProficiences();
		
		setField("Perception", attributesSelected.get(4));
		
	    // Save edited file
	    return pdfTemplate;
	    //pdfTemplate.save("s.pdf");
	    //pdfTemplate.close();
	}
	
	private static void setField(String name, String value ) throws IOException {
		PDField field = acroForm.getField( name );
		if( field != null ) {
			field.setValue(value);
		}
		else {
			System.err.println( "No field found with name:" + name );
		}
	}
	
	private static void toggelButton(String name) throws IOException{
		PDField buttonToggel = acroForm.getField(name);
		if(buttonToggel != null){
		  ((PDCheckbox) buttonToggel).check();
		}
		else{
			System.err.println( "No field found with name:" + name );
		}
	}

	
	private void setSkillProficiences() throws IOException{
		
		System.out.println("prof size : "+ proficienciesSelected.size());
		
		for(int i = 0; i < attributesModifiers.length; i++){
			switch(i){
			case 0:{//STR
				// Athletics
				if(proficienciesSelected.contains("Athletics")){
					toggelButton("athl02"); //Btn
					setField("Athl01", addModAndProfBonus(i));
				}
				else{
					setField("Athl01", attributesModifiers[0]);
				}
				break;
			}
			case 1:{//DEX
				// Acrobatics
				if(proficienciesSelected.contains("Acrobatics")) {
					toggelButton("acro02"); //Btn
					setField("acro01", addModAndProfBonus(i));
				}
				else{
					setField("acro01", attributesModifiers[1]);
				}
				// Sleight of hand
				if(proficienciesSelected.contains("Sleight of Hand")) {
					toggelButton("slei02"); //Btn
				    setField("slei01", addModAndProfBonus(i));
				}
				else{
				    setField("slei01", attributesModifiers[1]);
				}
				// Stealth
				if(proficienciesSelected.contains("Stealth")){
					toggelButton("stea02"); //Btn
					setField("stea01", addModAndProfBonus(i));
				}
				else{
					setField("stea01", attributesModifiers[1]);
				}
				
				break;
			}
			case 2:{//CON
				break;
			}
			case 3:{//INT
				
				// Arcana
				if(proficienciesSelected.contains("Arcana"))   {
					toggelButton("arca02"); //Btn
					setField("arca01", addModAndProfBonus(i));
				}
				else{
					setField("arca01", attributesModifiers[3]);
				}
				
				// History
				if(proficienciesSelected.contains("History"))  {
					toggelButton("hist02"); //Btn
					setField("hist01", addModAndProfBonus(i));
				}
				else{
					setField("hist01", attributesModifiers[3]);
				}
				
				// Investigation
				if(proficienciesSelected.contains("Sleight of Hand")) {
					toggelButton("inve02"); //Btn
					setField("inve01", addModAndProfBonus(i));
				}
				else{
					setField("inve01", attributesModifiers[3]);
				}
				
				// Nature
				if(proficienciesSelected.contains("Nature")){
					toggelButton("natu02"); //Btn
					setField("natu01", addModAndProfBonus(i));
				}
				else{
					setField("natu01", attributesModifiers[3]);
				}
				
				// Religion
				if(proficienciesSelected.contains("Religion")){
					toggelButton("reli02"); //Btn
				    setField("reli01", addModAndProfBonus(i));
				}
				else{
				    setField("reli01", attributesModifiers[3]);
				}

				break;
			}
			case 4:{//WIS
				
				// Animal Handling
				if(proficienciesSelected.contains("Animal Handling")){
					toggelButton("Anim02"); //Btn
					setField("anim01", addModAndProfBonus(i));
				}
				else{
					setField("anim01", attributesModifiers[4]);
				}
				
				// Insight
				if(proficienciesSelected.contains("Religion")){
					toggelButton("insi02"); //Btn
					setField("insi01", addModAndProfBonus(i));
				}
				else{
					setField("insi01", attributesModifiers[4]);
				}
				
				// Medicine
				if(proficienciesSelected.contains("Medicine")){
					toggelButton("medi02"); //Btn
					setField("medi01", addModAndProfBonus(i));
				}
				else{
					setField("medi01", attributesModifiers[4]);
				}
				
				// Perception
				if(proficienciesSelected.contains("Perception")){
					toggelButton("perc02"); //Btn
					setField("perc01", addModAndProfBonus(i));
				}
				else{
					setField("perc01", attributesModifiers[4]);
				}
				
				// Survival
				if(proficienciesSelected.contains("Survival")){
					toggelButton("surv02"); //Btn
				    setField("surv01", addModAndProfBonus(i));
				}
				else{
				    setField("surv01", attributesModifiers[4]);
				}
			
				break;
			}
			case 5:{///CHA
				// Deception
				if(proficienciesSelected.contains("Deception")){
					toggelButton("dece02"); //Btn
					setField("dece01", addModAndProfBonus(i));
				}
				else{
					setField("dece01", attributesModifiers[5]);
				}
				
				// Intimidation
				if(proficienciesSelected.contains("Intimidation")){
					toggelButton("inti02"); //Btn
					setField("inti01", addModAndProfBonus(i));
				}
				else{
					setField("inti01", attributesModifiers[5]);
				}
				
				// Performance
				if(proficienciesSelected.contains("Performance")){
					toggelButton("perf02"); //Btn
					setField("perf01", addModAndProfBonus(i));
				}
				else{
					setField("perf01", attributesModifiers[5]);
				}
				
				// Persuasion
				if(proficienciesSelected.contains("Persuasion")){
					toggelButton("pers02"); //Btn
				    setField("pers01", addModAndProfBonus(i));
				}
				else{
				    setField("pers01", attributesModifiers[5]);
				}

				break;
			}
			default: break;
			}
		}
	}
	
	private String addModAndProfBonus(int i){
		return String.valueOf(Integer.parseInt(attributesModifiers[i]) + Integer.parseInt(profBonus)); 
	}
	
	private void setSavingThrowMod() throws IOException {
		setSavingThrows();
		
		//CHA
		if(savingThrows.contains(Attributes.CHA)){
			toggelButton("CHA04"); // Button
			setField("CHA03", addModAndProfBonus(5));
		}
		else{
			setField("CHA03", attributesModifiers[5]);
		}
		
		//DEX
		if(savingThrows.contains(Attributes.DEX)){
			toggelButton("DEX04"); // Button
			setField("DEX03", addModAndProfBonus(1));
		}
		else{
			setField("DEX03", attributesModifiers[1]);
		}
		
		//INT
		if(savingThrows.contains(Attributes.INT)){
			toggelButton("INT04"); // Button
			setField("INT03", addModAndProfBonus(3)); 
		}
		else{
			setField("INT03", attributesModifiers[3]); 
		}
		
		//STR
		if(savingThrows.contains(Attributes.STR)){
			toggelButton("STR04"); // Button 
			setField("STR03", addModAndProfBonus(0)); 
		}
		else{
			setField("STR03", attributesModifiers[0]); 
		}
		
		//CON
		if(savingThrows.contains(Attributes.CON)){
			toggelButton("CON04"); // Button
			setField("CON03", addModAndProfBonus(2)); 
		}
		else{
			setField("CON03", attributesModifiers[2]); 
		}
		
		//WIS
		if(savingThrows.contains(Attributes.WIS)){
			toggelButton("WIS04"); // Button
			setField("WIS03", addModAndProfBonus(4));
		}
		else{
			setField("WIS03", attributesModifiers[4]);
		}
	
	}

	private void setModifiers(){
		int index = 0;
		for( String s : attributesSelected){
			int val = Integer.parseInt(s);
			if(val == 1)      {attributesModifiers[index] =  "-5";}
			else if(val <= 3) {attributesModifiers[index] =  "-4";}
			else if(val <= 5) {attributesModifiers[index] =  "-3";}
			else if(val <= 6) {attributesModifiers[index] =  "-2";}
			else if(val <= 9) {attributesModifiers[index] =  "-1";}
			else if(val <= 11){attributesModifiers[index] =  "0"; }
			else if(val <= 13){attributesModifiers[index] =  "1"; }
			else if(val <= 15){attributesModifiers[index] =  "2"; }
			else if(val <= 17){attributesModifiers[index] =  "3"; }
			else if(val <= 19){attributesModifiers[index] =  "4"; }
			else if(val <= 21){attributesModifiers[index] =  "5"; }
			else if(val <= 23){attributesModifiers[index] =  "6"; }
			else if(val <= 25){attributesModifiers[index] =  "7"; }
			else if(val <= 27){attributesModifiers[index] =  "8"; }
			else if(val <= 29){attributesModifiers[index] =  "9"; }
			else if(val <= 30){attributesModifiers[index] =  "10";}
			else               attributesModifiers[index] =  "";
			
			index++;
		}
	}
	
}
