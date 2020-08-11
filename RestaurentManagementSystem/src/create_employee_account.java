import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class create_employee_account extends JFrame {

	private JPanel contentPane;
	private JTextField fnamefield;
	private JTextField lnamefield;
	private JTextField emailfield;
	private JPasswordField passField;
	private JTextField userfield;
	private JTextField dbfield;
	private JTextField phonefield;
	private JTextField addfield;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox chckbxIAcceptAll;
	private JButton loginbtn;
	private JButton signupbtn;
	private JLabel label;
	private JButton exitbtn;
	private JRadioButton otherbtn,femalebtn,malebtn;
	
	String v ="";
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create_employee_account frame = new create_employee_account();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public create_employee_account() {
		design();
		conn= SQLConnection.ConnerDb();
		
		
	}
		private void register() {
			try {
				
				String query= "insert into employee(FName,LName,Email,Password,Username,Date_of_Birth,Phone,Gender,Address)values(?,?,?,?,?,?,?,?,?)";
				pst= conn.prepareStatement(query);
				pst.setString(1, fnamefield.getText());
				pst.setString(2, lnamefield.getText());
				pst.setString(3, emailfield.getText());
				pst.setString(4, passField.getText());
				pst.setString(5, userfield.getText());
				pst.setString(6, dbfield.getText());
				pst.setString(7, phonefield.getText());
				
				if(malebtn.isSelected()) {
					v  = malebtn.getText().toString();
				}else if(femalebtn.isSelected()) {
					String value =femalebtn.getText().toString();
				}else if (otherbtn.isSelected()) {
					v =otherbtn.getText().toString();
					
				}
				pst.setString(8, String.valueOf(v));
				pst.setString(9, addfield.getText());
				
				pst.execute();
				pst.close();
				JOptionPane.showMessageDialog(null, "SignUp Successfully");
				//dispose();
				employeelogin ch=new employeelogin();
				ch.setVisible(true);
				dispose();
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
			
			
		}
		
		private void design() {
		setTitle("Create Employee Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("Create Employee Account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setBounds(221, 11, 255, 44);
		contentPane.add(lblCreateAccount);
		
		JLabel lblFname = new JLabel("FName");
		lblFname.setHorizontalAlignment(SwingConstants.CENTER);
		lblFname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFname.setBounds(58, 60, 87, 24);
		contentPane.add(lblFname);
		
		JLabel lblLname = new JLabel("LName");
		lblLname.setHorizontalAlignment(SwingConstants.CENTER);
		lblLname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLname.setBounds(58, 98, 87, 24);
		contentPane.add(lblLname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(58, 138, 87, 24);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(58, 173, 87, 24);
		contentPane.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(58, 219, 87, 24);
		contentPane.add(lblUsername);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfBirth.setBounds(58, 258, 87, 24);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(58, 355, 87, 24);
		contentPane.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGender.setBounds(58, 305, 87, 24);
		contentPane.add(lblGender);
		
		fnamefield = new JTextField();
		fnamefield.setBounds(200, 58, 384, 30);
		contentPane.add(fnamefield);
		fnamefield.setColumns(10);
		
		lnamefield = new JTextField();
		lnamefield.setColumns(10);
		lnamefield.setBounds(200, 98, 384, 30);
		contentPane.add(lnamefield);
		
		emailfield = new JTextField();
		emailfield.setColumns(10);
		emailfield.setBounds(200, 136, 384, 30);
		contentPane.add(emailfield);
		
		passField = new JPasswordField();
		passField.setBounds(200, 173, 384, 30);
		contentPane.add(passField);
		
		userfield = new JTextField();
		userfield.setColumns(10);
		userfield.setBounds(200, 210, 384, 30);
		contentPane.add(userfield);
		
		dbfield = new JTextField();
		dbfield.setColumns(10);
		dbfield.setBounds(200, 251, 146, 30);
		contentPane.add(dbfield);
		
		label = new JLabel("Phone");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(356, 258, 72, 24);
		contentPane.add(label);
		
		phonefield = new JTextField();
		phonefield.setColumns(10);
		phonefield.setBounds(438, 256, 146, 30);
		contentPane.add(phonefield);
		
		addfield = new JTextField();
		addfield.setBounds(200, 355, 384, 44);
		contentPane.add(addfield);
		addfield.setColumns(10);
		
		malebtn = new JRadioButton("Male");
		buttonGroup.add(malebtn);
		malebtn.setBounds(200, 307, 109, 23);
		contentPane.add(malebtn);
		
		femalebtn = new JRadioButton("Female");
		buttonGroup.add(femalebtn);
		femalebtn.setBounds(319, 307, 109, 23);
		contentPane.add(femalebtn);
		
		otherbtn = new JRadioButton("Other");
		buttonGroup.add(otherbtn);
		otherbtn.setBounds(458, 307, 109, 23);
		contentPane.add(otherbtn);
		
		signupbtn = new JButton("SignUp");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxIAcceptAll.isSelected()) {
					register();
				}else {
					JOptionPane.showMessageDialog(null, "Read all the term and conditions");
				}
				
			}
		});
		signupbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		signupbtn.setBounds(200, 457, 89, 23);
		contentPane.add(signupbtn);
		
		loginbtn = new JButton("LogIn");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeelogin ch=new employeelogin();
				ch.setVisible(true);
				dispose();
			}
		});
		loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginbtn.setBounds(349, 457, 89, 23);
		contentPane.add(loginbtn);
		
		exitbtn = new JButton("Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		exitbtn.setBounds(495, 457, 89, 23);
		contentPane.add(exitbtn);
		
		chckbxIAcceptAll = new JCheckBox("I accept all the term and condition");
		chckbxIAcceptAll.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxIAcceptAll.setBounds(200, 416, 255, 23);
		contentPane.add(chckbxIAcceptAll);
	}
}
