package Programa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class home {

	JPanel panel;
	JLabel lblNewLabel;
	JButton btnhhtp;
	JButton btnhhtt;
	JButton btnregishh;
	JButton btnregisp;
	
	public home() {
		
		panel = new JPanel();
		this.panel.setSize(600, 650);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
		JButton btnregresar = new JButton("Cerrar Sesion");
		btnregresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnregresar.setBackground(Color.LIGHT_GRAY);
		btnregresar.setBounds(1, 1, 150, 25);
		btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	hub h = new hub();
	        	view.vista.setContentPane(h.geth());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		panel.add(btnregresar);
		
		lblNewLabel = new JLabel("INICIO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 54));
		lblNewLabel.setBounds(10, 59, 580, 112);
		panel.add(lblNewLabel);
		
		btnhhtp = new JButton("HH Totales por Proyecto");
		btnhhtp.setBackground(Color.LIGHT_GRAY);
		btnhhtp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnhhtp.setBounds(150, 232, 300, 50);
		btnhhtp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	HHTP horas = new HHTP();
	        	view.vista.setContentPane(horas.gethhtp());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		panel.add(btnhhtp);
		
		btnregishh = new JButton("Hacer Registro de HH");
		btnregishh.setBackground(Color.LIGHT_GRAY);
		btnregishh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnregishh.setBounds(150, 391, 300, 50);
		btnregishh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	regishh hh = new regishh();
	        	view.vista.setContentPane(hh.getrhh());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		panel.add(btnregishh);
		
		btnregisp = new JButton("Registrar Proyecto y Trabajador");
		btnregisp.setBackground(Color.LIGHT_GRAY);
		btnregisp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnregisp.setBounds(150, 311, 300, 50);
		btnregisp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	regisp rp = new regisp();
	        	view.vista.setContentPane(rp.getrp());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		panel.add(btnregisp);
	
	}
	
	public JPanel gethome() {
		return this.panel;
	}
}

