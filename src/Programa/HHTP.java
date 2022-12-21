package Programa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class HHTP {

	JPanel panel;
	JLabel lblNewLabel;
	JLabel lblProyecto;
	JLabel lblth;
	JLabel lblt;
	JButton btn;
	JComboBox cbp;
	JTextArea textArea;
	JTable table;
	
	public void fillcombobox() {
		try {
			
			String sql = "select * from hhproyecto";
		DB.pstmt = DB.conn.prepareStatement(sql);
		DB.rs = DB.pstmt.executeQuery();
		while(DB.rs.next()) {
			cbp.addItem(DB.rs.getString("proyecto"));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
	
	
	public HHTP() {
		
		
		
		panel = new JPanel();
		this.panel.setSize(600, 650);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
		JButton btnregresar = new JButton("Volver");
		btnregresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnregresar.setBackground(Color.LIGHT_GRAY);
		btnregresar.setBounds(1, 1, 97, 25);
		btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	home h = new home();
	        	view.vista.setContentPane(h.gethome());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		panel.add(btnregresar);
		
		lblNewLabel = new JLabel("HH Trabajadas por Proyecto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 59, 580, 112);
		panel.add(lblNewLabel);
		
		cbp = new JComboBox();
		cbp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbp.setModel(new DefaultComboBoxModel(new String[] {}));
		cbp.setBounds(95, 236, 300, 35);
		cbp.setMaximumRowCount(99);
		panel.add(cbp);
		fillcombobox();
		
		lblProyecto = new JLabel("SELECCIONAR PROYECTO");
		lblProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProyecto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProyecto.setBounds(144, 206, 300, 25);
		panel.add(lblProyecto);
		
		lblth = new JLabel("Total de Horas Trabajadas");
		lblth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblth.setHorizontalAlignment(SwingConstants.CENTER);
		lblth.setBounds(144, 325, 300, 44);
		panel.add(lblth);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		textArea.setBounds(169, 368, 250, 70);
		textArea.setEditable(false);
		panel.add(textArea);
		
		btn = new JButton("Buscar");
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn.setBounds(405, 236, 99, 38);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				
				String p = cbp.getSelectedItem().toString();
				String hh = null;
				
				try {
					String sql = "select hh from hhproyecto where proyecto = '"+p+"'";
		        	DB.pstmt = DB.conn.prepareStatement(sql);
					DB.rs = DB.pstmt.executeQuery();
		            
		               while (DB.rs.next()) {
		            	   
		            	   hh = DB.rs.getString("hh");
		            	   textArea.setText(hh);
		               }
						
				} catch (SQLException e) {
	            	 System.out.print(e);
	            }	
				
			}
		});
		
		panel.add(btn);
	
	}
	
	public JPanel gethhtp() {
		return this.panel;
	}
}

