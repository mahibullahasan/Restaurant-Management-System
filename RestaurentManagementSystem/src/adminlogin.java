import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminlogin extends JFrame {
	
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
					adminlogin frame = new adminlogin();
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
	public adminlogin() {
		design();
		conn=SQLConnection.ConnerDb();
		
	}
	private void login() {
		try {
			
			String query="Select * from admin where username=? and Password =?"; 
			pst=conn.prepareStatement(query);
			pst.setString(1, textField.getText());
			pst.setString(2, passwordField.getText());
			
			rs=pst.executeQuery();
			
			if(rs.next()) {
				//JOptionPane.showMessageDialog(null,"Login Successful");
				
				choseadmin ch=new choseadmin();
				ch.setVisible(true);
				dispose();
				
				
				
				
				
				
			}else {
				JOptionPane.showMessageDialog(null,"Login Failed");
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
		
		private void design() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setBounds(178, 39, 197, 35);
		contentPane.add(lblAdminLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(58, 110, 121, 35);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(58, 181, 121, 35);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(223, 118, 246, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 181, 246, 27);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBounds(223, 241, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(380, 242, 89, 23);
		contentPane.add(btnNewButton);
	}

}
