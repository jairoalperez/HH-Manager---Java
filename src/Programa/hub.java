package Programa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class hub {

	static JPanel panel;
	JButton btnLogin;
	JButton btnRegister;
	JLabel lblBienvenido;
	
	public hub() {
		
		panel = new JPanel();
		
		lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 54));
		lblBienvenido.setBounds(10, 106, 564, 84);
		panel.add(lblBienvenido);
		
		btnLogin = new JButton("Iniciar Sesion");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setBounds(211, 241, 160, 29);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	login lg = new login();
	        	view.vista.setContentPane(lg.getlogin());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
		});   
		panel.add(btnLogin);
		
		btnRegister = new JButton("Registrarse");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setBounds(211, 293, 160, 29);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	register regis = new register();
	        	view.vista.setContentPane(regis.getregister());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
		});  
		panel.add(btnRegister);
		
		this.panel.setSize(600, 650);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
	}
	
	public static JPanel geth() {
		return panel;
	}
}
