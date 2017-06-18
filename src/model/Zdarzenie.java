package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Zdarzenie implements Comparable<Zdarzenie>{
	
	private int id;
	private Date dataZdarzenia;
	private String nazwa;
	private String opis;
	private String miejsce;
	
	public Zdarzenie(int id, Date dataZdarzenia, String nazwa) {
		super();
		this.id = id;
		this.dataZdarzenia = dataZdarzenia;
		this.nazwa = nazwa;
		this.opis = "";
		this.miejsce = "";
	}
	
	public Zdarzenie(int id,Date dataZdarzenia, String nazwa, String opis) {
		this(id,dataZdarzenia,nazwa);
		this.opis = opis;
	}
	
	public Zdarzenie(int id,Date dataZdarzenia, String nazwa, String opis, String miejsce) {
		this(id,dataZdarzenia,nazwa,opis);
		this.miejsce = miejsce;
	}
	
	public int getId() {
		return id;
	}

	//public void setId(int id) {
	//	this.id = id;
	//}

	public Date getDataZdarzenia() {
		return dataZdarzenia;
	}
	public void setDataZdarzenia(Date dataZdarzenia) {
		this.dataZdarzenia = dataZdarzenia;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getMiejsce() {
		return miejsce;
	}
	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}

	public int compareTo(Zdarzenie o) {
		return this.dataZdarzenia.compareTo(o.getDataZdarzenia());
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringDate = sdf.format(dataZdarzenia);
		
		return "Zdarzenie [id=" + id + ", dataZdarzenia=" + stringDate
				+ ", nazwa=" + nazwa + ", opis=" + opis + ", miejsce="
				+ miejsce + "]";
	}

	
}
