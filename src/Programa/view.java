package Programa;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class view extends JFrame{

	public static JFrame vista;

	protected JButton botoncomenzar;
	protected JLabel label; 

	public view() {

		vista = new JFrame("HH BD N&V");
		
		this.botoncomenzar = new JButton("Comenzar");
		this.botoncomenzar.setBounds(0, 0, 600, 600);
		botoncomenzar.setBackground(Color.WHITE);
		botoncomenzar.setFont(new Font("Arial Black", Font.PLAIN, 13));
		this.botoncomenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	hub h = new hub();
	        	view.vista.setContentPane(hub.geth());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		this.vista.add(botoncomenzar);
		
		this.vista.setSize(600, 650);
		this.vista.setLayout(null);
		this.vista.setVisible(true);
		
	}
	}
	
	
	
	