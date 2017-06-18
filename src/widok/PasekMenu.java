package widok;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import kontroler.PasekMenuObsluga;

public class PasekMenu {
	private JMenuBar listaMenu;
	private JMenu kafelekMenuPlik, kafelekMenuNarzedzia, kafelekMenuInformacje;
	private JMenuItem noweZdarzenie, filtrowanieZdarzen, usuwanieZdarzen,
			zamkniecieOkna, informacje;

	// PasekMenuObsluga obslugaMenu;

	PasekMenu() {

		listaMenu = new JMenuBar();

		kafelekMenuPlik = new JMenu("Menu");
		listaMenu.add(kafelekMenuPlik);

		noweZdarzenie = new JMenuItem("Nowe zdarzenie");
		kafelekMenuPlik.add(noweZdarzenie);

		filtrowanieZdarzen = new JMenuItem("Flitruj zdarzenia");
		kafelekMenuPlik.add(filtrowanieZdarzen);

		//usuwanieZdarzen = new JMenuItem("Usuñ zdarzenie");
		//kafelekMenuPlik.add(usuwanieZdarzen);

		zamkniecieOkna = new JMenuItem("Zakoñcz");
		kafelekMenuPlik.add(zamkniecieOkna);

		kafelekMenuInformacje = new JMenu("Informacje");
		listaMenu.add(kafelekMenuInformacje);

		informacje = new JMenuItem("O programie");
		kafelekMenuInformacje.add(informacje);

		
		PasekMenuObsluga obslugaMenu  = new PasekMenuObsluga(noweZdarzenie, filtrowanieZdarzen,
		usuwanieZdarzen, zamkniecieOkna,informacje);
		
		 noweZdarzenie.addActionListener(obslugaMenu);
		filtrowanieZdarzen.addActionListener(obslugaMenu);
		// usuwanieZdarzen.addActionListener(obslugaMenu);
		zamkniecieOkna.addActionListener(obslugaMenu);
		informacje.addActionListener(obslugaMenu);
	}

	JMenuBar zwrocPasekMenu() {
		return listaMenu;
	}

}
