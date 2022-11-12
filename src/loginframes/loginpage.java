package loginframes;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import bankingException.loginsignexception;


public class loginpage extends JFrame implements ActionListener{
	
	JButton signup, clear, signin;
	JTextField cardfeild;
	JPasswordField pinfeild; 
	
	public loginpage() {
		
		setTitle("STATE BANK OF INDIA");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sbilogo.png"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel logo = new JLabel(i3);
		logo.setBounds(80, 40, 80, 80);
		add(logo);
		
		JLabel sbitext = new JLabel("Welcome to ATM");
		sbitext.setFont(new Font("Osward", Font.BOLD,40));
		sbitext.setBounds(180, 40, 400, 80);
		add(sbitext);
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Osward", Font.BOLD,20));
		cardno.setBounds(100, 180, 100, 30);
		add(cardno);
		
		cardfeild = new JTextField();
		cardfeild.setBounds(250, 180, 300, 30);
		cardfeild.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardfeild);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Osward", Font.BOLD,20));
		pin.setBounds(100, 230, 100, 30);
		add(pin);
		
		pinfeild = new JPasswordField();
		pinfeild.setBounds(250, 230, 300, 30);
		pinfeild.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinfeild);
		
		signin = new JButton("SIGN IN");
		signin.setBounds(250, 300, 135, 30);
		signin.setBackground(Color.black);
		signin.setForeground(Color.WHITE);
		signin.addActionListener(this);
		add(signin);
		
		clear = new JButton("CLEAR");
		clear.setBounds(415, 300, 135, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(250, 360, 300, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,550);
		setVisible(true);
		setLocation(250,150);
	}

	public static void main(String[] args) {
		
		new loginpage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == clear) {
			
			cardfeild.setText("");
			pinfeild.setText("");
			
		}else if(e.getSource() == signin) {
			
			
			
		}else if(e.getSource() == signup) {
			setVisible(false);
			new signupone().setVisible(true);
		}
		 
	}
}
