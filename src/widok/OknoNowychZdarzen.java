package widok;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.SwingConstants;
import java.awt.TextField;
import javax.swing.SpringLayout;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JButton;

import kontroler.ObslugaZdarzen;
import kontroler.Organizer;

public class OknoNowychZdarzen extends JFrame {
	
	Organizer org;

	private JPanel contentPane;
	private TextField nazwaText;
	private TextField opisText;
	private TextField miejsceText;
	private JButton dodajZdarzenie;

	
	public OknoNowychZdarzen() {
		setTitle("Nowe zdarzenie");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		//http://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Dzisiaj");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		datePicker.getJFormattedTextField().setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.getJFormattedTextField().setText("wybierz date");
		contentPane.add(datePicker);
		
		nazwaText = new TextField();
		springLayout.putConstraint(SpringLayout.NORTH, nazwaText, 55, SpringLayout.SOUTH, datePicker.getJFormattedTextField());
		springLayout.putConstraint(SpringLayout.WEST, nazwaText, 10, SpringLayout.WEST, datePicker);
		springLayout.putConstraint(SpringLayout.EAST, nazwaText, 368, SpringLayout.WEST, datePicker);
		datePicker.add(nazwaText);
		
		//date picker czy content pane
		
		JLabel lblZdarzenie = new JLabel("Zdarzenie");
		springLayout.putConstraint(SpringLayout.NORTH, lblZdarzenie, 31, SpringLayout.SOUTH, datePicker.getJFormattedTextField());
		springLayout.putConstraint(SpringLayout.WEST, lblZdarzenie, 30, SpringLayout.WEST, datePicker);
		springLayout.putConstraint(SpringLayout.SOUTH, lblZdarzenie, -10, SpringLayout.NORTH, nazwaText);
		springLayout.putConstraint(SpringLayout.EAST, lblZdarzenie, -24, SpringLayout.EAST, datePicker);
		lblZdarzenie.setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.add(lblZdarzenie);
		
		JLabel lblMiejsce = new JLabel("Miejsce");
		springLayout.putConstraint(SpringLayout.NORTH, lblMiejsce, 17, SpringLayout.SOUTH, nazwaText);
		springLayout.putConstraint(SpringLayout.WEST, lblMiejsce, 0, SpringLayout.WEST, lblZdarzenie);
		springLayout.putConstraint(SpringLayout.EAST, lblMiejsce, 0, SpringLayout.EAST, datePicker.getJFormattedTextField());
		lblMiejsce.setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.add(lblMiejsce);
		
		miejsceText = new TextField();
		springLayout.putConstraint(SpringLayout.NORTH, miejsceText, 6, SpringLayout.SOUTH, lblMiejsce);
		springLayout.putConstraint(SpringLayout.WEST, miejsceText, 0, SpringLayout.WEST, nazwaText);
		springLayout.putConstraint(SpringLayout.EAST, miejsceText, -10, SpringLayout.EAST, datePicker);
		datePicker.add(miejsceText);
		
		JLabel lblOpis = new JLabel("Opis");
		springLayout.putConstraint(SpringLayout.NORTH, lblOpis, 20, SpringLayout.SOUTH, miejsceText);
		springLayout.putConstraint(SpringLayout.WEST, lblOpis, 0, SpringLayout.WEST, lblZdarzenie);
		springLayout.putConstraint(SpringLayout.EAST, lblOpis, 0, SpringLayout.EAST, datePicker.getJFormattedTextField());
		lblOpis.setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.add(lblOpis);
		
		opisText = new TextField();
		springLayout.putConstraint(SpringLayout.NORTH, opisText, 6, SpringLayout.SOUTH, lblOpis);
		springLayout.putConstraint(SpringLayout.WEST, opisText, 0, SpringLayout.WEST, nazwaText);
		springLayout.putConstraint(SpringLayout.EAST, opisText, 0, SpringLayout.EAST, nazwaText);
		datePicker.add(opisText);
		
		Date date = new Date();
		SpinnerDateModel sm = 
				new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		JSpinner spinner = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		spinner.setEditor(de);
		
		springLayout.putConstraint(SpringLayout.WEST, spinner, -105, SpringLayout.EAST, datePicker.getJFormattedTextField());
		springLayout.putConstraint(SpringLayout.SOUTH, spinner, -5, SpringLayout.NORTH, lblZdarzenie);
		springLayout.putConstraint(SpringLayout.EAST, spinner, -25, SpringLayout.EAST, datePicker);
		datePicker.add(spinner);
		
		
		dodajZdarzenie = new JButton("Dodaj zdarzenie");
		springLayout.putConstraint(SpringLayout.NORTH, dodajZdarzenie, 18, SpringLayout.SOUTH, opisText);
		springLayout.putConstraint(SpringLayout.EAST, dodajZdarzenie, -140, SpringLayout.EAST, datePicker);
		datePicker.add(dodajZdarzenie);
		
		ObslugaZdarzen obsluga = new ObslugaZdarzen(this, org);
		dodajZdarzenie.addActionListener(obsluga);	
	}
	
	public TextField getNazwaText() {
		return nazwaText;
	}

	public TextField getOpisText() {
		return opisText;
	}

	public TextField getMiejsceText() {
		return miejsceText;
	}

	public JButton getDodajZdarzenie() {
		return dodajZdarzenie;
	}
}
