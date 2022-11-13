package customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.*;

import BDUtils.DButil;
import loginframes.loginpage;
import loginframes.signuptwo;

public class accountopeningform extends JFrame implements ActionListener {
	
	JLabel type,accountno, accountnof, username, password,cpasswod,amount; 
	JComboBox typef;
	JTextField usernamef,amountf;
	JPasswordField passwordf, cpasswordf;
	long random;
	JButton createacc;
	String formnumber;
	
	
	public accountopeningform(String formno) {
		this.formnumber = formno;
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 900000000000l)+10000000l);
		
		
		
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
		
		type = new JLabel("Account type: ");
		type.setFont(new Font("Raleway", Font.BOLD, 18));
		type.setBounds(100, 200, 200, 30);
		add(type);
		
		String rel[] = {"Saving","Current","Fixed Deposite","Reccuring AC"};
		typef = new JComboBox(rel);
		typef.setBounds(300, 200, 400, 30);
		typef.setFont(new Font("Raleway", Font.BOLD, 14));
		typef.setBackground(Color.WHITE);
		add(typef);
		
		accountno = new JLabel("Account No: ");
		accountno.setFont(new Font("Raleway", Font.BOLD, 18));
		accountno.setBounds(100, 270, 200, 30);
		add(accountno);
		
		accountnof = new JLabel();
		accountnof.setFont(new Font("Raleway", Font.BOLD, 18));
		accountnof.setBounds(300, 270, 400, 30);
		accountnof.setText(""+random);
		add(accountnof);
		
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
		
		amount = new JLabel("Deposite Amount: ");
		amount.setFont(new Font("Raleway", Font.BOLD, 18));
		amount.setBounds(100, 550, 200, 30);
		add(amount);
		
		amountf = new JTextField();
		amountf.setFont(new Font("Raleway", Font.BOLD, 18));
		amountf.setBounds(300, 550, 400, 30);
		add(amountf);
		
		createacc = new JButton("Create Account");
		createacc.setFont(new Font("Raleway", Font.BOLD, 18));
		createacc.setBounds(500, 650, 200, 40);
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
		
//		new accountopeningform(null);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		String formno = formnumber;
		String acctype = (String) typef.getSelectedItem();
		String accountNumber = accountnof.getText();
		String username = usernamef.getText();
		String password = (String) passwordf.getText();
		String confirmpassword = (String) cpasswordf.getText();
		String amount = amountf.getText();
		
		
	try {
			
			if(acctype.equals("") || accountNumber.equals("") || username.equals("") || password.equals("") || confirmpassword.equals("") || amount.equals("") ) {
				JOptionPane.showMessageDialog(null, "input feild should not be empty");
			}else if(!password.equals(confirmpassword)) {
				JOptionPane.showMessageDialog(null, "Password does not match");
				
			}else {
				
				try (Connection conn = DButil.provideConnection()){
					
					String query = "insert into c_account values(?,?,?,?,?)";
					String query2 = "update customerdetails set AccountType = ?,AccountNumber=?,Username=?,Password=?, Accountbalance=? where FormNO = ?";
					
					PreparedStatement ps = conn.prepareStatement(query);
					PreparedStatement ps2 = conn.prepareStatement(query2);
					
					
					ps.setString(1, formno);
					ps.setString(2, acctype);
					ps.setString(3, accountNumber);
					ps.setString(4, username);
					ps.setString(5, password);
					
					
					ps2.setString(1, acctype);
					ps2.setString(2, accountNumber);
					ps2.setString(3, username);
					ps2.setString(4, password);
					ps2.setString(5, amount);
					ps2.setString(6, formno);
					
					
					int x = ps.executeUpdate();
					int x2 = ps2.executeUpdate();
					
					
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
