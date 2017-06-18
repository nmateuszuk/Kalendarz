package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import widok.OProgramie;
import widok.OknoFiltrowania;
import widok.OknoNowychZdarzen;


	public class PasekMenuObsluga implements ActionListener{
		JMenuItem noweZdarzenie, filtrowanieZdarzen, usuwanieZdarzen, zamkniecieOkna, ustawienia, wyswietlanieKalendarza, 
		 informacje, importXML, eksportXML;
		Organizer org;
		
		public PasekMenuObsluga(JMenuItem noweZdarzenie, JMenuItem filtrowanieZdarzen, JMenuItem usuwanieZdarzen,
				JMenuItem zamkniecieOkna, JMenuItem informacje, Organizer org){
			this.noweZdarzenie = noweZdarzenie;
			this.filtrowanieZdarzen = filtrowanieZdarzen;
			this.usuwanieZdarzen = usuwanieZdarzen;
			this.zamkniecieOkna = zamkniecieOkna; 
			this.informacje = informacje;
			this.org = org;
		}

		//@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==noweZdarzenie){
				ObslugaZdarzen okno = new ObslugaZdarzen(new OknoNowychZdarzen(), org);
				//SQLConnection nowePolaczenie= new SQLConnection();
				okno.wywolajOknoZdarzen();
				//nowePolaczenie.addZdarzenieToSQL ();
			}
			
			if(e.getSource()==filtrowanieZdarzen){
				ObslugaZdarzen okno = new ObslugaZdarzen(new OknoNowychZdarzen(),org);
				okno.wywolajOknoFiltrowania();
			}
			
			if(e.getSource()==usuwanieZdarzen){
			//	new UsuwanieZdarzenia();
			}
			
			if(e.getSource()==zamkniecieOkna){
				System.exit(0);
			}
			
			if(e.getSource()==informacje){
				OProgramie okno= new OProgramie();
				okno.wywolajOknoProgram();
			}
			
			
			if(e.getSource()==importXML){
				OProgramie okno= new OProgramie();
				okno.wywolajOknoProgram();
			}
			
			if(e.getSource()==eksportXML){
				OProgramie okno= new OProgramie();
				okno.wywolajOknoProgram();
			}
	}

}
