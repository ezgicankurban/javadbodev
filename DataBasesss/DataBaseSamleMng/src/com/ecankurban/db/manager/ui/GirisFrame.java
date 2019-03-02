package com.ecankurban.db.manager.ui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.ecankurban.db.manager.comming.ConnectionManager;
import com.ecankurban.db.manager.comming.UserDAO;
import com.ecankurban.db.manager.model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GirisFrame extends JFrame {
	private JTextField txtkadi;
	private JTextField txtsifre;

	public GirisFrame() {
		initlialize();
	}

	private void initlialize() {
		setTitle("kullanýcý giriþ sayfasý");
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		txtkadi = new JTextField();
		txtkadi.setBounds(206, 67, 136, 20);
		getContentPane().add(txtkadi);
		txtkadi.setColumns(10);
		
		txtsifre = new JTextField();
		txtsifre.setBounds(206, 117, 136, 20);
		getContentPane().add(txtsifre);
		txtsifre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel.setBounds(25, 67, 93, 17);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setBounds(25, 120, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btngiris = new JButton("Giri\u015F");
		btngiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 UserDAO dao=new UserDAO();
					 User usr=dao.getUserForName(txtkadi.getText());
					if(usr!=null) {
						if(txtsifre.getText().equals(usr.getPassword())) {
							//yeni akran açtýr
							MainFrame mainf=new MainFrame();
							mainf.setVisible(true);
							GirisFrame.this.setVisible(false);
						}
						else 
							JOptionPane.showMessageDialog(GirisFrame.this, "Þifre hatalý");
						
					}
					
					else 
						JOptionPane.showMessageDialog(GirisFrame.this, "Kullanýcý adý hatalý");
					
					
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btngiris.setBounds(236, 193, 89, 23);
		getContentPane().add(btngiris);
		
		JButton btniptal = new JButton("\u0130ptal");
		btniptal.setBounds(29, 193, 89, 23);
		getContentPane().add(btniptal);
		
	}
}
