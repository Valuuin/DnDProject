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

public class RaceMenu {

	private String[] raceNames = { "Human", "Elf", "DragonBorn", "Tiefling", "HalfElf", "HalfOrc", "Gnome", "Dwarf", "Halfing" };
	private String[] elfNames = { "Dark Elf", "High Elf" };
	private String[] gnomeNames = { "Forrest Gnomes", "Rock Gnomes" };
	private String[] dwarfNames = { "Hill Dwarf", "Mountian Dwarf" };
	private String[] halfingNames = { "LightFoot Halfings", "Stout Halfings" };
	
	private JList<String[]> list, elfList; 
	private JSplitPane raceMenu, elfMenu;
	private Human hm; // memory lcoation 32
	private DragonBorn dB;
	private Tiefling tF;
	private HalfElf hE;
	private HalfOrc hO;
	
	private ListSelectionListener raceListener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			JList list = (JList) e.getSource();
			updateRaceRightPane(list.getSelectedIndex());
		}
	};
	
	private ListSelectionListener elfListener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			JList list = (JList) e.getSource();
			updateSubElfRightPane(list.getSelectedIndex());
		}
	};

	/**
	 * Create the panel.
	 */
	public RaceMenu() {
		
		hm = new Human(); /// save Humaon object into location 32
		dB = new DragonBorn();
		tF = new Tiefling();
		hE = new HalfElf();
		hO = new HalfOrc();
		
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
			elfList.addListSelectionListener(elfListener);
			
			JScrollPane elf_List = new JScrollPane(elfList);
			elfMenu.setLeftComponent(elf_List);
			updateSubElfRightPane(0);
			
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
		default: break;
		}
	}
		
	public void updateSubElfRightPane(int index){
		switch(index){
		case 0:
			// Content Filler Needs to be Relpaced
			elfMenu.setDividerLocation(100);
			Label darkElfTitle = new Label("Dark Elf");
			JPanel jpDarkElf = new JPanel();
			jpDarkElf.setLayout(new GridLayout());
			jpDarkElf.add(darkElfTitle);
			elfMenu.setRightComponent(jpDarkElf);
			break;
		case 1:
			// Content Filler Needs to be Relpaced
			elfMenu.setDividerLocation(100);
			Label highElfTitle = new Label("High Elf");
			JPanel jpHighElf = new JPanel();
			jpHighElf.setLayout(new GridLayout());
			jpHighElf.add(highElfTitle);
			elfMenu.setRightComponent(jpHighElf);
			break;
		default: break;
		}
	}
	
	public Human getHuman(){return hm;} // take location 32's object and return it to where ever it was called
	public DragonBorn getDragonBorn(){return dB;}
	public Tiefling getTiefing(){return tF;}
	public HalfElf getHalfElf(){return hE;}
	public HalfOrc getHalfOrc(){return hO;}
}
