package widok;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;

import org.w3c.dom.events.MouseEvent;

import kontroler.ObslugaKalendarza;
import kontroler.Organizer;
import kontroler.PrzyciskiDniObsluga;
import kontroler.SQLConnection;
import model.DniMiesiaca;
import model.Zdarzenie;

public class WidokKalendarza extends JFrame {

	private JPanel contentPane;

	DniMiesiaca dniMiesiaca;
	
	ObslugaKalendarza kontroler;
	
	static String miesiace[] = new String[] { "Styczen", "Luty", "Marzec",
			"Kwiecien", "Maj", "Czerwiec", "Lipiec", "Sierpien", "Wrzesien",
			"Pazdziernik", "Listopad", "Grudzien" };

	static String dni[] = new String[] { "Pon", "Wto", "Sro", "Czw", "Pia",
			"Sob", "Nie" };

	private JButton lewyPrzycisk;
	private JButton prawyPrzycisk;
	private JButton ustawieniaPrzycisk;
	private JButton dodajWydarzeniePrzycisk;
	private JButton dzisiajPrzycisk;
	private JTextArea DzisiejszeWydarzenia;
	private JLabel miesiacEtykieta;

	private JPanel dniMiesiac;
//	public int rok, miesiac;

	public WidokKalendarza(DniMiesiaca dniMiesiaca) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 418);

		this.dniMiesiaca = dniMiesiaca;
		this.kontroler = new ObslugaKalendarza(dniMiesiaca, this);

		// lista menu
		PasekMenu pasek = new PasekMenu();
		JMenuBar listaMenu = new JMenuBar();
		setJMenuBar(listaMenu);
		listaMenu.add(pasek.zwrocPasekMenu());

		// glowny obszar
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

//		ustawieniaPrzycisk = new JButton("Ustawienia");
//		getUstawieniaPrzycisk().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		getUstawieniaPrzycisk().setBounds(398, 310, 196, 37);
//		contentPane.add(getUstawieniaPrzycisk());

		// kalendarz//////////////////////////////////////////////////////////

		lewyPrzycisk = new JButton("<");
		getLewyPrzycisk().setBounds(300, 50, 40, 40);
		// lewyPrzycisk.setText("<");
		getLewyPrzycisk().setBorder(
				BorderFactory.createLineBorder(Color.white, 0));
		contentPane.add(getLewyPrzycisk());

		prawyPrzycisk = new JButton(">");
		getPrawyPrzycisk().setBounds(476, 50, 40, 40);
		// prawyPrzycisk.setText(">");
		getPrawyPrzycisk().setBorder(
				BorderFactory.createLineBorder(Color.white, 1));
		contentPane.add(getPrawyPrzycisk());

		miesiacEtykieta = new JLabel();
		miesiacEtykieta.setBounds(350, 52, 116, 37);
		miesiacEtykieta.setText(miesiace[dniMiesiaca.zwrocMiesiac()] + " "
				+ dniMiesiaca.zwrocRok());
		miesiacEtykieta.setHorizontalAlignment(JLabel.CENTER);
		miesiacEtykieta.setVerticalAlignment(JLabel.CENTER);
		// miesiacEtykieta.setBorder(BorderFactory.createLineBorder(Color.black,
		// 1));
		contentPane.add(miesiacEtykieta);

		// wypisanie nazw dni tygodnia

		JLabel dniTygodnia = new JLabel();
		dniTygodnia.setBounds(300, 90, 264, 28);
		dniTygodnia.setText(wypiszDniTygodnia(6));
		// dniTygodnia.setBorder(BorderFactory.createLineBorder(Color.black,
		// 1));
		contentPane.add(dniTygodnia);

		dniMiesiac = new JPanel();
		dniMiesiac.setBounds(300, 119, 264, 180);
		// dniMiesiac.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		dniMiesiac.setLayout(null);
		contentPane.add(dniMiesiac);

		dodajWydarzeniePrzycisk = new JButton("Dodaj wydarzenie");
		getDodajWydarzeniePrzycisk().setBounds(33, 52, 212, 37);
		contentPane.add(getDodajWydarzeniePrzycisk());

		dzisiajPrzycisk = new JButton("Dzisiaj");
		dzisiajPrzycisk.setForeground(new Color(0, 0, 51));
		getDzisiajPrzycisk().setBounds(518, 50, 76, 40);
		dzisiajPrzycisk.setBorder(BorderFactory
				.createLineBorder(Color.WHITE, 1));
		contentPane.add(getDzisiajPrzycisk());

		// /////////////////////////////////////////////////////////
		
		DzisiejszeWydarzenia = new JTextArea();
		DzisiejszeWydarzenia.setEditable(false);
		DzisiejszeWydarzenia.setLineWrap(true);
		DzisiejszeWydarzenia.setBounds(33, 119, 212, 180);
		contentPane.add(DzisiejszeWydarzenia);
		
		wypiszDniMiesiaca();

		// ///////////////////////////////////////////////////zdarzenia pod
		// przyciski
		
		lewyPrzycisk.addActionListener(kontroler);
		prawyPrzycisk.addActionListener(kontroler);
		//ustawieniaPrzycisk.addActionListener(kontroler);
		dodajWydarzeniePrzycisk.addActionListener(kontroler);
		dzisiajPrzycisk.addActionListener(kontroler);
		
	}

	public void wypiszDniMiesiaca() {
		dniMiesiac.removeAll();
		miesiacEtykieta.setText(dniMiesiaca.zwrocDate());

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				Point punkt = new Point(j * 37, i * 30);
				JButton label;

				int dzien = dniMiesiaca.zwrocTabele(i, j);
				int szerokosc = 36, wysokosc = 28;
				if (dzien == 0) {
					label = stworzEtykiete(" ", punkt, szerokosc, wysokosc);
					label.setBorder(BorderFactory.createLineBorder(Color.WHITE,
							0));
				} else {
					label = stworzEtykiete(Integer.toString(dzien), punkt,
							szerokosc, wysokosc);
					label.setBorder(BorderFactory.createLineBorder(Color.WHITE,
							0));
				}
				Date date = new Date();
				if (dniMiesiaca.rok == date.getYear() + 1900
						&& dniMiesiaca.miesiac == date.getMonth()
						&& dzien == date.getDate())
					label.setBorder(BorderFactory
							.createLineBorder(Color.RED, 1));
//////////////////////////////////////////
//				SQLConnection sqlPolacz= new SQLConnection("sql.ggeasy.nazwa.pl:3306", "ggeasy_2", "ggeasy_2", "Haslo123");
//				Organizer org = new Organizer(sqlPolacz);
//				Date data= new Date(dniMiesiaca.rok-1900, dniMiesiaca.miesiac,dzien);
//				
//				List<Zdarzenie> lista= org.getZdarzeniaFromDay(data);
//				if (lista.size()!=0)
//				{
//					label.setBorder(BorderFactory
//							.createLineBorder(Color.BLUE, 1));
//				}
//				
				
				PrzyciskiDniObsluga dniPrzyciski= new PrzyciskiDniObsluga(dzien, dniMiesiaca.miesiac, dniMiesiaca.rok, DzisiejszeWydarzenia );
				label.addActionListener(dniPrzyciski);
				
				dniMiesiac.add(label);
			}
		}

		dniMiesiac.repaint();
	}

	// //////////////////////////////////////////////////////////////////////////////////
	private String wypiszDniTygodnia(int spacje) {
		String dayName = new String();
		for (int i = 0; i < 6; i++) {
			dayName += dni[i];
			for (int j = 0; j < spacje; j++)
				dayName += " ";
		}
		dayName += dni[6];
		return dayName;
	}

	// tworzy etykiety dni kalendarza
	private JButton stworzEtykiete(String tekst, Point punkt, int szerokosc,
			int wysokosc) {
		JButton etykieta = new JButton();
		etykieta.setHorizontalAlignment(JButton.CENTER);
		etykieta.setVerticalAlignment(JButton.CENTER);
		etykieta.setText(tekst);
		etykieta.setBounds(new Rectangle(punkt, new Dimension(szerokosc,
				wysokosc)));
		return etykieta;
	}

	public JButton getLewyPrzycisk() {
		return lewyPrzycisk;
	}

	public JButton getPrawyPrzycisk() {
		return prawyPrzycisk;
	}

	public JButton getUstawieniaPrzycisk() {
		return ustawieniaPrzycisk;
	}

	public JButton getDodajWydarzeniePrzycisk() {
		return dodajWydarzeniePrzycisk;
	}

	public JButton getDzisiajPrzycisk() {
		return dzisiajPrzycisk;
	}

	public void setMiesiacEtykieta(String etykieta) {
		miesiacEtykieta.setText(etykieta);
	}
}
