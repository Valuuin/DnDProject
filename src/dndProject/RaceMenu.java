package dndProject;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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

public class RaceMenu {

	private String[] raceNames = { "Human", "Elf", "DragonBorn", "Tiefling", "HalfElf", "HalfOrc", "Gnome", "Dwarf", "Halfing" };
	private String[] elfNames = { "Drow", "High Elf", "Wood Elf" };
	private String[] gnomeNames = { "Forrest Gnomes", "Rock Gnomes" };
	private String[] dwarfNames = { "Hill Dwarf", "Mountian Dwarf" };
	private String[] halflingNames = { "LightFoot Halflings", "Stout Halflings" };
	
	private JList<String[]> list, elfList, gnomeList, dwarfList, halfingList; 
	private JSplitPane raceMenu, elfMenu, gnomeMenu, dwarfMenu, halfingMenu;
	private Human hm; 
	private DragonBorn dB;
	private Tiefling tF;
	private HalfElf hE;
	private HalfOrc hO;
	private Drow dO;
	private HighElf hiE;
	private WoodElf wE;
	private ForrestGnome fG;
	private RockGnome rG;
	private HillDwarf hD;
	private MountainDwarf mD;
	private LightfootHalfling lfH;
	private StoutHalfling sH;
	
	int raceListenerIndex = 0;
	
	private ListSelectionListener raceListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			JList list = (JList) e.getSource();
			raceListenerIndex = list.getSelectedIndex();
			updateRaceRightPane(raceListenerIndex);
		}
	};
	
	private ListSelectionListener subRaceListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			JList list = (JList) e.getSource();
			updateSubRaceRightPane(raceListenerIndex , list.getSelectedIndex());
		}
	};
	
	/**
	 * Create the panel.
	 */
	public RaceMenu() {
		
		hm =  new Human(); 
		dB =  new DragonBorn();
		tF =  new Tiefling();
		hE =  new HalfElf();
		hO =  new HalfOrc();
		dO =  new Drow();
		hiE = new HighElf();
		wE =  new WoodElf();
		fG =  new ForrestGnome();
		rG =  new RockGnome();
		hD =  new HillDwarf();
		mD =  new MountainDwarf();
		lfH = new LightfootHalfling();
		sH =  new StoutHalfling();
		
		raceMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		raceMenu.setOneTouchExpandable(true);
		raceMenu.setDividerLocation(100);
		
		list = new JList(raceNames);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(raceListener);
		
		JScrollPane raceList = new JScrollPane(list);
		raceMenu.setLeftComponent(raceList);
		updateRaceRightPane(0);
		
	}
	
	public JSplitPane getRaceMenuSplitPane(){return raceMenu;}
	
	public void updateRaceRightPane(int index){
		switch(index){
		case 0: // human
			raceMenu.setDividerLocation(100);
			raceMenu.setRightComponent(hm.getJPanel());
			
			break;
		case 1: // elf
			raceMenu.setDividerLocation(100);
			elfMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			elfMenu.setDividerLocation(100);
			raceMenu.setRightComponent(elfMenu);
			
			elfList = new JList(elfNames);
			elfList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			elfList.setSelectedIndex(0);
			elfList.addListSelectionListener(subRaceListener);
			
			JScrollPane elf_List = new JScrollPane(elfList);
			elfMenu.setLeftComponent(elf_List);
			updateSubRaceRightPane(raceListenerIndex,0);
			
			break;
		case 2: // DragonBorn
			raceMenu.setDividerLocation(100);
			raceMenu.setRightComponent(dB.getJPanel());
			break;
		case 3: // Tiefling
			raceMenu.setDividerLocation(100);
			raceMenu.setRightComponent(tF.getJPanel());
			break;
		case 4: // HalfElf
			raceMenu.setDividerLocation(100);
			raceMenu.setRightComponent(hE.getJPanel());
			break;
		case 5: // HalfOrc
			raceMenu.setDividerLocation(100);
			raceMenu.setRightComponent(hO.getJPanel());
			break;
		case 6: //	Gnome
			raceMenu.setDividerLocation(100);
			gnomeMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			gnomeMenu.setDividerLocation(100);
			raceMenu.setRightComponent(gnomeMenu);
			
			gnomeList = new JList(gnomeNames);
			gnomeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			gnomeList.setSelectedIndex(0);
			gnomeList.addListSelectionListener(subRaceListener);
			
			JScrollPane gnome_List = new JScrollPane(gnomeList);
			gnomeMenu.setLeftComponent(gnome_List);
			updateSubRaceRightPane(raceListenerIndex,0);
			break;
		case 7: //	Dwarf
			raceMenu.setDividerLocation(100);
			dwarfMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			dwarfMenu.setDividerLocation(100);
			raceMenu.setRightComponent(dwarfMenu);
			
			dwarfList = new JList(dwarfNames);
			dwarfList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			dwarfList.setSelectedIndex(0);
			dwarfList.addListSelectionListener(subRaceListener);
			
			JScrollPane dwarf_List = new JScrollPane(dwarfList);
			dwarfMenu.setLeftComponent(dwarf_List);
			updateSubRaceRightPane(raceListenerIndex,0);
			break;
		case 8: //	Halfing
			raceMenu.setDividerLocation(100);
			halfingMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
			halfingMenu.setDividerLocation(100);
			raceMenu.setRightComponent(halfingMenu);
			
			halfingList = new JList(halflingNames);
			halfingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			halfingList.setSelectedIndex(0);
			halfingList.addListSelectionListener(subRaceListener);
			
			JScrollPane halfling_List = new JScrollPane(halfingList);
			halfingMenu.setLeftComponent(halfling_List);
			updateSubRaceRightPane(raceListenerIndex,0);
			break;
		default: break;
		}
	}
		
	public void updateSubRaceRightPane(int raceIndex, int subRaceIndex){
		switch(raceIndex){
		case 1: // Elf
			switch(subRaceIndex){
			case 0: // Drow
				elfMenu.setDividerLocation(100);
				elfMenu.setRightComponent(dO.getJPanel());
				break;
			case 1: // High Elf
				elfMenu.setDividerLocation(100);
				elfMenu.setRightComponent(hiE.getJPanel());
				break;
			case 2: // Wood Elf
				elfMenu.setDividerLocation(100);
				elfMenu.setRightComponent(wE.getJPanel());
				break;
			default: break;
			}
			break;
		case 6: // Gnome
			switch(subRaceIndex){
			case 0: // Forrest Gnome
				gnomeMenu.setDividerLocation(100);
				gnomeMenu.setRightComponent(fG.getJPanel());
				break;
			case 1: // Rock Gnome
				gnomeMenu.setDividerLocation(100);
				gnomeMenu.setRightComponent(rG.getJPanel());
				break;
			default: break;
			}
			break;
		case 7: // Dwarf
			switch(subRaceIndex){
			case 0: // Hill Dwarf
				dwarfMenu.setDividerLocation(100);
				dwarfMenu.setRightComponent(hD.getJPanel());
				break;
			case 1: // Mountain Dwarf
				dwarfMenu.setDividerLocation(100);
				dwarfMenu.setRightComponent(mD.getJPanel());
				break;
			default: break;
			}
			break;
		case 8: // Halfling
			switch(subRaceIndex){
			case 0: // LightFoot Halfings
				halfingMenu.setDividerLocation(120);
				halfingMenu.setRightComponent(lfH.getJPanel());
				break;
			case 1: // Stout Halfings
				halfingMenu.setDividerLocation(120);
				halfingMenu.setRightComponent(sH.getJPanel());
			default: break;
			}
			break;
		default: break;
		}
	}
	
	public Human getHuman(){return hm;}
	public Drow getDrow(){return dO;}
	public HighElf getHighElf(){return hiE;}
	public WoodElf getWoodElf(){return wE;}
	public DragonBorn getDragonBorn(){return dB;}
	public Tiefling getTiefing(){return tF;}
	public HalfElf getHalfElf(){return hE;}
	public HalfOrc getHalfOrc(){return hO;}
	public ForrestGnome getForrestGnome(){return fG;}
	public RockGnome getRockGnome(){return rG;}
	public HillDwarf getHillDwarf(){return hD;}
	public MountainDwarf getMountainDwarf(){return mD;}
	public LightfootHalfling getLightfootHalfling(){return lfH;}
	public StoutHalfling getStoutHalfling(){return sH;}
}
