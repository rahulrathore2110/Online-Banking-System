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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BDUtils.DButil;

public class searchaccount extends JFrame implements ActionListener{

	
	JLabel welcome,name,dob,email,city,state,pincode,pan,aadhar,accounttype,accountnumber,fusername,accountbalance,searchuser;
	JTextField searchf;
	JButton search;
	int d = 250;
	int dd = 400;
	int ddd = 550;
	
	int fd = 300;
	int fdd = 450;
	int fddd = 600;
	
	
	int w  = 250;
	
	public searchaccount() {
		
		setTitle("STATE BANK OF INDIA");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sbilogo.png"));
		Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel logo = new JLabel(i3);
		logo.setBounds(80, 30, 50, 50);
		add(logo);
		
		welcome = new JLabel("SEARCH BY USERNAME");
		welcome.setFont(new Font("Osward", Font.BOLD,25));
		welcome.setBounds(180, 30, 600, 50);
		add(welcome);
		
		
		JLabel searchuser = new JLabel("SEACH USER");
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
		
		
		
		name = new JLabel();
		name.setFont(new Font("Osward", Font.BOLD,20));
		name.setBounds(100, fd, w, 25);
		add(name);
		
		dob = new JLabel();
		dob.setFont(new Font("Osward", Font.BOLD,20));
		dob.setBounds(400, fd, w, 25);
		add(dob);
		
		 email = new JLabel();
		email.setFont(new Font("Osward", Font.BOLD,20));
		email.setBounds(750, fd, w, 25);
		add(email);
		
		 city = new JLabel();
		city.setFont(new Font("Osward", Font.BOLD,20));
		city.setBounds(1050, fd, w, 25);
		add(city);
		
		 state = new JLabel();
		state.setFont(new Font("Osward", Font.BOLD,20));
		state.setBounds(100, fdd, w, 25);
		add(state);
		
		 pincode = new JLabel();
		pincode.setFont(new Font("Osward", Font.BOLD,20));
		pincode.setBounds(400, fdd, w, 25);
		add(pincode);
		
		 pan = new JLabel("");
		pan.setFont(new Font("Osward", Font.BOLD,20));
		pan.setBounds(750, fdd, w, 25);
		add(pan);
		
		 aadhar = new JLabel("");
		aadhar.setFont(new Font("Osward", Font.BOLD,20));
		aadhar.setBounds(1050, fdd, w, 25);
		add(aadhar);
		
		 accounttype = new JLabel("");
		accounttype.setFont(new Font("Osward", Font.BOLD,20));
		accounttype.setBounds(100, fddd, w, 25);
		add(accounttype);
		
		 accountnumber = new JLabel("");
		accountnumber.setFont(new Font("Osward", Font.BOLD,20));
		accountnumber.setBounds(400, fddd, w, 25);
		add(accountnumber);
		
		 fusername = new JLabel("");
		fusername.setFont(new Font("Osward", Font.BOLD,20));
		fusername.setBounds(750, fddd, w, 25);
		add(fusername);
		
		 accountbalance = new JLabel("");
		accountbalance.setFont(new Font("Osward", Font.BOLD,20));
		accountbalance.setBounds(1050, fddd, w, 25);
		add(accountbalance);
		
		
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
		new searchaccount();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String username = searchf.getText();
		
		
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























