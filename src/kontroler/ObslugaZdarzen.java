package kontroler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import org.w3c.dom.events.MouseEvent;

import widok.OknoFiltrowania;
import widok.OknoNowychZdarzen;

public class ObslugaZdarzen implements ActionListener {
	OknoNowychZdarzen okno;
	Organizer org;
	
	public ObslugaZdarzen(OknoNowychZdarzen okno, Organizer org) {
		this.okno = okno;
		this.org = org;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okno.getDodajZdarzenie()) {
			
			String nazwa = okno.getNazwaText().getText();
			String opis = okno.getOpisText().getText();
			String miejsc = okno.getMiejsceText().getText();
		}

	}

	public void wywolajOknoZdarzen() {
		okno.setVisible(true);
	}
	
	public void wywolajOknoFiltrowania() {
		OknoFiltrowania frame = new OknoFiltrowania();
		frame.setVisible(true);
	}
	
}
