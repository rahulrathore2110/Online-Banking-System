package Admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import BDUtils.DButil;
import loginframes.loginpage;
import loginframes.signupone;

public class adminpanel extends JFrame implements ActionListener{
	String username;
	JLabel welcome;
	JButton all_acc,update_acc,delete_acc,search,transections,exit;
	
	
	
	public adminpanel(String u1) {

		username = u1;
		setTitle("STATE BANK OF INDIA");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sbilogo.png"));
		Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel logo = new JLabel(i3);
		logo.setBounds(80, 30, 50, 50);
		add(logo);
		
		welcome = new JLabel("SBI ADMIN DASHBOARD , WELCOME : "+ u1);
		welcome.setFont(new Font("Osward", Font.BOLD,25));
		welcome.setBounds(180, 30, 600, 50);
		add(welcome);
		
		
		all_acc = new JButton("All ACCOUNTS");
		all_acc.setFont(new Font("Ralway", Font.BOLD,13));
		all_acc.setBounds(100, 120, 170, 40);
		all_acc.setBackground(Color.black);
		all_acc.setForeground(Color.white);
		all_acc.addActionListener(this);
		add(all_acc);
		
		update_acc = new JButton("UPDATE ACCOUNT");
		update_acc.setFont(new Font("Ralway", Font.BOLD,13));
		update_acc.setBounds(300, 120, 170, 40);
		update_acc.setBackground(Color.black);
		update_acc.setForeground(Color.white);
		update_acc.addActionListener(this);
		add(update_acc);
		
		delete_acc = new JButton("DELETE ACCOUNT");
		delete_acc.setFont(new Font("Ralway", Font.BOLD,13));
		delete_acc.setBounds(500, 120, 170, 40);
		delete_acc.setBackground(Color.black);
		delete_acc.setForeground(Color.white);
		delete_acc.addActionListener(this);
		add(delete_acc);

		search = new JButton("SEARCH ACCOUNTS");
		search.setFont(new Font("Ralway", Font.BOLD,13));
		search.setBounds(700, 120, 170, 40);
		search.setBackground(Color.black);
		search.setForeground(Color.white);
		search.addActionListener(this);
		add(search);
		
		transections = new JButton("ALL TRASECTIONS");
		transections.setFont(new Font("Ralway", Font.BOLD,13));
		transections.setBounds(900, 120, 170, 40);
		transections.setBackground(Color.black);
		transections.setForeground(Color.white);
		transections.addActionListener(this);
		add(transections);
		
		exit = new JButton("EXIT");
		exit.setFont(new Font("Ralway", Font.BOLD,13));
		exit.setBounds(1100, 120, 100, 40);
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		exit.addActionListener(this);
		add(exit);
		
		
		
		int d = 200;
		
		JLabel jname = new JLabel("NAME");
		jname.setFont(new Font("Osward", Font.BOLD,12));
		jname.setBounds(50, d, 50, 20);
		add(jname);
		
		JLabel jdob = new JLabel("DOB");
		jdob.setFont(new Font("Osward", Font.BOLD,12));
		jdob.setBounds(120, d, 100, 20);
		add(jdob);
		
		JLabel jemail = new JLabel("EMAIL");
		jemail.setFont(new Font("Osward", Font.BOLD,12));
		jemail.setBounds(240, d, 150, 20);
		add(jemail);
		
		JLabel jcity = new JLabel("CITY");
		jcity.setFont(new Font("Osward", Font.BOLD,12));
		jcity.setBounds(410, d, 50, 20);
		add(jcity);
		
		JLabel jstate = new JLabel("STATE");
		jstate.setFont(new Font("Osward", Font.BOLD,12));
		jstate.setBounds(480, d, 50, 20);
		add(jstate);
		
		JLabel jpincode = new JLabel("PINCODE");
		jpincode.setFont(new Font("Osward", Font.BOLD,12));
		jpincode.setBounds(550, d, 50, 20);
		add(jpincode);
		
		JLabel jpan = new JLabel("PAN");
		jpan.setFont(new Font("Osward", Font.BOLD,12));
		jpan.setBounds(620, d, 90, 20);
		add(jpan);
		
		JLabel jaadhar = new JLabel("AADHAR");
		jaadhar.setFont(new Font("Osward", Font.BOLD,12));
		jaadhar.setBounds(720, d, 100, 20);
		add(jaadhar);
		
		JLabel jaccounttype = new JLabel("TYPE");
		jaccounttype.setFont(new Font("Osward", Font.BOLD,12));
		jaccounttype.setBounds(840, d, 70, 20);
		add(jaccounttype);
		
		JLabel jaccountnumber = new JLabel("ACC NUMBER");
		jaccountnumber.setFont(new Font("Osward", Font.BOLD,12));
		jaccountnumber.setBounds(930, d, 90, 20);
		add(jaccountnumber);
		
		JLabel jusername = new JLabel("USERNAME");
		jusername.setFont(new Font("Osward", Font.BOLD,12));
		jusername.setBounds(1040, d, 90, 20);
		add(jusername);
		
		JLabel jaccountbalance = new JLabel("BALANCE");
		jaccountbalance.setFont(new Font("Osward", Font.BOLD,12));
		jaccountbalance.setBounds(1150, d, 70, 20);
		add(jaccountbalance);
		d = d+25;
		String lineequal = "=======================================================================================================================================================================";
		JLabel linee = new JLabel(lineequal);
		linee.setBounds(50, d, 1200, 7);
		add(linee);
//	*************************************************************************************************************	
		
		
		try (Connection conn = DButil.provideConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select Name,DOB,Email,City,State,Pincode,PAN,Aadhar,AccountType,AccountNumber,Username,Accountbalance from customerdetails");
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				d = d + 35;
				
				String namef = rs.getString("name");
				String dobf = rs.getString("dob");
				String emailf = rs.getString("email");
				String cityf = rs.getString("city");
				String statef = rs.getString("state");
				String pincodef = rs.getString("pincode");
				String panf = rs.getString("pan");
				String aadharf = rs.getString("aadhar");
				String accounttypef = rs.getString("accounttype");
				String accountnumberf = rs.getString("accountnumber");
				String usernamef = rs.getString("username");
				String accountbalancef = rs.getString("accountbalance");
			
				String linef = "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
				
				JLabel name = new JLabel(namef);
				name.setFont(new Font("Osward", Font.BOLD,12));
				name.setBounds(50, d, 50, 20);
				add(name);
				
				JLabel dob = new JLabel(dobf);
				dob.setFont(new Font("Osward", Font.BOLD,12));
				dob.setBounds(120, d, 100, 20);
				add(dob);
				
				JLabel email = new JLabel(emailf);
				email.setFont(new Font("Osward", Font.BOLD,12));
				email.setBounds(240, d, 150, 20);
				add(email);
				
				JLabel city = new JLabel(cityf);
				city.setFont(new Font("Osward", Font.BOLD,12));
				city.setBounds(410, d, 50, 20);
				add(city);
				
				JLabel state = new JLabel(statef);
				state.setFont(new Font("Osward", Font.BOLD,12));
				state.setBounds(480, d, 50, 20);
				add(state);
				
				JLabel pincode = new JLabel(pincodef);
				pincode.setFont(new Font("Osward", Font.BOLD,12));
				pincode.setBounds(550, d, 50, 20);
				add(pincode);
				
				JLabel pan = new JLabel(panf);
				pan.setFont(new Font("Osward", Font.BOLD,12));
				pan.setBounds(620, d, 90, 20);
				add(pan);
				
				JLabel aadhar = new JLabel(aadharf);
				aadhar.setFont(new Font("Osward", Font.BOLD,12));
				aadhar.setBounds(720, d, 100, 20);
				add(aadhar);
				
				JLabel accounttype = new JLabel(accounttypef);
				accounttype.setFont(new Font("Osward", Font.BOLD,12));
				accounttype.setBounds(840, d, 70, 20);
				add(accounttype);
				
				JLabel accountnumber = new JLabel(accountnumberf);
				accountnumber.setFont(new Font("Osward", Font.BOLD,12));
				accountnumber.setBounds(930, d, 90, 20);
				add(accountnumber);
				
				JLabel username = new JLabel(usernamef);
				username.setFont(new Font("Osward", Font.BOLD,12));
				username.setBounds(1040, d, 90, 20);
				add(username);
				
				JLabel accountbalance = new JLabel(accountbalancef);
				accountbalance.setFont(new Font("Osward", Font.BOLD,12));
				accountbalance.setBounds(1150, d, 70, 20);
				add(accountbalance);
				
				
				
				
				JLabel line = new JLabel(linef);
				line.setBounds(50, d+24, 1200, 7);
				add(line);
				
				d = d +35;
				
				
			}
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		
//	******************************************************************************************************	
		
		
		
		
		
		
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(1300,900);
		setVisible(true);
		setLocation(10,10);
	}

	public static void main(String[] args) {
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == update_acc) {
			
			updateuser up = new updateuser();
			up.setVisible(true);
			
			
			
		}else if(e.getSource() == delete_acc) {
			
			deleteaccount del = new deleteaccount();
			del.setVisible(true);
			
			
			
		}else if(e.getSource() == search) {
			
			searchaccount searchacc = new searchaccount();
			searchacc.setVisible(true);
			
			
		}else if(e.getSource() == transections) {
			admintrasection ad = new admintrasection(username);
			ad.setVisible(true);
			
			
		}else if(e.getSource() == exit) {
			
			setVisible(false);
			new loginpage().setVisible(true);
			
			
		}
		
	}

	
}
