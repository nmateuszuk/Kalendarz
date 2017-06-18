package kontroler;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import model.Zdarzenie;

import widok.OknoNowychZdarzen;
import widok.WidokKalendarza;

public class PrzyciskiDniObsluga implements ActionListener{
	private int dzien;
	private int miesiac;
	private int rok;
	private JTextArea DzisiejszeWydarzenia;
	
	public PrzyciskiDniObsluga(int dzien, int miesiac, int rok , JTextArea dzisiejszeWydarzenia){
		this.dzien= dzien;
		this. miesiac= miesiac; 
		this.rok = rok;
		this.DzisiejszeWydarzenia= dzisiejszeWydarzenia;
		
	}

	public void actionPerformed(ActionEvent e) {
		SQLConnection sqlPolacz= new SQLConnection("sql.ggeasy.nazwa.pl:3306", "ggeasy_2", "ggeasy_2", "Haslo123");
		Organizer org = new Organizer(sqlPolacz);
		Date data= new Date(rok-1900, miesiac, dzien);
		
		List<Zdarzenie> lista= org.getZdarzeniaFromDay(data);
		
		String buffer = "Brak Zadan.";
		
		if (lista.size() != 0) {
			buffer = "";
			for (int i=0; i<lista.size(); i++) {
				buffer += i+1;
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				buffer += ". " + sdf.format(lista.get(i).getDataZdarzenia());
				buffer += " " + lista.get(i).getNazwa();
				buffer += "\n" + lista.get(i).getOpis() + "\n\n";
			}
		}
		DzisiejszeWydarzenia.setText(buffer);

		
	}
	
}
