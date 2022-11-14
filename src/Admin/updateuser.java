package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import BDUtils.DButil;

public class updateuser extends JFrame implements ActionListener {
	

	JTextField name,dob,email,city,state,pincode,pan,aadhar,accounttype,accountnumber,fusername,accountbalance,searchuser,searchf;
	JLabel welcome;
	JButton search,update;
	int d = 250;
	int dd = 400;
	int ddd = 550;
	
	int fd = 300;
	int fdd = 450;
	int fddd = 600;
	
	
	int w  = 200;
	
	public updateuser() {
		
		setTitle("STATE BANK OF INDIA");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sbilogo.png"));
		Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel logo = new JLabel(i3);
		logo.setBounds(80, 30, 50, 50);
		add(logo);
		
		welcome = new JLabel("UPDATE BY USERNAME");
		welcome.setFont(new Font("Osward", Font.BOLD,25));
		welcome.setBounds(180, 30, 600, 50);
		add(welcome);
		
		
		JLabel searchuser = new JLabel("UPDATE USER");
		searchuser.setFont(new Font("Osward", Font.BOLD,20));
		searchuser.setBounds(300, 150, 150, 30);
		add(searchuser);
		
		searchf = new JTextField();
		searchf.setFont(new Font("Osward", Font.BOLD,20));
		searchf.setBounds(500, 150, 400, 30);
		add(searchf);
		

		JLabel jname = new JLabel("NAME");
		jname.setFont(new Font("Osward", Font.BOLD,20));
		jname.setBounds(100, d, w, 20);
		add(jname);
		
		JLabel jdob = new JLabel("DOB");
		jdob.setFont(new Font("Osward", Font.BOLD,20));
		jdob.setBounds(400, d, w, 20);
		add(jdob);
		
		JLabel jemail = new JLabel("EMAIL");
		jemail.setFont(new Font("Osward", Font.BOLD,20));
		jemail.setBounds(750, d, w, 20);
		add(jemail);
		
		JLabel jcity = new JLabel("CITY");
		jcity.setFont(new Font("Osward", Font.BOLD,20));
		jcity.setBounds(1050, d, w, 20);
		add(jcity);
		
		JLabel jstate = new JLabel("STATE");
		jstate.setFont(new Font("Osward", Font.BOLD,20));
		jstate.setBounds(100, dd, w, 20);
		add(jstate);
		
		JLabel jpincode = new JLabel("PINCODE");
		jpincode.setFont(new Font("Osward", Font.BOLD,20));
		jpincode.setBounds(400, dd, w, 20);
		add(jpincode);
		
		JLabel jpan = new JLabel("PAN");
		jpan.setFont(new Font("Osward", Font.BOLD,20));
		jpan.setBounds(750, dd, w, 20);
		add(jpan);
		
		JLabel jaadhar = new JLabel("AADHAR");
		jaadhar.setFont(new Font("Osward", Font.BOLD,20));
		jaadhar.setBounds(1050, dd, w, 20);
		add(jaadhar);
		
		JLabel jaccounttype = new JLabel("TYPE");
		jaccounttype.setFont(new Font("Osward", Font.BOLD,20));
		jaccounttype.setBounds(100, ddd, w, 20);
		add(jaccounttype);
		
		JLabel jaccountnumber = new JLabel("ACC NUMBER");
		jaccountnumber.setFont(new Font("Osward", Font.BOLD,20));
		jaccountnumber.setBounds(400, ddd, w, 20);
		add(jaccountnumber);
		
		JLabel jusername = new JLabel("USERNAME");
		jusername.setFont(new Font("Osward", Font.BOLD,20));
		jusername.setBounds(750, ddd, w, 20);
		add(jusername);
		
		JLabel jaccountbalance = new JLabel("BALANCE");
		jaccountbalance.setFont(new Font("Osward", Font.BOLD,20));
		jaccountbalance.setBounds(1050, ddd, w, 20);
		add(jaccountbalance);
		
//	============================================================================================	
		
		
		int f = 15;
		name  = new JTextField();
		name.setFont(new Font("Osward", Font.BOLD,f));
		name.setBounds(100, fd, w, 25);
		add(name);
		
		dob = new JTextField();
		dob.setFont(new Font("Osward", Font.BOLD,f));
		dob.setBounds(400, fd, w, 25);
		add(dob);
		
		 email = new JTextField();
		email.setFont(new Font("Osward", Font.BOLD,f));
		email.setBounds(750, fd, w, 25);
		add(email);
		
		 city = new JTextField();
		city.setFont(new Font("Osward", Font.BOLD,f));
		city.setBounds(1050, fd, w, 25);
		add(city);
		
		 state = new JTextField();
		state.setFont(new Font("Osward", Font.BOLD,f));
		state.setBounds(100, fdd, w, 25);
		add(state);
		
		 pincode = new JTextField();
		pincode.setFont(new Font("Osward", Font.BOLD,f));
		pincode.setBounds(400, fdd, w, 25);
		add(pincode);
		
		 pan = new JTextField();
		pan.setFont(new Font("Osward", Font.BOLD,f));
		pan.setBounds(750, fdd, w, 25);
		add(pan);
		
		 aadhar = new JTextField();
		aadhar.setFont(new Font("Osward", Font.BOLD,f));
		aadhar.setBounds(1050, fdd, w, 25);
		add(aadhar);
		
		 accounttype = new JTextField();
		accounttype.setFont(new Font("Osward", Font.BOLD,f));
		accounttype.setBounds(100, fddd, w, 25);
		add(accounttype);
		
		 accountnumber = new JTextField();
		accountnumber.setFont(new Font("Osward", Font.BOLD,f));
		accountnumber.setBounds(400, fddd, w, 25);
		add(accountnumber);
		
		 fusername = new JTextField();
		fusername.setFont(new Font("Osward", Font.BOLD,f));
		fusername.setBounds(750, fddd, w, 25);
		add(fusername);
		
		 accountbalance = new JTextField();
		accountbalance.setFont(new Font("Osward", Font.BOLD,f));
		accountbalance.setBounds(1050, fddd, w, 25);
		add(accountbalance);
		
		
		
		
		update = new JButton("UPDATE");
		update.setFont(new Font("Ralway", Font.BOLD,13));
		update.setBounds(700, 750, 170, 40);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		search = new JButton("SEARCH");
		search.setFont(new Font("Ralway", Font.BOLD,13));
		search.setBounds(1050, 750, 170, 40);
		search.setBackground(Color.black);
		search.setForeground(Color.white);
		search.addActionListener(this);
		add(search);
		
		
		

		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(1300,900);
		setVisible(true);
		setLocation(10,10);
	}
	
	public static void main(String[] args) {
		new updateuser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String username = searchf.getText();
		
		if(e.getSource() == update) {
			
			try(Connection conn = DButil.provideConnection()) {
//				
//			
				
				String query = "update customerdetails set name = ?,dob=?,email=?,city=?,state=?,pincode=?,pan=?,aadhar=?,accounttype=?,accountnumber=? where username = ?";
				
				
				PreparedStatement ps2 = conn.prepareStatement(query);
				
				String namef = name.getText();
				String dobf = dob.getText();
				String emailf = email.getText();
				String cityf = city.getText();
				String statef = state.getText();
				String pincodef = pincode.getText();
				String panf = pan.getText();
				String aadharf = aadhar.getText();
				String accounttypef = accounttype.getText();
				String accountnumberf = accountnumber.getText();
				
				if(namef.equals("") || dobf.equals("") ||emailf.equals("") ||cityf.equals("") ||statef.equals("") ||pincodef.equals("") ||panf.equals("") ||aadharf.equals("") ||accounttypef.equals("") ||accountnumberf.equals("")) {
					JOptionPane.showMessageDialog(null, "Input feilf should not be empty");
				}else if(panf.length() != 10) {
					JOptionPane.showMessageDialog(null, "PAN Should be 10 digit");
				}else if(aadharf.length() != 12) {
					JOptionPane.showMessageDialog(null, "Aadhar Should be 12 digit");
				}else {
					
					ps2.setString(1, namef);
					ps2.setString(2, dobf);
					ps2.setString(3, emailf);
					ps2.setString(4, cityf);
					ps2.setString(5, statef);
					ps2.setString(6, pincodef);
					ps2.setString(7, panf);
					ps2.setString(8, aadharf);
					ps2.setString(9, accounttypef);
					ps2.setString(10, accountnumberf);
					ps2.setString(11, username);
					
					int x = ps2.executeUpdate();
					
					if(x > 0) {
						JOptionPane.showMessageDialog(null, "Update User Succesfully");
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Not Updated");
					}
					
				}
					
				
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			
		}else if(e.getSource() == search) {
			
				try(Connection conn = DButil.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("select Name,DOB,Email,City,State,Pincode,PAN,Aadhar,AccountType,AccountNumber,Username,Accountbalance from customerdetails where Username = ?");
				
				ps.setString(1, username);
				
				ResultSet rs = ps.executeQuery();
				
					if(rs.next()) {
									
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
								
									
								
									name.setText(namef);
									dob.setText(dobf);
									email.setText(emailf);
									city.setText(cityf);
									state.setText(statef);
									pincode.setText(pincodef);
									pan.setText(panf);
									aadhar.setText(aadharf);
									accounttype.setText(accounttypef);
									accountnumber.setText(accountnumberf);
									fusername.setText(usernamef);
									accountbalance.setText(accountbalancef);


									
									
									
									
								}else {
									
									JOptionPane.showMessageDialog(null, "Uer Not Found");
								}
				
				
				
				
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			
		}
	
		
	}

}
