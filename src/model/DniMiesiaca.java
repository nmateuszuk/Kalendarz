package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class DniMiesiaca {
	private int dni[][] = new int[6][7];
	private JLabel dniEtykiety[][] = new JLabel[6][7];
	private int miesiace[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private String nazwyMiesiecy[] = new String[]{"Styczen", "Luty", "Marzec", "Kwiecien", "Maj", "Czerwiec", "Lipiec", "Sierpien",
	"Wrzesien", "Pazdziernik", "Listopad", "Grudzien"};	
	private Calendar calendar;
	public int rok, miesiac;

	public DniMiesiaca(Date data) {
		ustawDate(data);
	}

	private void wypelnijTabele() {
		// zerujemy tablice
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				dni[i][j] = 0;
			}
		}

		int poczatkowyDzienTygodnia = dzienTygodnia();
		int dniWMiesiacu = miesiace[miesiac];
		int dzien = 1;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				// w pierwszym tygodniu pomin dni z poprzedniego miesiaca
				if (i == 0 && j >= poczatkowyDzienTygodnia || i > 0) {
					// jak wpiszemy ostatni dzien miesiaca przerywamy wpisywanie
					if (dzien <= dniWMiesiacu) {
						dni[i][j] = dzien++;
					}
				}
			}
		}

		// for (int i = 0; i < 6; i++) {
		// for (int j = 0; j < 7; j++) {
		// Point punkt = new Point(j * 38, i * 30);
		// int szerokosc = 37, wysokosc = 29;
		// if (dni[i][j] == 0) {
		// dniEtykiety[i][j] = stworzEtykiete(" ", punkt, szerokosc,
		// wysokosc);
		// } else {
		// dniEtykiety[i][j] = stworzEtykiete(
		// Integer.toString(dni[i][j]), punkt, szerokosc,
		// wysokosc);
		// }
		// }
		// }
	}

	// private JLabel stworzEtykiete(String tekst, Point punkt, int szerokosc,
	// int wysokosc) {
	// JLabel etykieta = new JLabel();
	// etykieta.setHorizontalAlignment(JLabel.CENTER);
	// etykieta.setVerticalAlignment(JLabel.CENTER);
	// etykieta.setText(tekst);
	// etykieta.setBounds(new Rectangle(punkt, new Dimension(szerokosc,
	// wysokosc)));
	//
	// return etykieta;
	// }

	private int dzienTygodnia() {
		// DAY_OF_WEEK zwraca liczbe od 1 (niedziela) do 7 (sobota)
		// ¯eby 0 to by³ poniedzia³ek, to przesuwamy wynik o 5 i modulo 7
		Calendar tmpCalendar = Calendar.getInstance();
		tmpCalendar.setTime(calendar.getTime());
		tmpCalendar.set(Calendar.DAY_OF_MONTH, 1);

		return (tmpCalendar.get(Calendar.DAY_OF_WEEK) + 5) % 7;
	}

	public void ustawDate(Date data) {
		// nie ma publicznego konstruktora, korzystamy ze statycznej metody
		calendar = Calendar.getInstance();
		calendar.setTime(data);
		aktualizujDate();
	}
	
	public void dodajMiesiac(int ileDni)
	{
		calendar.add(Calendar.MONTH, ileDni);
		aktualizujDate();
	}

	private void aktualizujDate() {
		this.rok = calendar.get(Calendar.YEAR);
		this.miesiac = calendar.get(Calendar.MONTH);
		if ((this.rok % 4 == 0 && this.rok % 100 != 0) || this.rok % 400 == 0) {
			miesiace[1] = 29;
		} else {
			miesiace[1] = 28;
		}

		wypelnijTabele();
	}

	public int zwrocMiesiac() {
		int i = calendar.get(Calendar.MONTH);
		return i;
	}

	public String zwrocRok() {
		int i = calendar.get(Calendar.YEAR);
		return Integer.toString(i);
	}

	public int zwrocTabele(int i, int j) {
		return this.dni[i][j];
	}

	public JLabel zwrocEtykiete(int i, int j) {
		return this.dniEtykiety[i][j];
	}

	public String zwrocDate() {
		return nazwyMiesiecy[miesiac] + " " + Integer.toString(rok);
	}
}
