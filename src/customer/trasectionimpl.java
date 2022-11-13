package customer;

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
import javax.swing.JFrame;
import javax.swing.JLabel;

import BDUtils.DButil;

public class trasectionimpl extends JFrame implements ActionListener {
	String username;
	JLabel welcome ,date, deposit, withdraw;
	
	
	
	public trasectionimpl(String u1) {
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
		welcome.setBounds(180, 40, 400, 80);
		add(welcome);
		
		date = new JLabel("DATE ");
		date.setFont(new Font("Osward", Font.BOLD,14));
		date.setBounds(100, 150, 400, 20);
		add(date);
		
		deposit = new JLabel("DEPOSIT ");
		deposit.setFont(new Font("Osward", Font.BOLD,14));
		deposit.setBounds(400, 150, 100, 20);
		add(deposit);
		
		deposit = new JLabel("WITHDRAW ");
		deposit.setFont(new Font("Osward", Font.BOLD,14));
		deposit.setBounds(550, 150, 100, 20);
		add(deposit);
		
		
		
		
		try(Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select date,deposit,withdraw from transection where username = ?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			int d = 175;
			
			while(rs.next()) {
				
				String date = rs.getString("date");
				String depo = rs.getString("deposit");
				String wid = rs.getString("withdraw");
				String linef = "------------------------------------------------------------------------------------------------------------------------------------";
				
				JLabel tdate = new JLabel(date);
				tdate.setFont(new Font("Osward", Font.BOLD,12));
				tdate.setBounds(100, d, 400, 20);
				add(tdate);
				
				JLabel tdepo = new JLabel(depo);
				tdepo.setFont(new Font("Osward", Font.BOLD,12));
				tdepo.setBounds(400, d, 400, 20);
				add(tdepo);
				
				JLabel twid = new JLabel(wid);
				twid.setFont(new Font("Osward", Font.BOLD,12));
				twid.setBounds(550, d, 400, 20);
				add(twid);
				
				
				JLabel line = new JLabel(linef);
				line.setBounds(100, d+24, 550, 7);
				add(line);
				
				d = d +35;
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(750,900);
		setVisible(true);
		setLocation(150,10);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
	}

}
