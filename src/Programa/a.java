package Programa;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class a extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public a() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar HH");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 64, 580, 112);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(167, 419, 67, 42);
		add(textField);
		textField.setColumns(10);
		
		JButton btn = new JButton("Registrar");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setBounds(244, 419, 190, 42);
		add(btn);
		
		JComboBox cbt = new JComboBox();
		cbt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbt.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Trabajador"}));
		cbt.setMaximumRowCount(99);
		cbt.setBounds(167, 233, 267, 42);
		add(cbt);
		
		JComboBox cbp = new JComboBox();
		cbp.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Proyecto"}));
		cbp.setMaximumRowCount(99);
		cbp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbp.setBounds(167, 305, 267, 42);
		add(cbp);
		
		JLabel lbl = new JLabel("Ingresar Numero de Horas");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(167, 378, 267, 30);
		add(lbl);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(167, 507, 165, 22);
		add(textArea);

	}
}
