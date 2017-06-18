package widok;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoFiltrowania extends JFrame {

	private JPanel contentPane;
	
	public OknoFiltrowania() {
		setTitle("Znajdz zdarzenie");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 355);
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
		
		TextField zdarzenieText = new TextField();
		springLayout.putConstraint(SpringLayout.NORTH, zdarzenieText, 55, SpringLayout.SOUTH, datePicker.getJFormattedTextField());
		springLayout.putConstraint(SpringLayout.WEST, zdarzenieText, 10, SpringLayout.WEST, datePicker);
		springLayout.putConstraint(SpringLayout.EAST, zdarzenieText, 368, SpringLayout.WEST, datePicker);
		datePicker.add(zdarzenieText);
		
		//date picker czy content pane
		
		JLabel lblZdarzenie = new JLabel("Zdarzenie");
		springLayout.putConstraint(SpringLayout.NORTH, lblZdarzenie, 31, SpringLayout.SOUTH, datePicker.getJFormattedTextField());
		springLayout.putConstraint(SpringLayout.WEST, lblZdarzenie, 30, SpringLayout.WEST, datePicker);
		springLayout.putConstraint(SpringLayout.SOUTH, lblZdarzenie, -10, SpringLayout.NORTH, zdarzenieText);
		springLayout.putConstraint(SpringLayout.EAST, lblZdarzenie, -24, SpringLayout.EAST, datePicker);
		lblZdarzenie.setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.add(lblZdarzenie);
		
		JLabel lblMiejsce = new JLabel("Miejsce");
		springLayout.putConstraint(SpringLayout.NORTH, lblMiejsce, 17, SpringLayout.SOUTH, zdarzenieText);
		springLayout.putConstraint(SpringLayout.WEST, lblMiejsce, 0, SpringLayout.WEST, lblZdarzenie);
		springLayout.putConstraint(SpringLayout.EAST, lblMiejsce, 0, SpringLayout.EAST, datePicker.getJFormattedTextField());
		lblMiejsce.setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.add(lblMiejsce);
		
		TextField miejsceText = new TextField();
		springLayout.putConstraint(SpringLayout.NORTH, miejsceText, 6, SpringLayout.SOUTH, lblMiejsce);
		springLayout.putConstraint(SpringLayout.WEST, miejsceText, 0, SpringLayout.WEST, zdarzenieText);
		springLayout.putConstraint(SpringLayout.EAST, miejsceText, -10, SpringLayout.EAST, datePicker);
		datePicker.add(miejsceText);
		
		JLabel lblOpis = new JLabel("Opis");
		springLayout.putConstraint(SpringLayout.NORTH, lblOpis, 20, SpringLayout.SOUTH, miejsceText);
		springLayout.putConstraint(SpringLayout.WEST, lblOpis, 0, SpringLayout.WEST, lblZdarzenie);
		springLayout.putConstraint(SpringLayout.EAST, lblOpis, 0, SpringLayout.EAST, datePicker.getJFormattedTextField());
		lblOpis.setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.add(lblOpis);
		
		TextField opisTect = new TextField();
		springLayout.putConstraint(SpringLayout.NORTH, opisTect, 6, SpringLayout.SOUTH, lblOpis);
		springLayout.putConstraint(SpringLayout.WEST, opisTect, 0, SpringLayout.WEST, zdarzenieText);
		springLayout.putConstraint(SpringLayout.EAST, opisTect, 0, SpringLayout.EAST, zdarzenieText);
		datePicker.add(opisTect);
		
		JButton btnNewButton = new JButton("Szukaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 29, SpringLayout.SOUTH, opisTect);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 131, SpringLayout.WEST, datePicker);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 62, SpringLayout.SOUTH, opisTect);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 262, SpringLayout.WEST, datePicker);
		datePicker.add(btnNewButton);
	}
}
