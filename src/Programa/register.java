package Programa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class register {

	JPanel panel;
	JTextField textFieldcedula;
	JTextField textFieldnombre;
	JTextField textFieldcargo;
	JButton btn;
	JLabel lblNewLabel;
	JLabel lblcedula;
	JLabel lblnombre;
	JLabel lblCargo;
	
	public register() {
		
		panel = new JPanel();
		this.panel.setSize(600, 650);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
		JButton btnregresar = new JButton("Regresar");
		btnregresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnregresar.setBackground(Color.LIGHT_GRAY);
		btnregresar.setBounds(1, 1, 97, 25);
		btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	hub h = new hub();
	        	view.vista.setContentPane(h.geth());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		panel.add(btnregresar);
		
		textFieldnombre = new JTextField();
		textFieldnombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldnombre.setBounds(200, 256, 200, 30);
		panel.add(textFieldnombre);
		textFieldnombre.setColumns(10);
		
		textFieldcedula = new JTextField();
		textFieldcedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldcedula.setColumns(10);
		textFieldcedula.setBounds(200, 334, 200, 30);
		panel.add(textFieldcedula);
		
		textFieldcargo = new JTextField();
		textFieldcargo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldcargo.setColumns(10);
		textFieldcargo.setBounds(200, 412, 200, 30);
		panel.add(textFieldcargo);
		
		btn = new JButton("Registrarse");
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn.setBounds(220, 491, 160, 29);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String n = textFieldnombre.getText().toString();
				String ci = textFieldcedula.getText().toString();
				String c = textFieldcargo.getText().toString();
				int resultado = 0;
				
				
				try {
					String sqlcheck = "select * from usuarios where ci = '"+ci+"'";
					DB.stmt = DB.conn.createStatement();
					DB.rs = DB.stmt.executeQuery(sqlcheck);
					
					if (DB.rs.next()) {
						resultado = 1;
							if (resultado == 1) {
								JOptionPane.showMessageDialog(view.vista, "Ya se encuentra registrado un usuario con ese numero de cedula");
							} 
							
					} else {
						
						try {
							String sql = "insert into usuarios values ('"+ci+"','"+n+"','"+c+"')";
				        	DB.pstmt = DB.conn.prepareStatement(sql);
							DB.rs = DB.pstmt.executeQuery();
				            
				        } catch (SQLException ex) {
				        	System.out.print(ex);
				        }
						
						JOptionPane.showMessageDialog(view.vista, "Registro Satisfactorio");
			        	hub h = new hub();
			        	view.vista.setContentPane(h.geth());
			        	view.vista.invalidate();
			        	view.vista.validate();
					}
					
					
				} catch (SQLException ex) {
		        	System.out.print(ex);
		        }
				
				
	        }
	    });
		panel.add(btn);
		
		lblNewLabel = new JLabel("Registrarse");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 54));
		lblNewLabel.setBounds(10, 92, 580, 112);
		panel.add(lblNewLabel);
		
		lblnombre = new JLabel("Nombre Completo");
		lblnombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblnombre.setBounds(200, 232, 200, 22);
		panel.add(lblnombre);
		
		lblcedula = new JLabel("Cedula");
		lblcedula.setHorizontalAlignment(SwingConstants.CENTER);
		lblcedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcedula.setBounds(200, 310, 200, 22);
		panel.add(lblcedula);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(200, 388, 200, 22);
		panel.add(lblCargo);
		
		
	
	}
	
	public JPanel getregister() {
		return this.panel;
	}
}
