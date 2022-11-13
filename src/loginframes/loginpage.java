package loginframes;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

import Admin.adminpanel;
import Admin.adminregister;
import BDUtils.DButil;
import bankingException.loginsignexception;
import customer.customerpanel;


public class loginpage extends JFrame implements ActionListener{
	
	JButton csignup, clear, signin,asignup;
	JTextField usernamef;
	JPasswordField passwordf; 
	JComboBox userf;
	
	public loginpage() {
		
		setTitle("STATE BANK OF INDIA");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sbilogo.png"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel logo = new JLabel(i3);
		logo.setBounds(80, 40, 80, 80);
		add(logo);
		
		JLabel sbitext = new JLabel("Welcome to SBI");
		sbitext.setFont(new Font("Osward", Font.BOLD,40));
		sbitext.setBounds(180, 40, 400, 80);
		add(sbitext);
		
		JLabel username = new JLabel("Username:");
		username.setFont(new Font("Osward", Font.BOLD,17));
		username.setBounds(100, 180, 100, 30);
		add(username);
		
		usernamef = new JTextField();
		usernamef.setBounds(250, 180, 300, 30);
		usernamef.setFont(new Font("Arial", Font.BOLD, 14));
		add(usernamef);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Osward", Font.BOLD,17));
		password.setBounds(100, 230, 100, 30);
		add(password);
		
		passwordf = new JPasswordField();
		passwordf.setBounds(250, 230, 300, 30);
		passwordf.setFont(new Font("Arial", Font.BOLD, 14));
		add(passwordf);
		
		signin = new JButton("SIGN IN");
		signin.setBounds(250, 380, 135, 30);
		signin.setBackground(Color.black);
		signin.setForeground(Color.WHITE);
		signin.addActionListener(this);
		add(signin);
		
		JLabel user = new JLabel("User:");
		user.setFont(new Font("Osward", Font.BOLD,17));
		user.setBounds(100, 280, 100, 30);
		add(user);
		
		
		String type[] = {"Admin","Customer"};
		userf = new JComboBox(type);
		userf.setBounds(250, 280, 300, 30);
		userf.setFont(new Font("Arial", Font.BOLD, 14));
		userf.setBackground(Color.white);
		userf.setForeground(Color.black);
		add(userf);
		
		
		clear = new JButton("CLEAR");
		clear.setBounds(415, 380, 135, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		csignup = new JButton("New Customer");
		csignup.setBounds(250, 430, 135, 30);
		csignup.setBackground(Color.black);
		csignup.setForeground(Color.WHITE);
		csignup.addActionListener(this);
		add(csignup);
		
		
		asignup = new JButton("New Admin");
		asignup.setBounds(415, 430, 135, 30);
		asignup.setBackground(Color.black);
		asignup.setForeground(Color.WHITE);
		asignup.addActionListener(this);
		add(asignup);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,550);
		setVisible(true);
		setLocation(150,150);
	}

	public static void main(String[] args) {
		
		new loginpage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		String usertype = (String) userf.getSelectedItem();
		if(e.getSource() == clear) {
			
			usernamef.setText("");
			passwordf.setText("");
			
			
		}else if(e.getSource() == csignup) {
			System.out.println("dfsdf");
			setVisible(false);
			new signupone().setVisible(true);
		}else if(e.getSource() == asignup) {
			setVisible(false);
			adminregister ad = new adminregister();
			ad.setVisible(true);
		}else if(e.getSource() == signin) {
			
			
			if(usertype.equals("Admin")) {
			
				
				String u1 = usernamef.getText();
			String p1 = (String) passwordf.getText();
				
				
				try (Connection conn = DButil.provideConnection()) {
				
					PreparedStatement ps = conn.prepareStatement("select username,password from Adminaccount where username = ? AND password = ?");
					
					
					ps.setString(1, u1);
					ps.setString(2, p1);
					
					ResultSet rs =  ps.executeQuery();
					
					if(rs.next()) {
					
						JOptionPane.showMessageDialog(null, "Welcome!");
						
						adminpanel ad = new adminpanel(u1);
						setVisible(false);
						ad.setVisible(true);
						
					}else {
						
						JOptionPane.showMessageDialog(null, "No result found!");
					}
					
					
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!");
			}
				
			
				
			}else {
				
				System.out.println("c");
				String u1 = usernamef.getText();
				String p1 = (String) passwordf.getText();
				
				try (Connection conn = DButil.provideConnection()) {
					
					PreparedStatement ps = conn.prepareStatement("select username,password from customerdetails where username = ? AND password = ?");
					
					ps.setString(1, u1);
					ps.setString(2, p1);
					
					ResultSet rs =  ps.executeQuery();
					System.out.println(rs);
					
					if(rs.next()) {
						
						JOptionPane.showMessageDialog(null, "Welcome!");
						customerpanel cp = new customerpanel(u1);
						setVisible(false);
						cp.setVisible(true);
					}else {
						
						JOptionPane.showMessageDialog(null, "No result found!");
					}
					
				
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!");
				}
				
				
			}
			
			
		}
		 
	}
}
