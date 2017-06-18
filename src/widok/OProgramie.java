package widok;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class OProgramie {
	private JFrame okno;
	
	JLabel informacja, autorzy;
	
	public OProgramie(){
		okno = new JFrame("Info");
		okno.setBounds(20, 20, 210, 150);
		okno.setLayout(null);
		
		Font standard = new Font("Arial", Font.PLAIN, 13);
		
		informacja = new JLabel("Program typu organizator");
		informacja.setBounds(5, 5, 190, 15);
		informacja.setFont(new Font("Arial", Font.BOLD, 13));
		okno.add(informacja);

		autorzy = new JLabel("Autorzy: /n Natalia Mateuszuk /n Adrian Grzelak");
		autorzy.setBounds(5, 30, 190, 20);
		autorzy.setFont(standard);
		okno.add(autorzy);
	}
}