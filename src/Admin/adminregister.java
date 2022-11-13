package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import BDUtils.DButil;
import loginframes.loginpage;

public class adminregister extends JFrame implements ActionListener{
	
	JLabel type,email,  username, password,cpasswod,typef; 
	
	JTextField usernamef, emailf;
	JPasswordField passwordf, cpasswordf;
	JButton createacc;
	
	public adminregister() {

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
		sbitext.setBounds(250, 40, 400, 80);
		add(sbitext);
		
		type = new JLabel("User type: ");
		type.setFont(new Font("Raleway", Font.BOLD, 18));
		type.setBounds(100, 200, 200, 30);
		add(type);
		
		
		typef = new JLabel("ADMIN");
		typef.setBounds(300, 200, 400, 40);
		typef.setFont(new Font("Raleway", Font.BOLD, 14));
		typef.setBackground(Color.WHITE);
		add(typef);
		
		email = new JLabel("EmailID: ");
		email.setFont(new Font("Raleway", Font.BOLD, 18));
		email.setBounds(100, 270, 200, 30);
		add(email);
		
		emailf = new JTextField();
		emailf.setFont(new Font("Raleway", Font.BOLD, 18));
		emailf.setBounds(300, 270, 400, 30);
		add(emailf);
		
		username = new JLabel("Set Username: ");
		username.setFont(new Font("Raleway", Font.BOLD, 18));
		username.setBounds(100, 340, 200, 30);
		add(username);
		
		usernamef = new JTextField();
		usernamef.setFont(new Font("Raleway", Font.BOLD, 18));
		usernamef.setBounds(300, 340, 400, 30);
		add(usernamef);
		
		password = new JLabel("Password: ");
		password.setFont(new Font("Raleway", Font.BOLD, 18));
		password.setBounds(100, 410, 200, 30);
		add(password);
		
		passwordf = new JPasswordField();
		passwordf.setFont(new Font("Raleway", Font.BOLD, 18));
		passwordf.setBounds(300, 410, 400, 30);
		add(passwordf);
		
		
		password = new JLabel("Confirm Password: ");
		password.setFont(new Font("Raleway", Font.BOLD, 18));
		password.setBounds(100, 480, 200, 30);
		add(password);
		
		cpasswordf = new JPasswordField();
		cpasswordf.setFont(new Font("Raleway", Font.BOLD, 18));
		cpasswordf.setBounds(300, 480, 400, 30);
		add(cpasswordf);
		
		createacc = new JButton("Create Account");
		createacc.setFont(new Font("Raleway", Font.BOLD, 18));
		createacc.setBounds(500, 600, 200, 40);
		createacc.setBackground(Color.black);
		createacc.setForeground(Color.white);
		createacc.addActionListener(this);
		add(createacc);
		
		
		
		
		
		
		
		
		setVisible(true);
		setSize(800,800);
		setLocation(150,10);
		getContentPane().setBackground(Color.white);
		
	}

	
	public static void main(String[] args) {
		
//		new adminregister();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		String Email = emailf.getText();
		String username = usernamef.getText();
		String password = (String) passwordf.getText();
		String confirmpassword = (String) cpasswordf.getText();
		
		
	try {
			
			if(emailf.equals("") || username.equals("") || password.equals("") || confirmpassword.equals("") ) {
				JOptionPane.showMessageDialog(null, "input feild should not be empty");
			}else if(!password.equals(confirmpassword)) {
				JOptionPane.showMessageDialog(null, "Password does not match");
				
			}else {
				
				try (Connection conn = DButil.provideConnection()){
					
					String query = "insert into adminaccount values(?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1, Email);
					ps.setString(2, username);
					ps.setString(3, password);
					
					
					
					int x = ps.executeUpdate();
					
					if(x > 0) {
						JOptionPane.showMessageDialog(null, "Account Created Succesfully!");
						
						setVisible(false);
						loginpage l = new loginpage();
						l.setVisible(true);
					}else
						JOptionPane.showMessageDialog(null, "Account Creation Failed!");
					
					
				}catch (SQLException e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, e2);
				
				
				}
				
				
					
			} 
			
		} catch (Exception e2) {

			System.out.println(e2);
			JOptionPane.showMessageDialog(null, "Server Error!");
		}
		
	}
}
