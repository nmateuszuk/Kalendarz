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
					DniMiesiaca dniMiesiaca = new DniMiesiaca(new Date());
					WidokKalendarza widokKalendarza = new WidokKalendarza(
							dniMiesiaca);
					ObslugaKalendarza kontroler = new ObslugaKalendarza(
							dniMiesiaca, widokKalendarza);
					widokKalendarza.setVisible(true);

					System.out
							.println("-------- MySQL JDBC Connection Testing ------------");

					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						System.out.println("Where is your MySQL JDBC Driver?");
						e.printStackTrace();
						return;
					}

					System.out.println("MySQL JDBC Driver Registered!");
					Connection connection = null;

					try {
						connection = DriverManager
								.getConnection(
										"jdbc:mysql://sql.ggeasy.nazwa.pl:3306/ggeasy_2",
										"ggeasy_2", "Haslo123");

					} catch (SQLException e) {
						System.out
								.println("Connection Failed! Check output console");
						e.printStackTrace();
						return;
					}

					if (connection != null) {
						System.out
								.println("You made it, take control your database now!");
					} else {
						System.out.println("Failed to make connection!");
					}

					// Statement stmt = connection.createStatement();

					// int rs =
					// stmt.executeUpdate("CREATE TABLE zdarzenia (data DATETIME, nazwa varchar(40), opis varchar(2048), miejsce varchar(40));");
					// int rs =
					// stmt.executeUpdate("INSERT INTO zdarzenia VALUES('2017-06-19 08:30:00', 'Odpowiedz z projektu', 'Bedziemy odpowiadac z projektu', 'Politechnika');");
					// int rs =
					// stmt.executeUpdate("INSERT INTO zdarzenia VALUES('2017-06-20 12:00:00', 'Odpowiedz z projektu', 'Bedziemy odpowiadac z projektu o Sieciach', 'Politechnika');");;
					// int rs =
					// stmt.executeUpdate("INSERT INTO zdarzenia VALUES('2017-06-21 12:00:00', 'Sroda', 'To bedzie poprostu sroda', 'Politechnika');");

					// while (rs.next()) {
					// int x = rs.getInt("a");
					// String s = rs.getString("b");
					// float f = rs.getFloat("c");
					// }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
}
