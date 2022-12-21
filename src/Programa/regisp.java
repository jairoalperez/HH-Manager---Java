package Programa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class regisp {

	JPanel panel;
	JLabel lblNewLabel;
	JButton btnNewButton;
	JTextField textField;
	JTextField textField_1;
	
	public regisp() {
		
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
		
		lblNewLabel = new JLabel("Registrar Proyecto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 64, 580, 112);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(150, 187, 300, 42);
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Registrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(244, 256, 124, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				
				String proy = textField.getText().toString();
				
				if (proy == null) {
					JOptionPane.showMessageDialog(view.vista, "Introduzca un nombre de proyecto");
				} else {
					
					try {
						String sql = "insert into hhproyecto values ('"+proy+"','"+0+"')";
						
						DB.stmt = DB.conn.createStatement();
							DB.stmt.executeUpdate(sql);
							
							JOptionPane.showMessageDialog(view.vista, "El proyecto '"+proy+"' fue registrado satisfactoriamente");
							
					} catch (SQLException e) {
		            	 System.out.print(e);
		            }	
					
				}
				
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblRegistrarTrabajador = new JLabel("Registrar Trabajador");
		lblRegistrarTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarTrabajador.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblRegistrarTrabajador.setBounds(10, 317, 580, 112);
		panel.add(lblRegistrarTrabajador);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(150, 440, 300, 42);
		panel.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(244, 509, 124, 35);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				
				String trab = textField_1.getText().toString();
				
				if (trab == "") {
					JOptionPane.showMessageDialog(view.vista, "Introduzca un nombre de trabajador");
				} else {
					
					try {
						String sql = "insert into trabajador values ('"+trab+"')";
						
						DB.stmt = DB.conn.createStatement();
							DB.stmt.executeUpdate(sql);
							
							JOptionPane.showMessageDialog(view.vista, "El trabajador '"+trab+"' fue registrado satisfactoriamente");
							
					} catch (SQLException e) {
		            	 System.out.print(e);
		            }
					
				}
				
			}
		});
		panel.add(btnNewButton_1);
	
	}
	
	public JPanel getrp() {
		return this.panel;
	}
}
