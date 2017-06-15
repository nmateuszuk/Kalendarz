package widok;

import java.awt.EventQueue;
import java.awt.Point;

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
import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

import kontroler.ObslugaKalendarza;

public class WidokKalendarza extends JFrame {

	private JPanel contentPane;
	
	static String miesiace[] = new String[]{"Styczen", "Luty", "Marzec", "Kwiecien", "Maj", "Czerwiec", "Lipiec", 
		"Sierpien", "Wrzesien", "Pazdziernik", "Listopad", "Grudzien"};
	
	static String dni[] = new String[]{"Pon", "Wto", "Sro", "Czw", "Pia", "Sob", "Nie"};
	
	
	///////////////////////////////////////////////////////////////////////////////Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WidokKalendarza frame = new WidokKalendarza();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	///////////////////////////////////////Create the frame.
	public WidokKalendarza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 418);
		
		//////////////////////////// data
		Date dzis = new Date();
		DniMiesiaca dniMiesiaca = new DniMiesiaca(dzis);
		
		
		//lista menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu programu");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ustawienia
		JButton ustawieniaKlawisz = new JButton("Ustawienia");
		ustawieniaKlawisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ustawieniaKlawisz.setBounds(398, 310, 196, 37);
		contentPane.add(ustawieniaKlawisz);
		
		//kalendarz//////////////////////////////////////////////////////////
		
		JButton lewyPrzycisk = new JButton("<");
		lewyPrzycisk.setBounds(318, 50, 40, 40);
		//lewyPrzycisk.setText("<");
		lewyPrzycisk.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		contentPane.add(lewyPrzycisk);
		
		JButton prawyPrzycisk = new JButton(">");
		prawyPrzycisk.setBounds(512, 50, 40, 40);
		//prawyPrzycisk.setText(">");
		prawyPrzycisk.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		contentPane.add(prawyPrzycisk);
		
		JLabel miesiacEtykieta = new JLabel();
		miesiacEtykieta.setBounds(368, 53, 139, 37);
		miesiacEtykieta.setText(miesiace[dniMiesiaca.zwrocMiesiac()]);
		miesiacEtykieta.setHorizontalAlignment(JLabel.CENTER);
		miesiacEtykieta.setVerticalAlignment(JLabel.CENTER);
		//miesiacEtykieta.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(miesiacEtykieta);
		
		//wypisanie nazw dni tygodnia
		
		JLabel dniTygodnia = new JLabel();
		dniTygodnia.setBounds(300,90,264,28);
		dniTygodnia.setText(wypiszDniTygodnia(6));
		//dniTygodnia.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(dniTygodnia);
		
		
///////////////////////////////////////////////////////
		JPanel dniMiesiac = new JPanel();
		dniMiesiac.setBounds(300, 119, 264, 180);
		//dniMiesiac.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		dniMiesiac.setLayout(null);
		contentPane.add(dniMiesiac);
		
		
		
//		dzis.wypelnijTabele();
		
//		JLabel tabelamiesiac[][] = new JLabel[6][7];
		
		///////////////////////////////////////////////////////
//		ObslugaKalendarza obsluga = new ObslugaKalendarza(lewyPrzycisk, prawyPrzycisk, miesiacEtykieta, dzis, jlabel);
//		miesiacEtykieta.setText(obsluga.zwrocDate());
		
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
//				if(dzis.zwrocTabele(i, j) ==0)
//					tabelamiesiac[i][j] = createLabel(" ", new Point(50+j*(38),118+i*(22)), 37, 21);
//				else
//					tabelamiesiac[i][j] = createLabel(Integer.toString(dzis.zwrocTabele(i, j)), new Point(50+j*(38),118+i*(22)), 37, 21);
//				
//				if(ObslugaKalendarza.aktualnyRok == aktualnaData.getYear()+1900 &&
//						ObslugaKalendarza.miesiace[ObslugaKalendarza.aktualnyMiesiac] == 
//						ObslugaKalendarza.miesiace[aktualnaData.getMonth()] &&
//						(dzis.zwrocTabele(i, j) == aktualnaData.getDate()))
//					tabelamiesiac[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 1));
//				else
//					tabelamiesiac[i][j].setBorder(null);
				
				dniMiesiac.add(dniMiesiaca.zwrocEtykiete(i, j));
			}
		}
		
		
//		lewyPrzycisk.addActionListener(obsluga);
//		prawyPrzycisk.addActionListener(obsluga);
	}

	
	////////////////////////////////////////////////////////////////////////////////////
	private String wypiszDniTygodnia(int spacje) {
		String dayName = new String();
		for(int i=0; i<6; i++){
			dayName += dni[i];	
			for(int j=0; j<spacje; j++)
				dayName += " ";
		}
		dayName += dni[6];
		return dayName;
	}
	

	
}
