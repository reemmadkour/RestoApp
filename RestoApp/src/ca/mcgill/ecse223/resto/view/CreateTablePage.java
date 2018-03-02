package ca.mcgill.ecse223.resto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.resto.controller.InvalidInputException;
import ca.mcgill.ecse223.resto.controller.RestoAppController;

import java.awt.Label;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CreateTablePage extends JFrame {

	private JPanel contentPane;
	private Label nbSeatsLabel;
	private JButton btnAddTable;
	private String error = null;
	private JLabel errorMessage;
	private Label lengthLabel;
	private Label xLabel;
	private TextField xField;
	private TextField lengthField;
	private TextField nbSeatsField;
	private Label nbLabel;
	private Label widthLabel;
	private Label yLabel;
	private TextField yField;
	private TextField widthField;
	private TextField nbField;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CreateTablePage() {
		initComponents();
		refreshData();
	}
	
	public void initComponents() {
		errorMessage = new JLabel(error);
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(10, 200, 350, 29);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add Table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nbSeatsLabel = new Label("Number of Seats");
		nbSeatsLabel.setBounds(10, 10, 130, 16);
		contentPane.add(nbSeatsLabel);
		
		lengthLabel = new Label("Table Length");
		lengthLabel.setBounds(10, 70, 130, 16);
		contentPane.add(lengthLabel);
		
		xLabel = new Label("Table x position");
		xLabel.setBounds(10, 130, 130, 16);
		contentPane.add(xLabel);
		
		xField = new TextField();
		xField.setBounds(150, 130, 31, 22);
		contentPane.add(xField);
		
		lengthField = new TextField();
		lengthField.setBounds(150, 70, 31, 22);
		contentPane.add(lengthField);
		
		nbSeatsField = new TextField();
		nbSeatsField.setBounds(150, 10, 31, 22);
		contentPane.add(nbSeatsField);
		
		nbLabel = new Label("Table Number");
		nbLabel.setBounds(209, 10, 130, 16);
		contentPane.add(nbLabel);
		
		widthLabel = new Label("Table Width");
		widthLabel.setBounds(209, 70, 130, 16);
		contentPane.add(widthLabel);
		
		yLabel = new Label("Table y position");
		yLabel.setBounds(209, 130, 130, 16);
		contentPane.add(yLabel);
		
		yField = new TextField();
		yField.setBounds(398, 130, 31, 22);
		contentPane.add(yField);
		
		widthField = new TextField();
		widthField.setBounds(398, 70, 31, 22);
		contentPane.add(widthField);
		
		nbField = new TextField();
		nbField.setBounds(398, 10, 31, 22);
		contentPane.add(nbField);
		
		btnAddTable = new JButton("Add Table");
		btnAddTable.setBounds(312, 243, 117, 29);
		contentPane.add(btnAddTable);
		btnAddTable.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCreateTableActionPerformed(evt);
			}

		});
	}
	
	private void refreshData() {// error
		errorMessage.setText(error);
		if (error == null || error.length() == 0) {
			// populate page with data
			xField.setText("");
			yField.setText("");
			nbField.setText("");
			nbSeatsField.setText("");
			widthField.setText("");
			lengthField.setText("");
		}


		// this is needed because the size of the window changes depending on whether an error message is shown or not
		//pack();
	}
	private void btnCreateTableActionPerformed(java.awt.event.ActionEvent evt) {

		//clear error message
		error = null;
		// call the controller

		try {

			int tableNumber = Integer.parseInt(nbField.getText());
			int x = Integer.parseInt(xField.getText());
			int y = Integer.parseInt(yField.getText());
			int length = Integer.parseInt(lengthField.getText());
			int width = Integer.parseInt(widthField.getText());
			int nbSeats = Integer.parseInt(nbSeatsField.getText());
			
			RestoAppController.createTable(tableNumber, x, y, width, length, nbSeats);

		}
		catch (InvalidInputException e) {
			error = e.getMessage();
			contentPane.add(errorMessage);
		}
		catch (NumberFormatException e) {
			error = "One or more input is either empty or is not a number";
			contentPane.add(errorMessage);
		}

		// update visuals
		refreshData();
	}
}
