package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BDUtils.DButil;

public class deleteaccount extends JFrame implements ActionListener{
	JTextField searchf;
	JButton search;
	JLabel welcome;
	
	public deleteaccount() {

		setTitle("STATE BANK OF INDIA");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sbilogo.png"));
		Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel logo = new JLabel(i3);
		logo.setBounds(80, 30, 50, 50);
		add(logo);
		
		welcome = new JLabel("DELETE USER BY ACCOUNT NUMBER");
		welcome.setFont(new Font("Osward", Font.BOLD,25));
		welcome.setBounds(180, 30, 600, 50);
		add(welcome);
		
		
		JLabel searchuser = new JLabel("DELETE USER");
		searchuser.setFont(new Font("Osward", Font.BOLD,20));
		searchuser.setBounds(100, 200, 150, 30);
		add(searchuser);
		
		searchf = new JTextField();
		searchf.setFont(new Font("Osward", Font.BOLD,20));
		searchf.setBounds(300, 200, 400, 30);
		add(searchf);
		
		
		
		
		search = new JButton("DELETE");
		search.setFont(new Font("Ralway", Font.BOLD,13));
		search.setBounds(550, 400, 150, 40);
		search.setBackground(Color.black);
		search.setForeground(Color.white);
		search.addActionListener(this);
		add(search);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,600);
		setVisible(true);
		setLocation(10,10);
	}
	
	
	
	
	public static void main(String[] args) {
		new deleteaccount();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		String account = searchf.getText();
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from customerdetails where AccountNumber = ?");
			ps.setString(1, account);
			
		int x =	ps.executeUpdate();
		
		if(x > 0) {
			JOptionPane.showMessageDialog(null, "Account Deleted Succefully!");
		}else {
			JOptionPane.showMessageDialog(null, "Account Not Found!");
		}
			
		} catch (SQLException e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Account Not Found!");
		}
		
	}
}























