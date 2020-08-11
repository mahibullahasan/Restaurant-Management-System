import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame {

	private JPanel contentPane;
	
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
					Homepage frame = new Homepage();
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
	public Homepage(){
		design();
		conn= SQLConnection.ConnerDb();
		
	}
		
		
		
		private void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin ch=new adminlogin();
				ch.setVisible(true);
				dispose();
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAdmin.setBounds(173, 114, 196, 58);
		contentPane.add(btnAdmin);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeelogin ch=new employeelogin();
				ch.setVisible(true);
				dispose();
			}
		});
		btnEmployee.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEmployee.setBounds(173, 220, 196, 58);
		contentPane.add(btnEmployee);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(102, 11, 328, 49);
		contentPane.add(lblNewLabel);
	}

}
