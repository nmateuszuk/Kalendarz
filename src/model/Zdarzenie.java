package model;

import java.util.Date;

public class Zdarzenie implements Comparable<Zdarzenie>{
	
	
	private Date dataZdarzenia;
	private String nazwa;
	private String opis;
	private String miejsce;
	
	public Zdarzenie(Date dataZdarzenia, String nazwa) {
		super();
		this.dataZdarzenia = dataZdarzenia;
		this.nazwa = nazwa;
		this.opis = "";
		this.miejsce = "";
	}
	
	public Zdarzenie(Date dataZdarzenia, String nazwa, String opis) {
		this(dataZdarzenia,nazwa);
		this.opis = opis;
	}
	
	public Zdarzenie(Date dataZdarzenia, String nazwa, String opis, String miejsce) {
		this(dataZdarzenia,nazwa,opis);
		this.miejsce = miejsce;
	}
	
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
		return "Zdarzenie [dataZdarzenia=" + dataZdarzenia + ", nazwa=" + nazwa
				+ ", opis=" + opis + ", miejsce=" + miejsce + "]";
	}
	
}
