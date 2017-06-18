package kontroler;

import java.awt.EventQueue;
import java.util.Date;

import model.DniMiesiaca;

import widok.WidokKalendarza;

public class Program {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DniMiesiaca dniMiesiaca = new DniMiesiaca(new Date());
					WidokKalendarza widokKalendarza = new WidokKalendarza(
							dniMiesiaca);
					ObslugaKalendarza kontroler = new ObslugaKalendarza(
							dniMiesiaca, widokKalendarza);
					widokKalendarza.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
