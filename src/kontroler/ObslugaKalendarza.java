package kontroler;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.DniMiesiaca;

import widok.WidokKalendarza;

public class ObslugaKalendarza implements ActionListener {
	DniMiesiaca model;
	WidokKalendarza widok;

	public ObslugaKalendarza(DniMiesiaca model, WidokKalendarza widok) {
		this.model = model;
		this.widok = widok;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == widok.getLewyPrzycisk()) {
			model.dodajMiesiac(-1);
		} else if (e.getSource() == widok.getPrawyPrzycisk()) {
			model.dodajMiesiac(1);
		} else if (e.getSource() == widok.getDzisiajPrzycisk()) {
			model.ustawDate(new Date());
		}

		widok.wypiszDniMiesiaca();
		// Date aktualnaData;
		// JButton lewyPrzycisk, prawyPrzycisk;
		// JLabel miesiacEtykieta;
		//
		// //DniMiesiaca dzis;
		//
		// JLabel[][] jlabel;
		// private Calendar calendar;
		// //public int rok, miesiac;
		//
		// int aktualnyMiesiac;
		// public int aktualnyRok;
		//
		// // static String miesiace[] = new String[]{"Styczen", "Luty",
		// "Marzec",
		// "Kwiecien", "Maj", "Czerwiec", "Lipiec", "Sierpein",
		// // "Wrzesien", "Pazdziernik", "Listopad", "Grudzien"};
		//
		//
		// DniMiesiaca model;
		// WidokKalendarza widok;
		//
		// public ObslugaKalendarza(JButton lewyPrzycisk, JButton prawyPrzycisk,
		// JLabel miesiacEtykieta/* DniMiesiaca dzis, JLabel[][] jlabel*/){
		// aktualnaData = new Date();
		// this.lewyPrzycisk = lewyPrzycisk;
		// this.prawyPrzycisk = prawyPrzycisk;
		// this.miesiacEtykieta = miesiacEtykieta;
		// //this.dzis = dzis;
		//
		// calendar = Calendar.getInstance();
		// calendar.setTime(aktualnaData);
		// aktualnyMiesiac = calendar.get(Calendar.MONTH);
		// aktualnyRok = calendar.get(Calendar.YEAR);
		// //this.jlabel = jlabel;
		// }
		//
		// public void updatemiesiaceName(){
		// miesiacEtykieta.setText(miesiace[aktualnyMiesiac]);
		// }
		//
		//
		// public String zwrocDate(){
		// return miesiace[aktualnyMiesiac] + " " +
		// Integer.toString(aktualnyRok);
		// }
		//
		// public void actionPerformed(ActionEvent e) {
		//
		// if(e.getSource()==lewyPrzycisk){
		// if(aktualnyMiesiac>0){
		// aktualnyMiesiac -= 1;
		// miesiacEtykieta.setText(zwrocDate());
		//
		// aktualnaData.setMonth(aktualnyMiesiac);
		//
		// dzis.ustawDate(aktualnaData);
		//
		// for(int i=0;i<6;i++){
		// for(int j=0;j<7;j++){
		// if(dzis.zwrocTabele(i,j)==0)
		// jlabel[i][j].setText(" ");
		// else
		// jlabel[i][j].setText(Integer.toString(dzis.zwrocTabele(i, j)));
		//
		// if(ObslugaKalendarza.aktualnyRok == aktualnaData.getYear()+1900 &&
		// ObslugaKalendarza.miesiace[ObslugaKalendarza.aktualnyMiesiac] ==
		// ObslugaKalendarza.miesiace[aktualnaData.getMonth()] &&
		// (dzis.zwrocTabele(i, j) == aktualnaData.getDate()))
		// jlabel[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		// else
		// jlabel[i][j].setBorder(null);
		//
		// }
		// }
		// }
		// else{
		// aktualnyMiesiac = 11;
		// miesiacEtykieta.setText(miesiace[aktualnyMiesiac] + " " +
		// Integer.toString(--aktualnyRok));
		// // dzis.zmienDate(aktualnyRok, aktualnyMiesiac);
		// // dzis.wypelnijTabele();
		// for(int i=0;i<6;i++){
		// for(int j=0;j<7;j++){
		// if(dzis.zwrocTabele(i,j)==0)
		// jlabel[i][j].setText(" ");
		// else
		// jlabel[i][j].setText(Integer.toString(dzis.zwrocTabele(i, j)));
		//
		// if(ObslugaKalendarza.aktualnyRok == aktualnaData.getYear()+1900 &&
		// ObslugaKalendarza.miesiace[ObslugaKalendarza.aktualnyMiesiac] ==
		// ObslugaKalendarza.miesiace[aktualnaData.getMonth()] &&
		// (dzis.zwrocTabele(i, j) == aktualnaData.getDate()))
		// jlabel[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		// else
		// jlabel[i][j].setBorder(null);
		// }
		// }
		// }
		// }
		//
		// if(e.getSource()==prawyPrzycisk){
		// if(aktualnyMiesiac<11){
		// aktualnyMiesiac += 1;
		// miesiacEtykieta.setText(miesiace[aktualnyMiesiac] + " " +
		// Integer.toString(aktualnyRok));
		// // dzis.zmienDate(aktualnyRok, aktualnyMiesiac);
		// // dzis.wypelnijTabele();
		// for(int i=0;i<6;i++){
		// for(int j=0;j<7;j++){
		// if(dzis.zwrocTabele(i,j)==0)
		// jlabel[i][j].setText(" ");
		// else
		// jlabel[i][j].setText(Integer.toString(dzis.zwrocTabele(i, j)));
		//
		// if(ObslugaKalendarza.aktualnyRok == aktualnaData.getYear()+1900 &&
		// ObslugaKalendarza.miesiace[ObslugaKalendarza.aktualnyMiesiac] ==
		// ObslugaKalendarza.miesiace[aktualnaData.getMonth()] &&
		// (dzis.zwrocTabele(i, j) == aktualnaData.getDate()))
		// jlabel[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		// else
		// jlabel[i][j].setBorder(null);
		// }
		// }
		// }
		// else{
		// aktualnyMiesiac = 0;
		// miesiacEtykieta.setText(miesiace[aktualnyMiesiac] + " " +
		// Integer.toString(++aktualnyRok));
		// // dzis.zmienDate(aktualnyRok, aktualnyMiesiac);
		// // dzis.wypelnijTabele();
		// for(int i=0;i<6;i++){
		// for(int j=0;j<7;j++){
		// if(dzis.zwrocTabele(i,j)==0)
		// jlabel[i][j].setText(" ");
		// else
		// jlabel[i][j].setText(Integer.toString(dzis.zwrocTabele(i, j)));
		//
		// if(ObslugaKalendarza.aktualnyRok == aktualnaData.getYear()+1900 &&
		// ObslugaKalendarza.miesiace[ObslugaKalendarza.aktualnyMiesiac] ==
		// ObslugaKalendarza.miesiace[aktualnaData.getMonth()] &&
		// (dzis.zwrocTabele(i, j) == aktualnaData.getDate()))
		// jlabel[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		// else
		// jlabel[i][j].setBorder(null);
		// }
		// }
		// }
		// }
		// }
	}
}