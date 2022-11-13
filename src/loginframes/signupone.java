package loginframes;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import BDUtils.DButil;
import bankingException.loginsignexception;

public class signupone extends JFrame implements ActionListener {
	
	JLabel name, father, DOB, gender, email, maritial, addres, city, state, pincode;
	JTextField namef, fatherf, emailf,addresf,cityf,statef,pincodef;
	JRadioButton male,female,married,unmarried,other;
	JDateChooser datechooser;
	JButton nextbtn;
	long random;
	
	public signupone() {
		setLayout(null);
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000l)+1000l);
		
		JLabel formno = new JLabel("APPLICATION FORM NO : "+random);
		formno.setFont(new Font("Raleway", Font.BOLD, 30));
		formno.setBounds(200, 20, 500, 30);
		add(formno);
		
		JLabel page1 = new JLabel("Page 1:  : Personal Details");
		page1.setFont(new Font("Raleway", Font.BOLD, 20));
		page1.setBounds(270, 70, 260, 30);
		add(page1);

		
		name = new JLabel("Name: ");
		name.setFont(new Font("Raleway", Font.BOLD, 18));
		name.setBounds(100, 130, 200, 30);
		add(name);
		
		namef = new JTextField();
		namef.setBounds(300, 130, 400, 30);
		namef.setFont(new Font("Raleway", Font.BOLD, 14));
		add(namef);
		
		
		father = new JLabel("Father's Name: ");
		father.setFont(new Font("Raleway", Font.BOLD, 18));
		father.setBounds(100, 180, 200, 30);
		add(father);
		
		fatherf = new JTextField();
		fatherf.setBounds(300, 180, 400, 30);
		fatherf.setFont(new Font("Raleway", Font.BOLD, 14));
		add(fatherf);
		
		DOB = new JLabel("Date of Birth: ");
		DOB.setFont(new Font("Raleway", Font.BOLD, 18));
		DOB.setBounds(100, 230, 200, 30);
		add(DOB);
		
		datechooser  = new JDateChooser();
		datechooser.setBounds(300, 230, 400, 30);
		add(datechooser);
		
		
		gender = new JLabel("Gender: ");
		gender.setFont(new Font("Raleway", Font.BOLD, 18));
		gender.setBounds(100, 280, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBackground(Color.white);
		male.setForeground(Color.black);
		male.setFont(new Font("Raleway", Font.BOLD, 18));
		male.setBounds(300, 280, 100, 30);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBackground(Color.white);
		female.setForeground(Color.black);
		female.setFont(new Font("Raleway", Font.BOLD, 18));
		female.setBounds(450, 280, 100, 30);
		add(female);
		
		other = new JRadioButton("Others");
		other.setBackground(Color.white);
		other.setForeground(Color.black);
		other.setFont(new Font("Raleway", Font.BOLD, 18));
		other.setBounds(600, 280, 100, 30);
		add(other);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other);
		
		
		
		email = new JLabel("Email Address: ");
		email.setFont(new Font("Raleway", Font.BOLD, 18));
		email.setBounds(100, 330, 200, 30);
		add(email);
		
		emailf = new JTextField();
		emailf.setBounds(300, 330, 400, 30);
		emailf.setFont(new Font("Raleway", Font.BOLD, 14));
		add(emailf);
		
		maritial = new JLabel("Maritial Status: ");
		maritial.setFont(new Font("Raleway", Font.BOLD, 18));
		maritial.setBounds(100, 380, 200, 30);
		add(maritial);
		
		married = new JRadioButton("Married");
		married.setBackground(Color.white);
		married.setForeground(Color.black);
		married.setFont(new Font("Raleway", Font.BOLD, 18));
		married.setBounds(300, 380, 150, 30);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBackground(Color.white);
		unmarried.setForeground(Color.black);
		unmarried.setFont(new Font("Raleway", Font.BOLD, 18));
		unmarried.setBounds(550, 380, 150, 30);
		add(unmarried);
		
		ButtonGroup maritialgroup = new ButtonGroup();
		maritialgroup.add(married);
		maritialgroup.add(unmarried);
		
		addres = new JLabel("Address: ");
		addres.setFont(new Font("Raleway", Font.BOLD, 18));
		addres.setBounds(100, 430, 200, 30);
		add(addres);
		
		addresf = new JTextField();
		addresf.setBounds(300, 430, 400, 30);
		addresf.setFont(new Font("Raleway", Font.BOLD, 14));
		add(addresf);
		
		city = new JLabel("City: ");
		city.setFont(new Font("Raleway", Font.BOLD, 18));
		city.setBounds(100, 480, 200, 30);
		add(city);
		
		cityf = new JTextField();
		cityf.setBounds(300, 480, 400, 30);
		cityf.setFont(new Font("Raleway", Font.BOLD, 14));
		add(cityf);
		
		state = new JLabel("State: ");
		state.setFont(new Font("Raleway", Font.BOLD, 18));
		state.setBounds(100, 530, 200, 30);
		add(state);
		
		statef = new JTextField();
		statef.setBounds(300, 530, 400, 30);
		statef.setFont(new Font("Raleway", Font.BOLD, 14));
		add(statef);
		
		pincode = new JLabel("Pincode: ");
		pincode.setFont(new Font("Raleway", Font.BOLD, 18));
		pincode.setBounds(100, 580, 200, 30);
		add(pincode);
		
		pincodef = new JTextField();
		pincodef.setBounds(300, 580, 400, 30);
		pincodef.setFont(new Font("Raleway", Font.BOLD, 14));
		add(pincodef);
		
		
		nextbtn = new JButton("Next");
		nextbtn.setBackground(Color.black);
		nextbtn.setForeground(Color.white);
		nextbtn.setFont(new Font("Raleway", Font.BOLD, 18));
		nextbtn.setBounds(600, 640, 100, 40);
		nextbtn.addActionListener(this);
		add(nextbtn);
		
		
		
		setSize(850,800);
		setLocation(150,10);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		
		
		
		
	}

	public static void main(String[] args) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e){


		String formno = ""+random;
		String name = namef.getText(); 
		String fname = fatherf.getText();
		String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()) {
			gender = "Female";
		}else if(other.isSelected()) {
			gender = "Others";
		}
		
		String email = emailf.getText();
		String maritial = null;
		if(married.isSelected()) {
			maritial = "Married";
		}else if(unmarried.isSelected()) {
			maritial = "Unmarried";
		}
		
		String address =  addresf.getText();
		String city = cityf.getText();
		String state = statef.getText();
		String pincode = pincodef.getText();
		
		try {
			
			if(name.equals("") || fname.equals("") || dob.equals("") || email.equals("") || address.equals("") || city.equals("")|| state.equals("") || pincode.equals("")) {
				JOptionPane.showMessageDialog(null, "input feild should not be empty");
			}else {
				
				try (Connection conn = DButil.provideConnection()){
					
					String query = "insert into signup values(?,?,?,?,?,?,?,?,?,?,?)";
					String query2 = "insert into customerdetails(FormNO,Name,Father_Name,DOB,Gender,Email,Maritial,Address,City,State,Pincode) values(?,?,?,?,?,?,?,?,?,?,?)";
					
					
					
					PreparedStatement ps = conn.prepareStatement(query);
					PreparedStatement ps2 = conn.prepareStatement(query2);
					
					ps.setString(1, formno);
					ps.setString(2, name);
					ps.setString(3, fname);
					ps.setString(4, dob);
					ps.setString(5, gender);
					ps.setString(6, email);
					ps.setString(7, maritial);
					ps.setString(8, address);
					ps.setString(9, city);
					ps.setString(10, state);
					ps.setString(11, pincode);
					
					ps2.setString(1, formno);
					ps2.setString(2, name);
					ps2.setString(3, fname);
					ps2.setString(4, dob);
					ps2.setString(5, gender);
					ps2.setString(6, email);
					ps2.setString(7, maritial);
					ps2.setString(8, address);
					ps2.setString(9, city);
					ps2.setString(10, state);
					ps2.setString(11, pincode);
					
					int x = ps.executeUpdate();
					int x2 = ps2.executeUpdate();
					
					if(x > 0) {
						JOptionPane.showMessageDialog(null, "Details Save Succesfull!");
						setVisible(false);
						new signuptwo(formno).setVisible(true);	
					}else
						JOptionPane.showMessageDialog(null, "Signup Failed!");
					
					
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
























