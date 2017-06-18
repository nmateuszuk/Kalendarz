package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;


	public class PasekMenuObsluga implements ActionListener{
		JMenuItem noweZdarzenie, filtrowanieZdarzen, usuwanieZdarzen, zamkniecieOkna, ustawienia, wyswietlanieKalendarza,
		 informacje;
		
		PasekMenuObsluga(JMenuItem noweZdarzenie, JMenuItem filtrowanieZdarzen, JMenuItem usuwanieZdarzen,
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
				//new NoweZdarzenie();
			}
			
			if(e.getSource()==filtrowanieZdarzen){
				//new OknoFiltrowania();
			}
			
			if(e.getSource()==usuwanieZdarzen){
			//	new UsuwanieZdarzenia();
			}
			
			if(e.getSource()==zamkniecieOkna){
				System.exit(0);
			}
			
			if(e.getSource()==informacje){
				//new InformacjeKoncowe();
			}
			
	}

}
