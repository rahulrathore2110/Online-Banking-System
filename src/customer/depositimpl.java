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

import javax.swing.*;

import BDUtils.DButil;


public class depositimpl extends JFrame implements ActionListener {
	
	JLabel welcome,amount;
	JTextField amountf;
	JButton dep;
	String username;
	
	public depositimpl(String u1) {
		username = u1;
		
		
		setTitle("STATE BANK OF INDIA");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sbilogo.png"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel logo = new JLabel(i3);
		logo.setBounds(80, 40, 80, 80);
		add(logo);
		
		welcome = new JLabel("DEPOSIT AMOUNT TO ACCOUNT");
		welcome.setFont(new Font("Osward", Font.BOLD,25));
		welcome.setBounds(180, 40, 400, 80);
		add(welcome);
		
		amount = new JLabel("Enter Amount :");
		amount.setFont(new Font("Osward", Font.BOLD,15));
		amount.setBounds(100, 200, 150, 40);
		add(amount);
		
		
		amountf = new JTextField();
		amountf.setFont(new Font("Osward", Font.BOLD,15));
		amountf.setBounds(250, 200, 250, 40);
		add(amountf);
		
		
		dep = new JButton("DEPOSIT");
		dep.setFont(new Font("Ralway", Font.BOLD,15));
		dep.setBounds(350, 330, 150, 40);
		dep.setBackground(Color.black);
		dep.setForeground(Color.white);
		dep.addActionListener(this);
		add(dep);
		
		
		
		

		
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(650,600);
		setVisible(true);
		setLocation(150,10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select Accountbalance from customerdetails where username = ?");
			
			ps.setString(1, username);
			
			
		ResultSet rs =	ps.executeQuery();
		int balance = Integer.parseInt(amountf.getText());
		if(rs.next()) {
			int x = Integer.parseInt(rs.getString("Accountbalance"));
			
			String newbal =  x+balance+"";
			
			
			
			
			PreparedStatement ps2 = conn.prepareStatement("update customerdetails set Accountbalance = ? where username = ?");
			
			
			ps2.setString(1, newbal);
			ps2.setString(2, username);
			
				int update = ps2.executeUpdate();
				
				if(update > 0) {
					
					
					
					PreparedStatement ps3 = conn.prepareStatement("insert into transection(username,Deposit,Withdraw) values(?,?,?)");
					ps3.setString(1, username);
					ps3.setString(2, balance+"");
					ps3.setString(3, " ");
					
					ps3.executeUpdate();
					
					
					
					JOptionPane.showMessageDialog(null, "Deposite Succesfully!");
					JOptionPane.showMessageDialog(null, "Your Account Balance is : " + newbal);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Balance Not Updated");
				}
					
			
		}
			
			
		} catch (SQLException e2) {

			e2.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
	}

}
