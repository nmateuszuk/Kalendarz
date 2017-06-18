package kontroler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.*;



public class Organizer {

	private SQLConnection sql;
	private List<Zdarzenie> listaZdarzen = new ArrayList<Zdarzenie>();
	
	private int refreshListaZdarzen() {
		int result = 0;
		this.listaZdarzen = sql.getZdarzeniaFromSQL();
		Collections.sort(listaZdarzen);
		return result;
	}

	public Organizer(SQLConnection sql) {
		this.sql = sql;
		refreshListaZdarzen();
	}
	
	
	public List<Zdarzenie> getListaZdarzen() {
		return listaZdarzen;
	}
	
	public int addNewZdarzenie(Date data, String nazwa, String opis, String miejsce) {
		int result = 0;
		result = sql.addZdarzenieToSQL(data, nazwa, opis, miejsce);
		result = refreshListaZdarzen();
		return result;
	}
	
	public int delZdarzenie(int id) {
		int result = 0;
		result = sql.delZdarzenieFromSQL(id);
		result = refreshListaZdarzen();
		return result;
	}
	
	public int editZdarzenieDate(int id, Date data) {
		int result = 0;
		result = sql.editDataFromSQL(id, data);
		result = refreshListaZdarzen();
		return result;
	}
	
	public int editZdarzenie(int id, String pole, String nowaWartosc) {
		int result = 0;
		result = sql.editZdarzenieFromSQL(id, pole, nowaWartosc);
		result = refreshListaZdarzen();
		return result;
	}
	
	public int delOlderThan(Date data) {
		int result = 0;
		for (int i=0; i<listaZdarzen.size(); i++) {
			if (listaZdarzen.get(i).getDataZdarzenia().compareTo(data) < 0)
				result = sql.delZdarzenieFromSQL(listaZdarzen.get(i).getId());
		}
		result = refreshListaZdarzen();
		return result;
	}
	
	public List<Zdarzenie> getZdarzeniaFromDay(Date data) {
		List<Zdarzenie> result = new ArrayList<Zdarzenie>();
		
		Calendar c1 = Calendar.getInstance(),c2 = Calendar.getInstance();
		c1.setTime(data);
		
		for (int i=0; i<listaZdarzen.size() ; i++) {
			
			Date dataZdarzenia = listaZdarzen.get(i).getDataZdarzenia();
			c2.setTime(dataZdarzenia);
			
			if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
				if (c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR))
					result.add(listaZdarzen.get(i));
					
		}
		return result;
	} 	
	
	
	
	public void exportToXML(String sciezka) {
		//Zapisanie tej tablicy do pliku
		File plik = new File(sciezka);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try	{
			plik.createNewFile();
			FileWriter strumienZapisu = new FileWriter(plik);
			strumienZapisu.write("<ListaZdarzen>\n");
			for (int i=0; i < listaZdarzen.size(); i++) {
				strumienZapisu.write("\t<zdarzenie>\n");
				
				strumienZapisu.write("\t\t<id>");
				strumienZapisu.write(Integer.toString(listaZdarzen.get(i).getId()));
				strumienZapisu.write("</id>\n");
				
				strumienZapisu.write("\t\t<data>");
				strumienZapisu.write(sdf.format(listaZdarzen.get(i).getDataZdarzenia()));
				strumienZapisu.write("</data>\n");
				
				strumienZapisu.write("\t\t<nazwa>");
				strumienZapisu.write(listaZdarzen.get(i).getNazwa());
				strumienZapisu.write("</nazwa>\n");
				
				strumienZapisu.write("\t\t<opis>");
				strumienZapisu.write(listaZdarzen.get(i).getOpis());
				strumienZapisu.write("</opis>\n");
				
				strumienZapisu.write("\t\t<miejsce>");
				strumienZapisu.write(listaZdarzen.get(i).getMiejsce());
				strumienZapisu.write("</miejsce>\n");
				
				strumienZapisu.write("\t</zdarzenie>\n");
			}
			strumienZapisu.write("</ListaZdarzen>");
			strumienZapisu.close();
		}
		catch (IOException io)												
			{System.out.println(io.getMessage());}
		catch (Exception se)
			{System.err.println("blad sec");}
	}
	
	public void importFromXML(String sciezka) {
		
		File plik = new File(sciezka);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		int beginIndex;
		int endIndex;
		
		try {
			Scanner in = new Scanner(plik);
			while (in.hasNextLine()) {
				
				int id = 0;
				Date data = new Date();
				String nazwa = "";
				String opis = "";
				String miejsce = "";
				
				String str = in.nextLine();
				if(str.contains("<zdarzenie>")){
					while (!str.contains("</zdarzenie>")) {
					
						//Zgarniamy id
						if (str.matches("(.*)<id>(.*)</id>(.*)")) {
							
							beginIndex = str.indexOf("<id>") + 4;
							endIndex = str.indexOf("</id>");
							String substr =	str.substring(beginIndex, endIndex);
							id = Integer.parseInt(substr);
						}
						
						//Zgarniamy date
						if (str.matches("(.*)<data>(.*)</data>(.*)")) {
							
							beginIndex = str.indexOf("<data>") + 6;
							endIndex = str.indexOf("</data>");
							String substr =	str.substring(beginIndex, endIndex);
							
							
							try {
								data = sdf.parse(substr);
							} catch (ParseException e) {
								System.out.println("Cos sie na Parse Spitolilo :(");
								e.printStackTrace();
							}
						}
						
						//Zgarniamy nazw
						if (str.matches("(.*)<nazwa>(.*)</nazwa>(.*)")) {
							
							beginIndex = str.indexOf("<nazwa>") + 7;
							endIndex = str.indexOf("</nazwa>");
							nazwa =	str.substring(beginIndex, endIndex);
						}
						
						//Zgarniamy opis
						if (str.matches("(.*)<opis>(.*)</opis>(.*)")) {
							
							beginIndex = str.indexOf("<opis>") + 6;
							endIndex = str.indexOf("</opis>");
							opis =	str.substring(beginIndex, endIndex);
						}
						
						//Zgarniamy miejsce
						if (str.matches("(.*)<miejsce>(.*)</miejsce>(.*)")) {

							beginIndex = str.indexOf("<miejsce>") + 9;
							endIndex = str.indexOf("</miejsce>");
							miejsce =	str.substring(beginIndex, endIndex);
						}
						
						str = in.nextLine();
					}
					
					//System.out.println("\nid: " + id + "\ndata: " + data + "\nnazwa: " + nazwa + "\nopis: " + opis + "\nmiejsce: " + miejsce);
					
					boolean czyIstnieje = false;
					
					for (int i=0; i<listaZdarzen.size(); i++) {
						if (listaZdarzen.get(i).getId() == id) czyIstnieje = true;
					}
					
					if (!czyIstnieje)
						sql.addZdarzenieToSQLWithId(id, data, nazwa, opis, miejsce);
				}
			}
				
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("NIE MA TAKIEGO PLIKU!");
			e.printStackTrace();
		}
		
		

	}
}
