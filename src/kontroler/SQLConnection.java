package kontroler;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Zdarzenie;


public class SQLConnection {
	
	private Connection connection = null;
	private Statement stmt;

	public SQLConnection(String server, String database, String user, String password) {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://sql.ggeasy.nazwa.pl:3306/ggeasy_2","ggeasy_2", "Haslo123");
			stmt = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}
	
	public int addZdarzenieToSQL(Zdarzenie zdarzenie) {
		int rs = 99;
		Date data = zdarzenie.getDataZdarzenia();
		String nazwa = zdarzenie.getNazwa();
		String opis = zdarzenie.getOpis();
		String miejsce = zdarzenie.getMiejsce();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringDate = sdf.format(data);
		
		try {
			rs = stmt.executeUpdate
					("INSERT INTO zdarzenia VALUES('" +
							stringDate +
							"', '" +
							nazwa + 
							"', '" +
							opis +
							"', '" +
							miejsce +
							"');");
		
		} catch (SQLException e) {
			System.out.println("addZdarzenieToSQL Failed! Check output console");
			e.printStackTrace();
		}
		return rs;
	}
	
	public List<Zdarzenie> getZdarzeniaFromSQL() {
		List<Zdarzenie> result = new ArrayList<Zdarzenie>();
		
	    ResultSet rs;
		try {
			rs = stmt.executeQuery("SELECT data, nazwa, opis, miejsce FROM zdarzenia");
			
		    while (rs.next()) {
		        Date data = rs.getDate("data");
		        String nazwa = rs.getString("nazwa");
		        String opis = rs.getString("opis");
		        String miejsce = rs.getString("miejsce");
		        
		        result.add(new Zdarzenie(data,nazwa,opis,miejsce));
		    }
		    
		} catch (SQLException e) {
			System.out.println("getZdarzeniaFromSQL Failed! Check output console");
			e.printStackTrace();
		}

		return result;
	}
		

}
