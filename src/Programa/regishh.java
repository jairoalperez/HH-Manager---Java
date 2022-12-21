package Programa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;

import javax.swing.table.DefaultTableModel;



import java.sql.Statement;

import java.sql.Connection; 
import 	java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import 	java.sql.SQLException;

import javax.swing.*;

public class regishh {

	JPanel panel;
	JTextField textField;
	JComboBox cbt;
	JComboBox cbp;
	
	
	
			public void fillcbp() {
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
			
			public void fillcbt() {
				try {
					String sql = "select * from trabajador";
				DB.pstmt = DB.conn.prepareStatement(sql);
				DB.rs = DB.pstmt.executeQuery();
				while(DB.rs.next()) {
					cbt.addItem(DB.rs.getString("trabajador"));
				}
				} catch (SQLException e) {
				e.printStackTrace();
				}
				}
	
	
	public regishh() {
		
		
		
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
		
		JLabel lblNewLabel = new JLabel("Registrar HH");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 64, 580, 112);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(167, 419, 67, 42);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btn = new JButton("Registrar");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setBounds(244, 419, 190, 42);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				
				String p = cbp.getSelectedItem().toString();
				String t = cbt.getSelectedItem().toString();
				
				String hh = textField.getText().toString();
				float valor = Float.valueOf(hh);
				
				String ha = null;
				
				if (p == "Seleccionar Proyecto" || t == "Seleccionar Trabajador") {
					JOptionPane.showMessageDialog(view.vista, "Por favor seleccione un Proyecto y un Trabajador");
				}else {
					
					//select el valor anterior de hh
					try {
						String sql = "select hh from hhproyecto where proyecto = '"+p+"'";
			        	DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
			            
			               while (DB.rs.next()) {
			            	   
			            	   ha = DB.rs.getString("hh");
			            	   
			               }
			               
			            
			        } catch (SQLException ex) {
			        	System.out.print(ex);
			        }

					
					//update valor de hh
					try {
						float valora = Float.valueOf(ha);
						
						float valorn = valora+valor;
						String sql1 = "update hhproyecto set hh = '"+valorn+"' where proyecto = '"+p+"'";
						String sql2 = "insert into hhtrabajador values ('"+p+"','"+t+"','"+valor+"')";
						
						
						DB.stmt = DB.conn.createStatement();
							DB.stmt.executeUpdate(sql1);
							DB.stmt.executeUpdate(sql2);
							
					} catch (SQLException e) {
		            	 System.out.print(e);
		            }
					
					JOptionPane.showMessageDialog(view.vista, "Registro Satisfactorio");
				}
				
			}
		});
		panel.add(btn);
		
		cbt = new JComboBox();
		cbt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbt.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Trabajador"}));
		cbt.setMaximumRowCount(99);
		cbt.setBounds(167, 233, 267, 42);
		panel.add(cbt);
		fillcbt();
		
		cbp = new JComboBox();
		cbp.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Proyecto"}));
		cbp.setMaximumRowCount(99);
		cbp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbp.setBounds(167, 305, 267, 42);
		panel.add(cbp);
		fillcbp();
		
		JLabel lbl = new JLabel("Ingresar Numero de Horas");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(167, 378, 267, 30);
		panel.add(lbl);
	
	}
	
	public JPanel getrhh() {
		return this.panel;
	}
	
}