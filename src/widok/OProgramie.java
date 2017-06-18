package widok;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;
import javax.swing.SwingConstants;

public class OProgramie extends JFrame {

	private JPanel contentPane;
	
	JLabel informacja, autorzy;

	public OProgramie() {
		setTitle("O programie");
		setBounds(100, 100, 404, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Font standard = new Font("Arial", Font.PLAIN, 13);

		informacja = new JLabel("Program typu organizator");
		informacja.setBounds(5, 5, 190, 15);
		informacja.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(informacja);

		autorzy = new JLabel(
				"<html>Autorzy: <br>  \r\nNatalia Mateuszuk " +
				"<br>Adrian Grzelak</html>");
		autorzy.setHorizontalAlignment(SwingConstants.CENTER);
		autorzy.setBounds(15, 11, 313, 69);
		autorzy.setFont(standard);
		contentPane.add(autorzy);
	}

	public void wywolajOknoProgram() {
		OProgramie frame = new OProgramie();
		frame.setVisible(true);
	}
}