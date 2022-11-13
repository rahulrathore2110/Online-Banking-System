package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import BDUtils.DButil;

public class admintrasection extends JFrame{
	String username;
	JLabel welcome ,date, user ,deposit, withdraw;
	
	public admintrasection(String u1) {
		username = u1;
		
		setTitle("STATE BANK OF INDIA");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sbilogo.png"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel logo = new JLabel(i3);
		logo.setBounds(80, 40, 80, 80);
		add(logo);
		
		welcome = new JLabel("TRASECTION DETAILS");
		welcome.setFont(new Font("Osward", Font.BOLD,25));
		welcome.setBounds(200, 40, 400, 80);
		add(welcome);
		
		
		
		date = new JLabel("DATE ");
		date.setFont(new Font("Osward", Font.BOLD,14));
		date.setBounds(100, 150, 150, 20);
		add(date);
		
		user = new JLabel("USERNAME");
		user.setFont(new Font("Osward", Font.BOLD,14));
		user.setBounds(300, 150, 200, 20);
		add(user);
		
		deposit = new JLabel("DEPOSIT ");
		deposit.setFont(new Font("Osward", Font.BOLD,14));
		deposit.setBounds(550, 150, 150, 20);
		add(deposit);
		
		withdraw = new JLabel("WITHDRAW ");
		withdraw.setFont(new Font("Osward", Font.BOLD,14));
		withdraw.setBounds(750, 150, 150, 20);
		add(withdraw);
		
		
		
		
		try(Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from transection");
			
			
			ResultSet rs = ps.executeQuery();
			int d = 200;
			
			while(rs.next()) {
				
				String date = rs.getString("date");
				String user = rs.getString("username");
				String depo = rs.getString("deposit");
				String wid = rs.getString("withdraw");
				String linef = "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
				
				JLabel tdate = new JLabel(date);
				tdate.setFont(new Font("Osward", Font.BOLD,12));
				tdate.setBounds(100, d, 200, 20);
				add(tdate);
				
				JLabel tuser = new JLabel(user);
				tuser.setFont(new Font("Osward", Font.BOLD,12));
				tuser.setBounds(350, d, 150, 20);
				add(tuser);
				
				JLabel tdepo = new JLabel(depo);
				tdepo.setFont(new Font("Osward", Font.BOLD,12));
				tdepo.setBounds(550, d, 80, 20);
				add(tdepo);
				
				JLabel twid = new JLabel(wid);
				twid.setFont(new Font("Osward", Font.BOLD,12));
				twid.setBounds(750, d, 80, 20);
				add(twid);
				
				
				JLabel line = new JLabel(linef);
				line.setBounds(100, d+24, 800, 7);
				add(line);
				
				d = d +35;
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900,900);
		setVisible(true);
		setLocation(150,10);
	}
	
	public static void main(String[] args) {
		
	}
}
