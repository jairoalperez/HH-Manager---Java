package Programa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class login {

	JPanel panel;
	JTextField textFieldCedula;
	JButton btn;
	JLabel lblNewLabel;
	JLabel lblcedula;
	
	public login() {
		
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
		
		textFieldCedula = new JTextField();
		textFieldCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCedula.setBounds(200, 263, 200, 30);
		panel.add(textFieldCedula);
		
		btn = new JButton("Iniciar Sesion");
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn.setBounds(220, 401, 160, 29);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ci = textFieldCedula.getText().toString();
				int resultado = 0;
				
				
				try {
					String sqlcheck = "select * from usuarios where ci = '"+ci+"'";
					DB.stmt = DB.conn.createStatement();
					DB.rs = DB.stmt.executeQuery(sqlcheck);
					
					if (DB.rs.next()) {
						resultado = 1;
							if (resultado == 1) {
								
								home ho = new home();
					        	view.vista.setContentPane(ho.gethome());
					        	view.vista.invalidate();
					        	view.vista.validate();
								
							} 
							
					} else {
						JOptionPane.showMessageDialog(view.vista, "No se encuentran usuarios registrados con ese numero de cedula");
					}
					
				} catch (SQLException ex) {
		        	System.out.print(ex);
		        }
				
				
	        }
	    });
		panel.add(btn);
		
		lblNewLabel = new JLabel("Iniciar Sesion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 54));
		lblNewLabel.setBounds(10, 70, 580, 112);
		panel.add(lblNewLabel);
		
		lblcedula = new JLabel("Cedula");
		lblcedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcedula.setHorizontalAlignment(SwingConstants.CENTER);
		lblcedula.setBounds(200, 239, 200, 22);
		panel.add(lblcedula);
	
	}
	
	public JPanel getlogin() {
		return this.panel;
	}
}
