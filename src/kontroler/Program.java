package kontroler;

import java.awt.EventQueue;
import java.util.Date;

import model.DniMiesiaca;

import widok.WidokKalendarza;
import java.sql.*;

public class Program {
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SQLConnection sql= new SQLConnection("sql.ggeasy.nazwa.pl:3306", "ggeasy_2", "ggeasy_2", "Haslo123");
					Organizer org = new Organizer(sql);
					
					DniMiesiaca dniMiesiaca = new DniMiesiaca(new Date());
					WidokKalendarza widokKalendarza = new WidokKalendarza(org,dniMiesiaca);
					ObslugaKalendarza kontroler = new ObslugaKalendarza(dniMiesiaca, widokKalendarza,org);
					widokKalendarza.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
}
