package dndProject;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSplitPane;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

public class DnDHandBook {

	public JFrame frame;
	private JSplitPane raceMenu, classMenu, backgroundMenu;
	public JPanel cCreationPanel;

	public CharacterCreation cC;
	public RaceMenu          rM;
	public ClassMenu         cM;
	public BackgroundMenu    bM;
	
	// Races
	public Human             hm;
	public Drow              dW;
	public HighElf           hiE;
	public WoodElf           wE;
	public HalfElf           hE;
	public HalfOrc           hO;
	public DragonBorn        dB;
	public Tiefling          tF;
	public ForrestGnome      fG;
	public RockGnome         rG;
	public HillDwarf         hD;
	public MountainDwarf     mD;
	public LightfootHalfling lfH;
	public StoutHalfling     sH;
	
	// Classes
	public Barbarian bB;
	public Bard      b;
	public Cleric    c;
	public Druid     d;
	public Fighter   f;
	public Monk      m;
	public Paladin   p;
	public Ranger    rA;
	public Rogue     rO;
	public Sorcerer  sO;
	public Warlock   wA;
	public Wizzard   wI;
	
	// Background
	public Artisan      a;
	public Criminal     crM;
	public Charlatan    cL;
	public Entertainer  e;
	public FolkHero     fH;
	public GuildArtisan gA;
	public Hermit       h;
	public Noble        n;
	public Outlander    o;
	public Sage         sG;
	public Sailor       sA;
	public Soldier      sD;
	public Urchin       u;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DnDHandBook window = new DnDHandBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DnDHandBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		// Menues 
		cC = new CharacterCreation();
		rM = new RaceMenu();
		cM = new ClassMenu();
		bM = new BackgroundMenu();
		
		// Races
		hm  = rM.getHuman(); 
		dW  = rM.getDrow();
		hiE = rM.getHighElf();
		wE  = rM.getWoodElf(); 
		dB  = rM.getDragonBorn();
		tF  = rM.getTiefing();
		hE  = rM.getHalfElf();
		hO  = rM.getHalfOrc();
		fG  = rM.getForrestGnome();
		rG  = rM.getRockGnome();
		hD  = rM.getHillDwarf();
		mD  = rM.getMountainDwarf(); 
		lfH = rM.getLightfootHalfling();
		sH  = rM.getStoutHalfling(); 
		
		//Classes
		bB = cM.getBarbarian();
		b  = cM.getBard();
		c  = cM.getCleric();
		d  = cM.getDruid();
		f  = cM.getFighter();
		m  = cM.getMonk();
		p  = cM.getPaladin();
		rA = cM.getRanger();
		rO = cM.getRogue();
		sO = cM.getSorcerer();
		wA = cM.getWarlock();
		wI = cM.getWizzard();
		
		//Backgrounds
		a   = bM.getArtisan();
		crM = bM.getCriminal();
		cL  = bM.getCharlatan();
		e   = bM.getEntertainer();
		fH  = bM.getFolkHero();
		gA  = bM.getGuildArtisan();
		h   = bM.getHermit();
		n   = bM.getNoble();
		o   = bM.getOutlander();
		sG  = bM.getSage();
		sA  = bM.getSailor();
		sD  = bM.getSoldier();
		u   = bM.getUrchin();
		
		//frame.setBounds(100, 100, 532, 300);
		frame.setSize(720, 540);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel startMenu = new JPanel();
		frame.getContentPane().add(startMenu, "name_730638497947775");
		startMenu.setLayout(new MigLayout("", "[100%,center]", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));

		JLabel titleName = new JLabel("DnD Hand Book");
		titleName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		startMenu.add(titleName, "cell 0 2,alignx center,aligny center");
		
		JButton loadCharacter = new JButton("Load Character");
		startMenu.add(loadCharacter, "cell 0 6,alignx center,aligny center");
		
		JButton createCharacter = new JButton("Create Character");
		startMenu.add(createCharacter, "cell 0 7,alignx center,aligny center");
		
		createCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cCreationPanel = cC.getCharacterCreationPanel();
				frame.getContentPane().add(cCreationPanel);
				startMenu.setVisible(false);
				cCreationPanel.setVisible(true);	
			}
		}); 
		
		JButton raceMenuOpen = cC.getOpenRaceMenuButton();
		raceMenuOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				raceMenu = rM.getRaceMenuSplitPane();
				frame.getContentPane().add(raceMenu);
				cCreationPanel.setVisible(false);
				raceMenu.setVisible(true);	
			}
		});

		JButton classMenuOpen = cC.getOpenClassMenu();
		classMenuOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				classMenu = cM.getClassMenuSplitPane();
				frame.getContentPane().add(classMenu);
				cCreationPanel.setVisible(false);
				classMenu.setVisible(true);	
			}
		});
		
		JButton backgroundMenuOpen = cC.getOpenBackgroundMenu();
		backgroundMenuOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				backgroundMenu = bM.getBackgroundMenuSplitPane();
				frame.getContentPane().add(backgroundMenu);
				cCreationPanel.setVisible(false);
				backgroundMenu.setVisible(true);	
			}
		});
		
		// Waiting for Chosen Race
		waitForRaceAcceptance( hm.getAcceptedRace(), "Human");
		waitForRaceAcceptance( dW.getAcceptedRace(), "Drow");
		waitForRaceAcceptance(hiE.getAcceptedRace(), "High Elf");
		waitForRaceAcceptance( wE.getAcceptedRace(), "Wood Elf");
		waitForRaceAcceptance( dB.getAcceptedRace(), "DragonBorn");
		waitForRaceAcceptance( tF.getAcceptedRace(), "Tiefling");
		waitForRaceAcceptance( hE.getAcceptedRace(), "Half Elf");
		waitForRaceAcceptance( hO.getAcceptedRace(), "Half Orc");
		waitForRaceAcceptance( rG.getAcceptedRace(), "Rock Gnome");
		waitForRaceAcceptance( fG.getAcceptedRace(), "Forrest Gnome");
		waitForRaceAcceptance( hD.getAcceptedRace(), "Hill Dwarf");
		waitForRaceAcceptance( mD.getAcceptedRace(), "Mountain Dwarf");
		waitForRaceAcceptance(lfH.getAcceptedRace(), "LightFoot Halfling");
		waitForRaceAcceptance( sH.getAcceptedRace(), "Stout Halfling");
		
		// Waiting for Chosen Class
		waitForClassAcceptance(bB.getAcceptedClass(), "Barbarian");
		waitForClassAcceptance( b.getAcceptedClass(), "Bard");
		waitForClassAcceptance( c.getAcceptedClass(), "Cleric");
		waitForClassAcceptance( d.getAcceptedClass(), "Druid");
		waitForClassAcceptance( f.getAcceptedClass(), "Fighter");
		waitForClassAcceptance( m.getAcceptedClass(), "Monk");
		waitForClassAcceptance( p.getAcceptedClass(), "Paladin");
		waitForClassAcceptance(rA.getAcceptedClass(), "Ranger");
		waitForClassAcceptance(rO.getAcceptedClass(), "Rogue");
		waitForClassAcceptance(sO.getAcceptedClass(), "Sorcerer");
		waitForClassAcceptance(wA.getAcceptedClass(), "Warlock");
		waitForClassAcceptance(wI.getAcceptedClass(), "Wizzard");
		
		// Waiting for Chosen Background
		waitForBackgroundAcceptance(  a.getAcceptedBackground(),"Artisan");
		waitForBackgroundAcceptance(crM.getAcceptedBackground(),"Criminal");
		waitForBackgroundAcceptance( cL.getAcceptedBackground(),"Charlatan");
		waitForBackgroundAcceptance(  e.getAcceptedBackground(),"Entertainer");
		waitForBackgroundAcceptance( fH.getAcceptedBackground(),"Folk Hero");
		waitForBackgroundAcceptance( gA.getAcceptedBackground(),"Guild Artisan");
		waitForBackgroundAcceptance(  h.getAcceptedBackground(),"Hermit");
		waitForBackgroundAcceptance(  n.getAcceptedBackground(),"Noble");
		waitForBackgroundAcceptance(  o.getAcceptedBackground(),"Outlander");
		waitForBackgroundAcceptance( sG.getAcceptedBackground(),"Sage");
		waitForBackgroundAcceptance( sA.getAcceptedBackground(),"Sailor");
		waitForBackgroundAcceptance( sD.getAcceptedBackground(),"Soldier");
		waitForBackgroundAcceptance(  u.getAcceptedBackground(),"Urchin");
	}
	
	public void waitForRaceAcceptance( JButton race, final String name){
			race.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				raceMenu.setVisible(false);
				cC.setRace(name);
				cCreationPanel.setVisible(true);
			}
		});
	}
	
	public void waitForClassAcceptance( JButton classButton, final String className){
		classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				classMenu.setVisible(false);
				cC.setClass(className);
				cCreationPanel.setVisible(true);
			}
		});
	}
	
	public void waitForBackgroundAcceptance( JButton backgroundButton, final String backgroundName){
		backgroundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				backgroundMenu.setVisible(false);
				cC.setBackground(backgroundName);
				cCreationPanel.setVisible(true);
			}
		});
	}
}
