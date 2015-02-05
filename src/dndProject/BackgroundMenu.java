package dndProject;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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

public class BackgroundMenu {
private String[] backgroundNames = {"Artisan","Criminal","Charlatan","Entertainer","Folk Hero","Guild Artisan","Hermit","Noble","Outlander","Sage","Sailor","Soldier","Urchin"};
	
	private JList<String[]> backgroundList;
	private JSplitPane backgroundMenu;

	private Artisan a;
	private Criminal cM;
	private Charlatan cL;
	private Entertainer e;
	private FolkHero fH;
	private GuildArtisan gA;
	private Hermit h;
	private Noble n;
	private Outlander o;
	private Sage sG;
	private Sailor sA;
	private Soldier sD;
	private Urchin u;
	
	private ListSelectionListener backgroundListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			JList list = (JList) e.getSource();
			updateBackgroundRightPane(list.getSelectedIndex());
		}
	};
	
	public BackgroundMenu(){
		
		 a  = new Artisan();
		 cM = new Criminal();
		 cL = new Charlatan();
		 e  = new Entertainer();
		 fH = new FolkHero();
		 gA = new GuildArtisan();
		 h  = new Hermit();
		 n  = new Noble();
		 o  = new Outlander();
		 sG = new Sage();
		 sA = new Sailor();
		 sD = new Soldier();
		 u  = new Urchin();
		
		backgroundMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		backgroundMenu.setOneTouchExpandable(true);
		backgroundMenu.setDividerLocation(100);
		
		backgroundList = new JList(backgroundNames);
		backgroundList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		backgroundList.setSelectedIndex(0);
		backgroundList.addListSelectionListener(backgroundListener);
		
		JScrollPane cList = new JScrollPane(backgroundList);
		backgroundMenu.setLeftComponent(cList);
		updateBackgroundRightPane(0);
	}
	
	public JSplitPane getBackgroundMenuSplitPane(){return backgroundMenu;}

	public void updateBackgroundRightPane(int index){
		switch(index){
		case 0: // Artisan
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(a.getJPanel());
			break;
		case 1: // Criminal
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(cM.getJPanel());
			break;
		case 2: // Carlatan
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(cL.getJPanel());
			break;
		case 3: // Entertainer
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(e.getJPanel());
			break;
		case 4: // Folk Hero
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(fH.getJPanel());
			break;
		case 5: // Guild Artisan
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(gA.getJPanel());
			break;
		case 6: // Hermit
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(h.getJPanel());
			break;
		case 7: // Noble
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(n.getJPanel());
			break;
		case 8: // Outlander
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(o.getJPanel());
			break;
		case 9: // Sage
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(sG.getJPanel());
			break;
		case 10:// Sailor
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(sA.getJPanel());
			break;
		case 11:// Soldier
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(sD.getJPanel());
			break;
		case 12:// Urchin
			backgroundMenu.setDividerLocation(100);
			backgroundMenu.setRightComponent(u.getJPanel());
			break;
		default: break;
		}
	}
	
	public Artisan      getArtisan(){return a;}
	public Criminal     getCriminal(){return cM;}
	public Charlatan    getCharlatan(){return cL;}
	public Entertainer  getEntertainer(){return e;}
	public FolkHero     getFolkHero(){return fH;}
	public GuildArtisan getGuildArtisan(){return gA;}
	public Hermit       getHermit(){return h;}
	public Noble        getNoble(){return n;}
	public Outlander    getOutlander(){return o;}
	public Sage         getSage(){return sG;}
	public Sailor       getSailor(){return sA;}
	public Soldier      getSoldier(){return sD;}
	public Urchin       getUrchin(){return u;}
}
