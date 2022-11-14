package customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;

import BDUtils.DButil;
import loginframes.loginpage;

public class customerpanel extends JFrame implements ActionListener{

	JButton deposite,withdraw,trasection,exit;
	JLabel welcome,select;
	String username;
	
	public customerpanel(String u1) {
		username = u1;
		setTitle("STATE BANK OF INDIA");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sbilogo.png"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel logo = new JLabel(i3);
		logo.setBounds(80, 40, 80, 80);
		add(logo);
		
		welcome = new JLabel();
		welcome.setFont(new Font("Osward", Font.BOLD,30));
		welcome.setBounds(180, 40, 600, 80);
		add(welcome);
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select name from customerdetails where username = ?");
			
			ps.setString(1, u1);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				welcome.setText("Welcome To SBI "+name);
			}else {
				welcome.setText("Welcome To SBI");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		select = new JLabel("SELECT BELOW OPTION");
		select.setFont(new Font("Osward", Font.BOLD,25));
		select.setBounds(250, 180, 500, 80);
		add(select);
		
		deposite = new JButton("Deposite");
		deposite.setFont(new Font("Raleway", Font.BOLD, 18));
		deposite.setBounds(150, 350, 200, 40);
		deposite.setBackground(Color.black);
		deposite.setForeground(Color.white);
		deposite.addActionListener(this);
		add(deposite);
		
		withdraw = new JButton("Withdraw");
		withdraw.setFont(new Font("Raleway", Font.BOLD, 18));
		withdraw.setBounds(450, 350, 200, 40);
		withdraw.setBackground(Color.black);
		withdraw.setForeground(Color.white);
		withdraw.addActionListener(this);
		add(withdraw);
		
		trasection = new JButton("Transection");
		trasection.setFont(new Font("Raleway", Font.BOLD, 18));
		trasection.setBounds(150, 500, 200, 40);
		trasection.setBackground(Color.black);
		trasection.setForeground(Color.white);
		trasection.addActionListener(this);
		add(trasection);
		
		exit = new JButton("exit");
		exit.setFont(new Font("Raleway", Font.BOLD, 18));
		exit.setBounds(450, 500, 200, 40);
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		exit.addActionListener(this);
		add(exit);
		
		
		
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,800);
		setVisible(true);
		setLocation(150,10);
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == exit) {
			
			setVisible(false);
			new loginpage();
			
			
		}else if(e.getSource() == deposite) {
			new depositimpl(username).setVisible(true);
			
		}else if(e.getSource() == withdraw) {
			new withdrawimpl(username).setVisible(true);
			
		}else if(e.getSource() == trasection) {
			
			new trasectionimpl(username).setVisible(true);
		}
		
	}
}
