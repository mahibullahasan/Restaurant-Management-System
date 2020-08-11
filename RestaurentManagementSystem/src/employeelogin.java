import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class employeelogin extends JFrame {
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeelogin frame = new employeelogin();
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
	public employeelogin() {
		design();
		conn=SQLConnection.ConnerDb();
		
	}
	private void login() {
		try {
			
			String query="Select * from employee where username=? and Password =?"; 
			pst=conn.prepareStatement(query);
			pst.setString(1, textField.getText());
			pst.setString(2, passwordField.getText());
			
			rs=pst.executeQuery();
			
			if(rs.next()) {
				
				//JOptionPane.showMessageDialog(null,"Login Successful");
				
				RestaurentManagementSystem m =new RestaurentManagementSystem();
				m.setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null,"Login Failed");
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
		
	private void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeLogin = new JLabel("Employee Login");
		lblEmployeeLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmployeeLogin.setBounds(194, 21, 272, 53);
		contentPane.add(lblEmployeeLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(74, 103, 99, 35);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(74, 168, 99, 35);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(249, 110, 281, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 172, 281, 28);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBounds(249, 235, 117, 23);
		contentPane.add(btnLogin);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				create_employee_account ch=new create_employee_account();
				ch.setVisible(true);
				dispose();
				
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSignup.setBounds(413, 235, 117, 23);
		contentPane.add(btnSignup);
	}
}
