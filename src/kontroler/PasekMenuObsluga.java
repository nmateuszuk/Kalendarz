package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import widok.OProgramie;
import widok.OknoFiltrowania;
import widok.OknoNowychZdarzen;


	public class PasekMenuObsluga implements ActionListener{
		JMenuItem noweZdarzenie, filtrowanieZdarzen, usuwanieZdarzen, zamkniecieOkna, ustawienia, wyswietlanieKalendarza,
		 informacje;
		
		public PasekMenuObsluga(JMenuItem noweZdarzenie, JMenuItem filtrowanieZdarzen, JMenuItem usuwanieZdarzen,
				JMenuItem zamkniecieOkna, JMenuItem informacje){
			this.noweZdarzenie = noweZdarzenie;
			this.filtrowanieZdarzen = filtrowanieZdarzen;
			this.usuwanieZdarzen = usuwanieZdarzen;
			this.zamkniecieOkna = zamkniecieOkna; 
			this.informacje = informacje;
		}

		//@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==noweZdarzenie){
				ObslugaZdarzen okno= new ObslugaZdarzen();
				//SQLConnection nowePolaczenie= new SQLConnection();
				okno.wywolajOknoZdarzen();
				//nowePolaczenie.addZdarzenieToSQL ();
			}
			
			if(e.getSource()==filtrowanieZdarzen){
				ObslugaZdarzen okno= new ObslugaZdarzen();
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
			
	}

}
