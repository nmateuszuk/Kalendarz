package kontroler;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.*;


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
			String connectionString = "jdbc:mysql://" + server + "/" + database;
			this.connection = DriverManager.getConnection(connectionString,user,password);
			stmt = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	public int addZdarzenieToSQL(Date data, String nazwa, String opis, String miejsce) {
		int rs = 99;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringDate = sdf.format(data);
		
		//INSERT INTO zdarzenia(data, nazwa, opis, miejsce) VALUES ('2017-06-22 20:00:00','Czwartek','Czwarteczek','Czwartunio')
		try {
			rs = stmt.executeUpdate
					("INSERT INTO zdarzenia(data, nazwa, opis, miejsce) VALUES('" +
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
	
	protected int addZdarzenieToSQLWithId(int id,Date data, String nazwa, String opis, String miejsce) {
		int rs = 99;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringDate = sdf.format(data);
		
		//INSERT INTO zdarzenia(data, nazwa, opis, miejsce) VALUES ('2017-06-22 20:00:00','Czwartek','Czwarteczek','Czwartunio')
		try {
			rs = stmt.executeUpdate
					("INSERT INTO zdarzenia VALUES(" + 
							id + 
							",'" +
							stringDate +
							"', '" +
							nazwa + 
							"', '" +
							opis +
							"', '" +
							miejsce +
							"');");
		
		} catch (SQLException e) {
			System.out.println("addZdarzenieToSQLWithID Failed! Check output console");
			e.printStackTrace();
		}
		return rs;
	}
	
	public int delZdarzenieFromSQL(int id) {
		int rs = 0;
		
		try {
			rs = stmt.executeUpdate("DELETE FROM zdarzenia WHERE id=" + id);		
		} catch (SQLException e) {
			System.out.println("addZdarzenieToSQL Failed! Check output console");
			e.printStackTrace();
		}
		return rs;
	}
	
	public int editDataFromSQL(int id, Date data) {
		int rs = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringDate = sdf.format(data);

		try {
			rs = stmt.executeUpdate("UPDATE zdarzenia SET data='" + stringDate + "' WHERE id =" + id);		
		} catch (SQLException e) {
			System.out.println("addZdarzenieToSQL Failed! Check output console");
			e.printStackTrace();
		}
		return rs;
	}
	
	public int editZdarzenieFromSQL(int id, String pole, String nowaWartosc) {
		int rs = 0;
		
		try {
			rs = stmt.executeUpdate("UPDATE zdarzenia SET " + pole + "='" + nowaWartosc + "' WHERE id =" + id);		
		} catch (SQLException e) {
			System.out.println("addZdarzenieToSQL Failed! Check output console");
			e.printStackTrace();
		}
		return rs;
	}
	
	public List<Zdarzenie> getZdarzeniaFromSQL() {
		List<Zdarzenie> result = new ArrayList<Zdarzenie>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    ResultSet rs;
	    
		try {
			rs = stmt.executeQuery("SELECT id, data, nazwa, opis, miejsce FROM zdarzenia");
			
		    while (rs.next()) {
		    	
		    	int id = rs.getInt("id");
		    	
		    	Date data = new Date();
		        String tempString = rs.getString("data");
				try {
					data = sdf.parse(tempString);
				} catch (ParseException e) {
					System.out.println("Cos sie na Parse Spitolilo :(");
					e.printStackTrace();
				}
		        
		        String nazwa = rs.getString("nazwa");
		        String opis = rs.getString("opis");
		        String miejsce = rs.getString("miejsce");
		        
		        result.add(new Zdarzenie(id,data,nazwa,opis,miejsce));
		    }
		    
		} catch (SQLException e) {
			System.out.println("getZdarzeniaFromSQL Failed! Check output console");
			e.printStackTrace();
		}

		return result;
	}
		

}
