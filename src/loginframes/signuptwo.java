package loginframes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import BDUtils.DButil;
import customer.accountopeningform;

public class signuptwo extends JFrame implements ActionListener{
		
	JLabel religion,category,income,education,occupation,pan,aadhar,seniour,exacc;
	JTextField panf,aadharf;
	JRadioButton s_yes,s_no,e_yes,e_no;
	JComboBox religionf,categoryf,incomef,educationf,occupatiof;
	JButton nextbtn;
	String formnumber;
	long random;
	
	public signuptwo(String formno) {
		this.formnumber = formno;
		setLayout(null);
	
		
		JLabel page2 = new JLabel("Page 2:  : Additional Details");
		page2.setFont(new Font("Raleway", Font.BOLD, 20));
		page2.setBounds(270, 70, 260, 30);
		add(page2);

		
		religion = new JLabel("Religion: ");
		religion.setFont(new Font("Raleway", Font.BOLD, 18));
		religion.setBounds(100, 130, 200, 30);
		add(religion);
		
		String rel[] = {"Hindu","Muslim","Sikh","Christian","Other"};
		religionf = new JComboBox(rel);
		religionf.setBounds(300, 130, 400, 30);
		religionf.setFont(new Font("Raleway", Font.BOLD, 14));
		religionf.setBackground(Color.white);
		add(religionf);
		
		
		category = new JLabel("Category: ");
		category.setFont(new Font("Raleway", Font.BOLD, 18));
		category.setBounds(100, 180, 200, 30);
		add(category);
		
		String cat[] = {"General","OBC","SC","ST","Other"};
		categoryf = new JComboBox(cat);
		categoryf.setBounds(300, 180, 400, 30);
		categoryf.setFont(new Font("Raleway", Font.BOLD, 14));
		categoryf.setBackground(Color.white);
		add(categoryf);
		
		income = new JLabel("Income: ");
		income.setFont(new Font("Raleway", Font.BOLD, 18));
		income.setBounds(100, 230, 200, 30);
		add(income);
		
		String inc[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
		incomef = new JComboBox(inc);
		incomef.setBounds(300, 230, 400, 30);
		incomef.setFont(new Font("Raleway", Font.BOLD, 14));
		incomef.setBackground(Color.white);
		add(incomef);
		
		
		
		education = new JLabel("Education: ");
		education.setFont(new Font("Raleway", Font.BOLD, 18));
		education.setBounds(100, 280, 200, 30);
		add(education);
		
		String edu[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
		educationf = new JComboBox(edu);
		educationf.setBounds(300, 280, 400, 30);
		educationf.setBackground(Color.white);
		educationf.setFont(new Font("Raleway", Font.BOLD, 14));
		add(educationf);
		
		
		
		
		occupation = new JLabel("Occupation: ");
		occupation.setFont(new Font("Raleway", Font.BOLD, 18));
		occupation.setBounds(100, 330, 200, 30);
		add(occupation);
		
		String occ[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
		occupatiof = new JComboBox(occ);
		occupatiof.setBounds(300, 330, 400, 30);
		occupatiof.setBackground(Color.white);
		occupatiof.setFont(new Font("Raleway", Font.BOLD, 14));
		add(occupatiof);
		
		pan = new JLabel("PAN Number: ");
		pan.setFont(new Font("Raleway", Font.BOLD, 18));
		pan.setBounds(100, 380, 200, 30);
		add(pan);
		
		panf = new JTextField();
		panf.setBounds(300, 380, 400, 30);
		panf.setFont(new Font("Raleway", Font.BOLD, 14));
		add(panf);
		
		
		
		aadhar = new JLabel("Aadhar Number: ");
		aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
		aadhar.setBounds(100, 430, 200, 30);
		add(aadhar);
		
		aadharf = new JTextField();
		aadharf.setBounds(300, 430, 400, 30);
		aadharf.setFont(new Font("Raleway", Font.BOLD, 14));
		add(aadharf);
		
		seniour = new JLabel("Seniour Citizen: ");
		seniour.setFont(new Font("Raleway", Font.BOLD, 18));
		seniour.setBounds(100, 480, 200, 30);
		add(seniour);
		
		s_yes = new JRadioButton("YES");
		s_yes.setBackground(Color.white);
		s_yes.setForeground(Color.black);
		s_yes.setFont(new Font("Raleway", Font.BOLD, 18));
		s_yes.setBounds(300, 480, 100, 30);
		add(s_yes);
		
		s_no = new JRadioButton("No");
		s_no.setBackground(Color.white);
		s_no.setForeground(Color.black);
		s_no.setFont(new Font("Raleway", Font.BOLD, 18));
		s_no.setBounds(450, 480, 100, 30);
		add(s_no);
		
		ButtonGroup citizen = new ButtonGroup();
		citizen.add(s_yes);
		citizen.add(s_no);
		
		
		exacc = new JLabel("Existing Account: ");
		exacc.setFont(new Font("Raleway", Font.BOLD, 18));
		exacc.setBounds(100, 530, 200, 30);
		add(exacc);
		
		e_yes = new JRadioButton("YES");
		e_yes.setBackground(Color.white);
		e_yes.setForeground(Color.black);
		e_yes.setFont(new Font("Raleway", Font.BOLD, 18));
		e_yes.setBounds(300, 530, 100, 30);
		add(e_yes);
		
		e_no = new JRadioButton("NO");
		e_no.setBackground(Color.white);
		e_no.setForeground(Color.black);
		e_no.setFont(new Font("Raleway", Font.BOLD, 18));
		e_no.setBounds(450, 530, 100, 30);
		add(e_no);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(e_no);
		gendergroup.add(e_yes);
		
		
		
		
		
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


		String formno = formnumber;
		String religion = (String) religionf.getSelectedItem();
		String category = (String) categoryf.getSelectedItem();
		String income = (String) incomef.getSelectedItem();
		String education = (String) educationf.getSelectedItem();
		String occupation = (String) occupatiof.getSelectedItem();
		String pan =  panf.getText();
		String aadhar = aadharf.getText();
		
		String citizen = null;
		if(s_yes.isSelected()) {
			citizen = "YES";
		}else if(s_no.isSelected()) {
			citizen = "NO";
		}
		
		String ExAccount = null;
		if(e_yes.isSelected()) {
			ExAccount = "YES";
		}else if(e_no.isSelected()) {
			ExAccount = "NO";
		}
		
		
		
		
		try {
			
			if(religion.equals("") || category.equals("")  || income.equals("") || education.equals("") || occupation.equals("")|| pan.equals("") || aadhar.equals("")) {
				JOptionPane.showMessageDialog(null, "input feild should not be empty");
			}else if(pan.length() != 10){
				JOptionPane.showMessageDialog(null, "Enter PAN Correctly");
				
			}else if(aadhar.length() != 12){
				JOptionPane.showMessageDialog(null, "Enter Aadhar correctly");
				
			}else {
				
					try (Connection conn = DButil.provideConnection()){
					
					String query = "insert into signuptwo values(?,?,?,?,?,?,?,?,?,?)";
					String query2 = "update customerdetails set Religion = ?,category=?,income=?,education=?,occupation=?,pan=?,aadhar=?,Seniou_Citizen=?,Existing_Account=? where FormNO = ?";
					
					PreparedStatement ps = conn.prepareStatement(query);
					PreparedStatement ps2 = conn.prepareStatement(query2);
					
					
					ps.setString(1, formno);
					ps.setString(2, religion);
					ps.setString(3, category);
					ps.setString(4, income);
					ps.setString(5, education);
					ps.setString(6, occupation);
					ps.setString(7, pan);
					ps.setString(8, aadhar);
					ps.setString(9, citizen);
					ps.setString(10, ExAccount);
					
					ps2.setString(1, religion);
					ps2.setString(2, category);
					ps2.setString(3, income);
					ps2.setString(4, education);
					ps2.setString(5, occupation);
					ps2.setString(6, pan);
					ps2.setString(7, aadhar);
					ps2.setString(8, citizen);
					ps2.setString(9, ExAccount);
					ps2.setString(10, formno);
					
					int x = ps.executeUpdate();
					int x2 = ps2.executeUpdate();
					
					
					
					if(x > 0) {
						JOptionPane.showMessageDialog(null, "Registered Succesfull!");
						setVisible(false);
						new accountopeningform(formno).setVisible(true);
						
					
					}else
						JOptionPane.showMessageDialog(null, "Signup Failed!");
					
					
				}catch (SQLException e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Duplicate values!");
				
				
				}
			}
				
				
				
				
					
			
			
		} catch (Exception e2) {

			System.out.println(e2);
			
		}
		
		
		
	}

	
	

}
