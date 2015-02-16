package dndProject;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSplitPane;

import org.apache.pdfbox.exceptions.COSVisitorException;

import components.FileChooser;

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
import dndProject.Character.Race;
import dndProject.Character.bGround;
import dndProject.Character.cClass;
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
import java.io.IOException;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;

public class DnDHandBook  {

	public JFrame frame;
	private JSplitPane raceMenu, classMenu, backgroundMenu;
	public JPanel cCreationPanel, attributeMenu, proficienciesMenu;
	
	//Character 
	public Character character;
	
	// Main Windows 
	public CharacterCreation      cC;
	public RaceMenu               rM;
	public ClassMenu              cM;
	public BackgroundMenu         bM;
	public AttributeSelection     aS;
	public ProficienciesSelection pS;
	public FileChooser		  fC;
	
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
	
		// Character
		character = new Character();
		
		// Menues 
		cC = new CharacterCreation();
		rM = new RaceMenu();
		cM = new ClassMenu();
		bM = new BackgroundMenu();
		aS = new AttributeSelection();
		pS = new ProficienciesSelection();
		
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
			
		JButton createCharacter = new JButton("Create Character");
		startMenu.add(createCharacter, "cell 0 7,alignx center,aligny center");
		
	
		/*
		 *  BUTTON LISTENERS!!!!!!!
		 */
		
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
		
		JButton attributeSelectionMenu = cC.getOpenAttributes();
		attributeSelectionMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aS.updateTextFields(character);
				attributeMenu = aS.getAttributeSelectionPanel();
				frame.getContentPane().add(attributeMenu);
				cCreationPanel.setVisible(false);
				attributeMenu.setVisible(true);	
			}
		});
		
		JButton attributeSelectionBack = aS.getAttributeSelectionBack();
		attributeSelectionBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aS.resetAttributes();
				attributeMenu.setVisible(false);
				cCreationPanel.setVisible(true);
			}
		});
		
		JButton attributeSelectionSave = aS.getAttributeSelectionSave();
		attributeSelectionSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> attri = aS.getAttributeResults();
				cC.setAttributesResults(attri);
				character.setSavedAttributes(attri);
				attributeMenu.setVisible(false);
				cCreationPanel.setVisible(true);
			}
		});
		
		JButton proficienciesSelectionMenu = cC.getOpenProficiencies();
		proficienciesSelectionMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pS.updateEligibleProficiencies(character);
				proficienciesMenu = pS.getProficienciesSelectionJPanel();
				frame.getContentPane().add(proficienciesMenu);
				cCreationPanel.setVisible(false);
				proficienciesMenu.setVisible(true);	
			}
		});
		
		JButton proficienciesBackButton = pS.getProfBack();
		proficienciesBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pS.resetProficiencies();
				proficienciesMenu.setVisible(false);
				cCreationPanel.setVisible(true);
			}
		});
		
		JButton proficienciesSaveButton = pS.getProfSave();
		proficienciesSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> prof = pS.getProficienciesResults();
				character.setSavedProficiences(prof);
				cC.setProficienciesResults(prof);
				proficienciesMenu.setVisible(false);
				cCreationPanel.setVisible(true);
			}
		});
		
		JButton saveToPDF = cC.getSaveToPDF();
		saveToPDF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fC = new FileChooser();
				try {
					fC.openFileChooser(character.savePDF());
				} catch (COSVisitorException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		
		// Waiting for Chosen Race
		waitForRaceAcceptance( hm.getAcceptedRace(), "Human",              hm,  Race.HUMAN);
		waitForRaceAcceptance( dW.getAcceptedRace(), "Drow",               dW,  Race.DROW);
		waitForRaceAcceptance(hiE.getAcceptedRace(), "High Elf",           hiE, Race.HIGH_ELF);
		waitForRaceAcceptance( wE.getAcceptedRace(), "Wood Elf",           wE,  Race.WOOD_ELF);
		waitForRaceAcceptance( dB.getAcceptedRace(), "DragonBorn",         dB,  Race.DRAGONBORN);
		waitForRaceAcceptance( tF.getAcceptedRace(), "Tiefling",           tF,  Race.TIEFLING);
		waitForRaceAcceptance( hE.getAcceptedRace(), "Half Elf",           hE,  Race.HALF_ELF);
		waitForRaceAcceptance( hO.getAcceptedRace(), "Half Orc",           hO,  Race.HALF_ORC);
		waitForRaceAcceptance( rG.getAcceptedRace(), "Rock Gnome",         rG,  Race.ROCK_GNOME);
		waitForRaceAcceptance( fG.getAcceptedRace(), "Forrest Gnome",      fG,  Race.FORREST_GNOME);
		waitForRaceAcceptance( hD.getAcceptedRace(), "Hill Dwarf",         hD,  Race.HILL_DWARF);
		waitForRaceAcceptance( mD.getAcceptedRace(), "Mountain Dwarf",     mD,  Race.MOUNTAIN_DWARF);
		waitForRaceAcceptance(lfH.getAcceptedRace(), "LightFoot Halfling", lfH, Race.LIGHTFOOT_HALFLING);
		waitForRaceAcceptance( sH.getAcceptedRace(), "Stout Halfling",     sH,  Race.STOUT_HALFLING);
		
		// Waiting for Chosen Class
		waitForClassAcceptance(bB.getAcceptedClass(), "Barbarian", bB, cClass.BARBARIAN);
		waitForClassAcceptance( b.getAcceptedClass(), "Bard",      b,  cClass.BARD);
		waitForClassAcceptance( c.getAcceptedClass(), "Cleric",    c,  cClass.CLERIC);
		waitForClassAcceptance( d.getAcceptedClass(), "Druid",     d,  cClass.DRUID);
		waitForClassAcceptance( f.getAcceptedClass(), "Fighter",   f,  cClass.FIGHTER);
		waitForClassAcceptance( m.getAcceptedClass(), "Monk",      m,  cClass.MONK);
		waitForClassAcceptance( p.getAcceptedClass(), "Paladin",   p,  cClass.PALADIN);
		waitForClassAcceptance(rA.getAcceptedClass(), "Ranger",    rA, cClass.RANGER);
		waitForClassAcceptance(rO.getAcceptedClass(), "Rogue",     rO, cClass.ROGUE);
		waitForClassAcceptance(sO.getAcceptedClass(), "Sorcerer",  sO, cClass.SORCERER);
		waitForClassAcceptance(wA.getAcceptedClass(), "Warlock",   wA, cClass.WARLOCK);
		waitForClassAcceptance(wI.getAcceptedClass(), "Wizzard",   wI, cClass.WIZZARD);
		
		// Waiting for Chosen Background
		waitForBackgroundAcceptance(  a.getAcceptedBackground(),"Artisan",       a,   bGround.ARTISAN);
		waitForBackgroundAcceptance(crM.getAcceptedBackground(),"Criminal",      crM, bGround.CRIMINAL);
		waitForBackgroundAcceptance( cL.getAcceptedBackground(),"Charlatan",     cL,  bGround.CHARLATAN);
		waitForBackgroundAcceptance(  e.getAcceptedBackground(),"Entertainer",   e,   bGround.ENTERTAINER);
		waitForBackgroundAcceptance( fH.getAcceptedBackground(),"Folk Hero",     fH,  bGround.FOLKHERO);
		waitForBackgroundAcceptance( gA.getAcceptedBackground(),"Guild Artisan", gA,  bGround.GUILDARTISAN);
		waitForBackgroundAcceptance(  h.getAcceptedBackground(),"Hermit",        h,   bGround.HERMIT);
		waitForBackgroundAcceptance(  n.getAcceptedBackground(),"Noble",         n,   bGround.NOBLE);
		waitForBackgroundAcceptance(  o.getAcceptedBackground(),"Outlander",     o,   bGround.OUTLANDER);
		waitForBackgroundAcceptance( sG.getAcceptedBackground(),"Sage",          sG,  bGround.SAGE);
		waitForBackgroundAcceptance( sA.getAcceptedBackground(),"Sailor",        sA,  bGround.SAILOR);
		waitForBackgroundAcceptance( sD.getAcceptedBackground(),"Soldier",       sD,  bGround.SOLDIER);
		waitForBackgroundAcceptance(  u.getAcceptedBackground(),"Urchin",        u,   bGround.URCHIN);
	}
	
	public void waitForRaceAcceptance( JButton race, final String name, final Object r, final Race rName){
			race.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (character.getRaceName() != name)
					resetAtributesAndProficiences();
				raceMenu.setVisible(false);
				character.setRace(r,name,rName);
				cC.setRace(name);
				cCreationPanel.setVisible(true);
			}
		});
	}
	
	public void waitForClassAcceptance( JButton classButton, final String className, final Object c, final cClass cName){
		classButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(character.getClassName() != className)
					resetAtributesAndProficiences();
				classMenu.setVisible(false);
				character.setClass(c,className,cName);
				cC.setClass(className);
				cCreationPanel.setVisible(true);
			}
		});
	}
	
	public void waitForBackgroundAcceptance( JButton backgroundButton, final String backgroundName, final Object b, final bGround bName){
		backgroundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(character.getBackgroundName() != backgroundName)
					resetAtributesAndProficiences();
				backgroundMenu.setVisible(false);
				character.setBackground(b, backgroundName,bName);
				cC.setBackground(backgroundName);
				cCreationPanel.setVisible(true);
			}
		});
	}
	
	private void resetAtributesAndProficiences(){
		pS.resetProficiencies();
		cC.resetProficienciesResults();
		aS.resetAttributes();
		cC.resetAttributesResults();
	}

}
