package dndProject;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.bouncycastle.util.test.Test;

import classCollection.Barbarian;
import classCollection.Bard;
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
	
	private static PDDocument _pdfDoc;
	
	ClassLoader loader = Test.class.getClassLoader();
	
	String characterSheetPDF = "\\DnDPlayerHandBook\\characterFourm.pdf";
	
	Race rName;
	cClass cName;
	bGround bName;
	
	Object selectedRace;
	Object selectedClass;
	Object selectedBackground;
	
	String newRace;
	String newClass;
	String newBackground;
	
	ArrayList<String> proficienciesSelected = new ArrayList<String>();
	
	ArrayList<String> errorString = new ArrayList<String>();
	ArrayList<Proficiencies> errorProficiences= new ArrayList<Proficiencies>();
	
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
			/*case CRIMINAL:   return (ArrayList<Proficiences>)((Criminal)	   selectedBackground).getProficiencies();
			case ENTERTAINER:  return (ArrayList<Proficiences>)((Entertainer)  selectedBackground).getProficiencies();
			case FOLKHERO:     return (ArrayList<Proficiences>)((FolkHero)     selectedBackground).getProficiencies();
			case GUILDARTISAN: return (ArrayList<Proficiences>)((GuildArtisan) selectedBackground).getProficiencies();
			case HERMIT:	   return (ArrayList<Proficiences>)((Hermit)       selectedBackground).getProficiencies();
			case NOBLE:		   return (ArrayList<Proficiences>)((Noble)        selectedBackground).getProficiencies();
			case OUTLANDER:	   return (ArrayList<Proficiences>)((Outlander)    selectedBackground).getProficiencies();
			case SAGE:		   return (ArrayList<Proficiences>)((Sage)         selectedBackground).getProficiencies();
			case SAILOR:	   return (ArrayList<Proficiences>)((Sailor)       selectedBackground).getProficiencies();
			case SOLDIER:      return (ArrayList<Proficiences>)((Soldier)      selectedBackground).getProficiencies();
			case URCHIN:	   return (ArrayList<Proficiences>)((Urchin)       selectedBackground).getProficiencies();
			*/default: return errorProficiences;
			}
		}
		return errorProficiences;
	}
	
	public ArrayList<Proficiencies> getClassProficiencies(){
		if (selectedClass != null){
			switch(cName){
			case BARBARIAN: return (ArrayList<Proficiencies>)((Barbarian) selectedClass).getProficiencies();
			case BARD:      return (ArrayList<Proficiencies>)((Bard)      selectedClass).getProficiencies();
			case CLERIC:
			case DRUID:
			case FIGHTER:
			case MONK:
			case PALADIN:
			case RANGER:
			case ROGUE:
			case SORCERER:
			case WARLOCK:
			case WIZZARD:
			default: return errorProficiences;
			}
		}
		return errorProficiences;
	}
	
	public String getClassSkillString(){
		if (selectedClass != null){
			switch(cName){
			case BARBARIAN: return "BarBarian: " + (String)((Barbarian) selectedClass).getSkillString();
			case BARD:      return "Bard: " +      (String)((Bard)      selectedClass).getSkillString();
			case CLERIC:
			case DRUID:
			case FIGHTER:
			case MONK:
			case PALADIN:
			case RANGER:
			case ROGUE:
			case SORCERER:
			case WARLOCK:
			case WIZZARD:
			default: return "";
			}
		}
		return "";
	}
	
	public void exportPDF(){
		System.out.println(loader);
	}
}
