package kontroler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.w3c.dom.events.MouseEvent;

import widok.OknoFiltrowania;
import widok.OknoNowychZdarzen;

public class ObslugaZdarzen implements ActionListener {
	
	public ObslugaZdarzen() {
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void wywolajOknoZdarzen() {
					OknoNowychZdarzen frame = new OknoNowychZdarzen();
					frame.setVisible(true);
			}
	
	public void wywolajOknoFiltrowania() {
		OknoFiltrowania frame = new OknoFiltrowania();
		frame.setVisible(true);
	}
	
//	public void wywolajOknoUsuwania() {
//		OknoUsuwania frame = new OknoUsuwania();
//		frame.setVisible(true);
//	}
	
	
}
