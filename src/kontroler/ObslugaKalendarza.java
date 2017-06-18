package kontroler;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.DniMiesiaca;

import widok.OknoNowychZdarzen;
import widok.WidokKalendarza;

public class ObslugaKalendarza implements ActionListener {
	DniMiesiaca model;
	WidokKalendarza widok;
	ObslugaZdarzen zdarzenia;
	Organizer org;

	public ObslugaKalendarza(DniMiesiaca model, WidokKalendarza widok, Organizer org) {
		this.model = model;
		this.widok = widok;
		this.org = org;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == widok.getLewyPrzycisk()) {
			model.dodajMiesiac(-1);
		} else if (e.getSource() == widok.getPrawyPrzycisk()) {
			model.dodajMiesiac(1);
		} else if (e.getSource() == widok.getDzisiajPrzycisk()) {
			model.ustawDate(new Date());
		}

	 else if (e.getSource() == widok.getDodajWydarzeniePrzycisk()) {
		 ObslugaZdarzen okno = new ObslugaZdarzen(new OknoNowychZdarzen(),org);
			//SQLConnection nowePolaczenie= new SQLConnection();
			okno.wywolajOknoZdarzen();
			//nowePolaczenie.addZdarzenieToSQL ();
	}
		/////////////////////////////akcja na labelki dni
	 else if (e.getSource() == widok.getDodajWydarzeniePrzycisk()) {
		 ObslugaZdarzen okno= new ObslugaZdarzen(new OknoNowychZdarzen(),org);
			//SQLConnection nowePolaczenie= new SQLConnection();
			okno.wywolajOknoZdarzen();
			//nowePolaczenie.addZdarzenieToSQL ();
	}
		
		
		
		
		
		widok.wypiszDniMiesiaca();
		
		}
		
		
	}
